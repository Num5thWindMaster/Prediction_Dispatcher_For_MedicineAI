package com.lovemyhome.medicine_ai.dldispatcher.api;// -*- coding: utf-8 -*-            

import com.lovemyhome.medicine_ai.dldispatcher.dao.PredictResponseBody;
import com.lovemyhome.medicine_ai.dldispatcher.dao.UploadResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

// @Author : HaiqingSun
// @Time : 2023/7/24 3:02
public interface PredictService {
    UploadResponseBody getUploadedFile(MultipartFile file);

    PredictResponseBody getPrediction(String smile);

    PredictResponseBody getPrediction(File file);
}
