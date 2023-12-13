package com.lovemyhome.medicine_ai.dldispatcher.service;// -*- coding: utf-8 -*-
import com.lovemyhome.medicine_ai.dldispatcher.api.PredictService;
import com.lovemyhome.medicine_ai.dldispatcher.commons.request.DTIPredictionRequestBody;
import com.lovemyhome.medicine_ai.dldispatcher.commons.result.DTIPredictionResult;
import com.lovemyhome.medicine_ai.dldispatcher.commons.result.SysRetCodeConstants;
import com.lovemyhome.medicine_ai.dldispatcher.response.MultiViewResponse;
import com.lovemyhome.medicine_ai.dldispatcher.response.PredictResponseBody;
import com.lovemyhome.medicine_ai.dldispatcher.response.UploadResponseBody;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openscience.cdk.smiles.SmilesParser;
import org.openscience.cdk.exception.InvalidSmilesException;

import javax.servlet.http.HttpServletRequest;

import static java.nio.charset.StandardCharsets.UTF_8;

// @Author : HaiqingSun
// @Time : 2023/7/21 12:14
@Component
@Service
public class PredictServiceImpl implements PredictService {

    @Value("${file.uploadFolder}")
    private String dir;
    @Value("${file.MF_MPRFolder}")
    private String MF_MPRFolder;
    @Value("${file.AIGO_DTIFolder}")
    private String AIGO_DTIFolder;
    @Value("${py.module.lyn}")
    private String MF_MPRModule;
    @Value("${py.module.tlr4}")
    private String AIGO_DTIModule;
//    @Value("${py.function}")
//    private String pyFunc;
    @Value("${py.module.params}")
    private String pyParams;
    @Value("${file.CalBase64}")
    private String calBase64;
    @Value("${file.model_pt}")
    private String modelPt;

    private final String baseDir;
    private static final Logger LOGGER = Logger.getLogger(PredictServiceImpl.class.getName());

    private static boolean isValidSmiles(String smilesString) {
        SmilesParser smilesParser = new SmilesParser(DefaultChemObjectBuilder.getInstance());
        try {
            // Try to parse the SMILES string
            IAtomContainer iAtomContainer = smilesParser.parseSmiles(smilesString);
            return true; // If parsing succeeds, the string is a valid SMILES sequence
        } catch (InvalidSmilesException e) {
            return false; // If parsing fails, the string is not a valid SMILES sequence
        }
    }

    private static boolean isValidCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            new CSVParser().parseLine(reader.readLine()); // Try to parse the first line
            return true; // If parsing succeeds, it's a CSV file
        } catch (IOException e) {
            return false; // Parsing failed, not a CSV file
        }
    }

    @Override
    public String convertToCsv(String smiles, String sequence) {
        // 文件路径
        String directory = baseDir + dir + File.separator;
        String filePath = baseDir + dir + File.separator + System.currentTimeMillis() + ".csv";
        LOGGER.log(Level.INFO, "directory: " + directory + "\nfilePath: " + filePath);
        try {
            Files.createDirectories(Paths.get(directory));
            Files.createFile(Paths.get(filePath));
            CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath), ',', CSVWriter.NO_QUOTE_CHARACTER, '"', "\n");
            // 定义列名
            String[] header = {"SMILES", "SEQUENCES"};
            csvWriter.writeNext(header);

            // 添加SMILES数据行
            String[] data = {smiles, sequence};
            csvWriter.writeNext(data);

            System.out.println("CSV 文件已生成：" + filePath);
            csvWriter.close();
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String convertToCsv(String smiles) {
        // 文件路径
        String directory = baseDir + dir + File.separator;
        String filePath = baseDir + dir + File.separator + System.currentTimeMillis() + ".csv";
        LOGGER.log(Level.INFO, "directory: " + directory + "\nfilePath: " + filePath);
        try {
            Files.createDirectories(Paths.get(directory));
            Files.createFile(Paths.get(filePath));
            CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath), ',', CSVWriter.NO_QUOTE_CHARACTER, '"', "\n");
            // 定义列名
            String[] header = {"SMILES"};
            csvWriter.writeNext(header);

            // 添加SMILES数据行
            String[] data = {smiles};
            csvWriter.writeNext(data);

            System.out.println("CSV 文件已生成：" + filePath);
            csvWriter.close();
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public PredictServiceImpl() {
        baseDir = System.getProperty("user.dir");
        LOGGER.log(Level.INFO, "baseDir: " + baseDir);
    }
//    private static ConfigurationDao configurationDao = new ConfigurationDao();

    @Override
    public UploadResponseBody getUploadedFile(MultipartFile file, String task, HttpServletRequest request) {
        String name = file.getOriginalFilename();
        UploadResponseBody responseBody = new UploadResponseBody();
        if (name == null) {//空
            responseBody.setCode(SysRetCodeConstants.REQUISITE_PARAMETER_NOT_EXIST.getCode());
            return responseBody;
        }
//        if ( !name.endsWith(".csv") && !name.endsWith(".txt")){//非序列格式
        if (!name.endsWith(".csv")) {//非序列格式
            responseBody.setCode(SysRetCodeConstants.REQUEST_FORMAT_ILLEGAL.getCode());
            return responseBody;
        }
        if (name.length() > 15) {//文件名过长
            responseBody.setCode(SysRetCodeConstants.FILENAME_LENGTH_EXCEEDED.getCode());
            return responseBody;
        }
        if (file.getSize() > 10240) {//文件过大
            responseBody.setCode(SysRetCodeConstants.REQUEST_FORMAT_ILLEGAL.getCode());
            return responseBody;
        }


        String path2 = null;
        String dirPath;
        try {
//            path2 = ResourceUtils.getURL("classpath:static").getPath().replaceFirst("^/+", "") ;
//            dirPath = path2 + dir;
            LOGGER.log(Level.INFO, "WorkSpace path: " + System.getProperty("user.dir"));
            dirPath = baseDir + dir;
            Files.createDirectories(Paths.get(dirPath));
            String dirPath2 = dirPath + File.separator + System.currentTimeMillis() + "_" + task + "_" + name;
            Path path = Files.createFile(Paths.get(dirPath2));
            file.transferTo(path);
            if (!isValidCSV(dirPath2)) {
                responseBody.setCode(SysRetCodeConstants.REQUEST_FORMAT_ILLEGAL.getCode());
                return responseBody;
            }
            responseBody.setCode(SysRetCodeConstants.SUCCESS.getCode());
            responseBody.setPath(path);
        } catch (IOException e) {
//            log.error("File not found");
//            log.error(e.getMessage(), e);
            LOGGER.log(Level.SEVERE, "Smiles File IOException.");
            e.printStackTrace();
            responseBody.setCode(SysRetCodeConstants.SYSTEM_ERROR.getCode());
        }
        return responseBody;

    }

    /*

     */
//    public static void setConfigurationDao() {
////        Yaml yaml = new Yaml();
////        try {
////            // 1. 使用 FileInputStream 读取 YAML 文件
////            FileInputStream inputStream = new FileInputStream("application.yml");
////            ConfigurationDao dao = new ConfigurationDao();
////            // 2. 使用 ClassLoader 读取 YAML 文件（适用于 JAR 中的文件）
////            // InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("application.yml");
////
////            // 将 YAML 文件内容解析为Map
////            Map<String, Object> data = yaml.load(inputStream);
////
////            // 读取配置项
////            Map<String, String> pyDataConfig = (Map<String, String>) data.get("py");
////            String path = pyDataConfig.get("path");
////            String module = pyDataConfig.get("module");
////            String function = pyDataConfig.get("function");
////            dao.setPath(path);
////            dao.setModule(module);
////            dao.setFunction(function);
//
//            // 使用读取到的常量
//
//            System.out.println("Config module: " + module);
//            System.out.println("Config function: " + function);
//
//            inputStream.close();
//            configurationDao = dao;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    @Override
    public PredictResponseBody getPrediction(String smiles) {
        PredictResponseBody responseBody = new PredictResponseBody();
        if (null == smiles || !isValidSmiles(smiles)) {
            responseBody.setCode(SysRetCodeConstants.REQUEST_FORMAT_ILLEGAL.getCode());
            responseBody.setMsg("Invalid Smiles");
            return responseBody;
        }
        //上面为Smiles有效性检测
//        pyParams = smiles;
        String path = null;
        try {
            path = (ResourceUtils.getURL("classpath:private").getPath().startsWith("/var") ? ResourceUtils.getURL("classpath:private").getPath() : ResourceUtils.getURL("classpath:private").getPath().replaceFirst("/", "")) + MF_MPRFolder;
//            LOGGER.log(Level.INFO, "Resource Check: " + path);
//            URL path0 = ResourceUtils.getURL("classpath:static");
//            String str1 = path0.getPath();
        } catch (FileNotFoundException e) {
//            log.error(e.getMessage());
            responseBody.setCode(SysRetCodeConstants.SYSTEM_ERROR.getCode());
            return responseBody;
        }
        String pythonScriptPath = path + "/" + MF_MPRModule; //Python脚本路径

        try {
            // 构建ProcessBuilder对象
            ProcessBuilder pb = new ProcessBuilder("python", pythonScriptPath, pyParams);
            // 启动外部进程

            Process process = pb.start();
            // 获取进程输出流
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            // 读取Python脚本的返回值
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            // 等待进程执行完成
            int exitCode = process.waitFor();
            // 输出Python脚本的返回值
            String c = result.toString();
//            log.info("Python脚本返回值：" + c);
//            log.info("Python脚本执行状态：" + exitCode);
            responseBody.setCode(SysRetCodeConstants.SUCCESS.getCode());
            responseBody.setMsg("预测完成");
            responseBody.setProbability(c);
            responseBody.setSmiles(smiles);
        } catch (IOException | InterruptedException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            responseBody.setCode(SysRetCodeConstants.SYSTEM_ERROR.getCode());
        } finally {
            return responseBody;
        }
    }

    @Override
    public PredictResponseBody getPrediction(Path path) {
        try {
            BufferedReader bfr = Files.newBufferedReader(path, UTF_8);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bfr.readLine()) != null) {
                sb.append(line);
            }
            String content = sb.toString();
//            log.info("Smile get: " + content);
            return getPrediction(content);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
    @Override
    public List<DTIPredictionResult> getDTIPrediction(String smiles, String sequence, String pyScriptPath) {
        String path = convertToCsv(smiles);
        LOGGER.log(Level.INFO, "DTIPredictionWithInputTaskReceived, path=" + path);
        List<DTIPredictionResult> resultList = getDTIPrediction(path, pyScriptPath);
        try {
            File path0=new File(ResourceUtils.getURL("classpath:").getPath());
            LOGGER.info("Absolute Path: " + path0.getAbsolutePath());
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
//        if(!path0.exists()){
//            path=new File("");
//        }
        return resultList;
    }

    @Override
    public List<DTIPredictionResult> getDTIPrediction(String path, String pyScriptType) {
        LOGGER.log(Level.INFO, "DTIPredictionWithCSVTaskReceived.");
        List<DTIPredictionResult> responseList = new ArrayList<>();
        String module = null;
        String pythonScriptPath = null;
        String command = null;
        switch (pyScriptType) {
            case "LYN":
                pythonScriptPath = MF_MPRFolder + File.separator + MF_MPRModule;
                StringBuilder sb = new StringBuilder();
                command = sb.append("python ")
                        .append(pythonScriptPath)
                        .append(" ")
                        .append(pyParams)
                        .append(" --predict_path ")
                        .append(path)
                        .append(" --model_path ")
                        .append(MF_MPRFolder)
                        .append(File.separator)
                        .append(modelPt)
                        .toString();
                LOGGER.log(Level.WARNING, "command: " + command);
                try {
                    // Construct the command to execute the Python script

                    // Execute the command
                    Process process = Runtime.getRuntime().exec(command);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                    // Read the output of the Python script
                    String line;
                    //            StringBuilder output = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        //                PredictResponseBody responseItem = new PredictResponseBody(line);
                        //                    String[] row = line.split(",");
                        //                    DTIPredictionResult result = new DTIPredictionResult(row[0], row[1], row[2]);
                        //                    responseList.add(result);
                        if (!line.endsWith(".csv"))
                            continue;
                        String resultPath = baseDir + File.separator + line;
                        try (CSVReader csvReader = new CSVReader(new FileReader(resultPath))) {
                            List<String[]> lines = csvReader.readAll();

                            // 第一行通常是标题，跳过
                            String[] head = lines.get(0);
                            lines.remove(0);

                            for (String[] line0 : lines) {
                                // 按照CSV文件中的顺序封装为对象
                                DTIPredictionResult result = new DTIPredictionResult(line0[0], head[6], line0[6]);
                                responseList.add(result);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    // Wait for the process to finish
                    process.waitFor();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "TLR4":
                pythonScriptPath = AIGO_DTIFolder + File.separator + AIGO_DTIModule;
                StringBuilder sb2 = new StringBuilder();
                command = sb2.append("python ")
                        .append(pythonScriptPath)
                        .append(" ")
                        .append(pyParams)
                        .append(" --test_path ")
                        .append(path).toString();
                try {
                    // Construct the command to execute the Python script
                    // Execute the command
                    Process process = Runtime.getRuntime().exec(command);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    // Read the output of the Python script
                    String line;
                    //            StringBuilder output = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        //                PredictResponseBody responseItem = new PredictResponseBody(line);
                        //                    String[] row = line.split(",");
                        //                    DTIPredictionResult result = new DTIPredictionResult(row[0], row[1], row[2]);
                        //                    responseList.add(result);
//                        if (!line.endsWith(".csv"))
//                            continue;
                        if (line.startsWith("[") && line.endsWith("]")) {
                            String tmp1 = line.replaceAll("[\\[\\]]", "").trim();
                            String[] tmp2 = tmp1.split("\\s+");
                            try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
                                List<String[]> lines = csvReader.readAll();

                                // 第一行通常是标题，跳过
                                String[] head = lines.get(0);
                                lines.remove(0);
                                int i = 0;
                                for (String[] line0 : lines) {
                                    // 按照CSV文件中的顺序封装为对象
                                    DTIPredictionResult result = new DTIPredictionResult(line0[0], pyScriptType, tmp2[i]);
                                    responseList.add(result);
                                    i++;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        // Wait for the process to finish
                        process.waitFor();
                    }
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                break;
        }
            return responseList;
    }

    @Override
    public List<MultiViewResponse> getDTIPredictionByMultitask(DTIPredictionRequestBody requestBody, HttpServletRequest request) {
        //smile数据源验证
        if ("smiles".equals(requestBody.getOption_datasource()) && (requestBody.getInputsmiles() == null || "".equals(requestBody.getInputsmiles()))){
            return null;
        }

        if ("csv".equals(requestBody.getOption_datasource()) && (requestBody.getFile() == null || requestBody.getFile().getSize() == 0)) {
            return null;
        }
        if ("jsme".equals(requestBody.getOption_datasource()) && (requestBody.getJsmeSmile() == null || "".equals(requestBody.getJsmeSmile()))) {
            return null;
        }
        List<DTIPredictionResult> resultList = null;
        List<MultiViewResponse> responseList = new ArrayList<>();
        switch(requestBody.getOption_datasource()) {
            case "csv":
                UploadResponseBody uploadedFile = getUploadedFile(requestBody.getFile(), requestBody.getForm_check_target().get(0), request);
                if (!Objects.equals(uploadedFile.getCode(), "000000")) {
                    return null;
                }
                String path = uploadedFile.getPath().toString();
                resultList = getDTIPrediction(path, requestBody.getForm_check_target().get(0));
                break;
            case "jsme":
                requestBody.setInputsmiles(requestBody.getJsmeSmile());
            case "smiles":
                resultList = getDTIPrediction(requestBody.getInputsmiles(), "default", requestBody.getForm_check_target().get(0));
                break;
        }
        for (int i = 0; i < resultList.size(); i++) {
            DTIPredictionResult predictionResult = resultList.get(i);
            StringBuilder sb = new StringBuilder();
            String command = sb.append("python ")
                    .append(calBase64).append(" ").append(resultList.get(i).getSmiles()).toString();
//        LOGGER.log(Level.WARNING, "command: " + command);
            try {
                Process process = Runtime.getRuntime().exec(command);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                // Read the output of the Python script
                String line = reader.readLine();
                sb = new StringBuilder();
                String base64 = sb.append("data:image/svg+xml;base64,").append(line).toString();
                MultiViewResponse multiViewResponse = new MultiViewResponse(i + 1, base64, predictionResult.getProbability());
                responseList.add(multiViewResponse);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return responseList;
    }
}

