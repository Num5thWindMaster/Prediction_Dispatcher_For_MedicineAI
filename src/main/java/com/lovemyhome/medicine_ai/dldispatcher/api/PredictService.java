package com.lovemyhome.medicine_ai.dldispatcher.api;// -*- coding: utf-8 -*-            

import com.lovemyhome.medicine_ai.dldispatcher.dao.PredictResponseBody;
import com.lovemyhome.medicine_ai.dldispatcher.dao.UploadResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Path;

// @Author : HaiqingSun
// @Time : 2023/7/24 3:02
public interface PredictService {
    UploadResponseBody getUploadedFile(MultipartFile file, HttpServletRequest request);

    PredictResponseBody getPrediction(String smile);

    PredictResponseBody getPrediction(Path path);
}
