package com.lovemyhome.medicine_ai.dldispatcher.api;// -*- coding: utf-8 -*-            

import com.lovemyhome.medicine_ai.dldispatcher.commons.request.DTIPredictionRequestBody;
import com.lovemyhome.medicine_ai.dldispatcher.commons.result.DTIPredictionResult;
import com.lovemyhome.medicine_ai.dldispatcher.response.PredictResponseBody;
import com.lovemyhome.medicine_ai.dldispatcher.response.UploadResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;
import java.util.List;

// @Author : HaiqingSun
// @Time : 2023/7/24 3:02
public interface PredictService {
    String convertToCsv(String smiles, String sequences);

    String convertToCsv(String smiles);

    UploadResponseBody getUploadedFile(MultipartFile file, String task, HttpServletRequest request);

    PredictResponseBody getPrediction(String smile);

    PredictResponseBody getPrediction(Path path);

    List<DTIPredictionResult> getDTIPrediction(String smiles, String sequence, String pyScriptType);

    List<DTIPredictionResult> getDTIPrediction(String path, String pyScriptType);

    List getDTIPredictionByMultitask(DTIPredictionRequestBody requestBody, HttpServletRequest request);

//    PredictResponseBody getPrediction(String pythonScriptPath, String inputParameter);
}
