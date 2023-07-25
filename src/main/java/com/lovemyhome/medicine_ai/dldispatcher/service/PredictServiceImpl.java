package com.lovemyhome.medicine_ai.dldispatcher.service;// -*- coding: utf-8 -*-
import com.lovemyhome.medicine_ai.dldispatcher.api.PredictService;
import com.lovemyhome.medicine_ai.dldispatcher.commons.result.SysRetCodeConstants;
import com.lovemyhome.medicine_ai.dldispatcher.dao.PredictResponseBody;
import com.lovemyhome.medicine_ai.dldispatcher.dao.UploadResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.charset.StandardCharsets.UTF_8;

// @Author : HaiqingSun
// @Time : 2023/7/21 12:14
@Component
@Service
public class PredictServiceImpl implements PredictService {

    @Value("${file.uploadFolder}")
    private String dir;
    @Value("${file.pythonFolder}")
    private String pythonFolder;
    @Value("${py.module}")
    private String pyModule;
    @Value("${py.function}")
    private String pyFunc;
//    private static ConfigurationDao configurationDao = new ConfigurationDao();

    @Override
    public UploadResponseBody getUploadedFile(MultipartFile file){
        String name = file.getOriginalFilename();
        UploadResponseBody responseBody = new UploadResponseBody();
        if (name == null){//空
            responseBody.setCode(SysRetCodeConstants.REQUISITE_PARAMETER_NOT_EXIST.getCode());
            return responseBody;
        }
        if ( !name.endsWith(".csv") && !name.endsWith(".txt")){//非序列格式
            responseBody.setCode(SysRetCodeConstants.REQUEST_FORMAT_ILLEGAL.getCode());
            return responseBody;
        }
        if (file.getSize() > 1024){//文件过大
            responseBody.setCode(SysRetCodeConstants.REQUEST_FORMAT_ILLEGAL.getCode());
            return responseBody;
        }


        String path2 = null;
        String dirPath = null;
        try {
            path2 = ResourceUtils.getURL("classpath:static").getPath().replaceFirst("^/+", "") ;
            dirPath = path2 + dir;
            Files.createDirectories(Paths.get(dirPath));
            String dirPath2 =dirPath + "/" + System.currentTimeMillis() + file.getName();
            Path path = Files.createFile(Paths.get(dirPath2));
            file.transferTo(path);
            responseBody.setCode(SysRetCodeConstants.SUCCESS.getCode());
            responseBody.setPath(path);
        } catch (IOException e) {
//            log.error("File not found");
//            log.error(e.getMessage(), e);
            e.printStackTrace();
            responseBody.setCode(SysRetCodeConstants.SYSTEM_ERROR.getCode());
        } finally {
            return responseBody;
        }
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
    public PredictResponseBody getPrediction(String smiles){
        PredictResponseBody responseBody = new PredictResponseBody();
//        SmilesParserWrapper smilesParser = new SmilesParserWrapper();
//        try {
//            smilesParser.parseSmiles(smiles);
//            return true;
//        } catch (CDKException e) {
//            // 如果SMILES序列不合法，将会抛出CDKException异常
//            return false;
//        }
        //未做Smiles序列验证逻辑
        String path = null;
        try {
            path = ResourceUtils.getURL("classpath:static").getPath().replaceFirst("^/+", "") + pythonFolder;
            URL path0 = ResourceUtils.getURL("classpath:static");
            String str1 = path0.getPath();
        } catch (FileNotFoundException e) {
//            log.error(e.getMessage());
            responseBody.setCode(SysRetCodeConstants.SYSTEM_ERROR.getCode());
            return responseBody;
        }
        String pythonScriptPath = path + "/" + pyModule; //Python脚本路径

        try {
            // 构建ProcessBuilder对象
            ProcessBuilder pb = new ProcessBuilder("python", pythonScriptPath, smiles);
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
//            log.error(e.getMessage());
            responseBody.setCode(SysRetCodeConstants.SYSTEM_ERROR.getCode());
        } finally {
            return responseBody;
        }
    }
    @Override
    public PredictResponseBody getPrediction(Path path){
        try {
            BufferedReader bfr = Files.newBufferedReader(path, UTF_8);
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = bfr.readLine()) != null){
                sb.append(line);
            }
            String content = sb.toString();
//            log.info("Smile get: " + content);
            return getPrediction(content);
        } catch (IOException e) {
//            log.error(e.getMessage());
            return null;
        }
    }
}

//class PythonRunner {
//
//    public String runPythonFunction(String functionName, String... args) {
//        try {
//            // 构建Python命令，调用hello.py中的greet函数，并传递参数
//            ProcessBuilder pb = new ProcessBuilder("python", "hello.py", functionName, String.join(",", args));
//            pb.redirectErrorStream(true);
//
//            // 启动进程
//            Process process = pb.start();
//
//            // 读取Python函数的输出
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            StringBuilder output = new StringBuilder();
//            while ((line = reader.readLine()) != null) {
//                output.append(line);
//            }
//
//            // 等待进程执行结束
//            int exitCode = process.waitFor();
//            if (exitCode == 0) {
//                return output.toString();
//            } else {
//                return "Error: Python process returned non-zero exit code.";
//            }
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//            return "Error: Exception occurred while running Python function.";
//        }
//    }
//}
