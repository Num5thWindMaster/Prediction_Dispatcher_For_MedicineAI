package com.lovemyhome.medicine_ai.dldispatcher.controller;// -*- coding: utf-8 -*-


import com.lovemyhome.medicine_ai.dldispatcher.api.PredictService;
import com.lovemyhome.medicine_ai.dldispatcher.commons.result.DTIPredictionResult;
import com.lovemyhome.medicine_ai.dldispatcher.commons.result.ResponseData;
import com.lovemyhome.medicine_ai.dldispatcher.commons.result.ResponseUtil;
import com.lovemyhome.medicine_ai.dldispatcher.commons.result.SysRetCodeConstants;
import com.lovemyhome.medicine_ai.dldispatcher.dao.PredictResponseBody;
import com.lovemyhome.medicine_ai.dldispatcher.dao.UploadResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

// @Author : HaiqingSun
// @Time : 2023/7/21 14:30

@RestController
@RequestMapping("/request")
public class ConverterController {

    PredictService predictService;

    @Autowired
    public ConverterController(PredictService predictService){
        this.predictService = predictService;
    }

    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (Objects.equals(file, null)){
            return new ResponseUtil<>().setErrorMsg("No file selected");
        }
        if (file.getSize() > 10240) {
            return new ResponseUtil<>().setErrorMsg("Too large file");
        }
        UploadResponseBody uploadResponseBody = predictService.getUploadedFile(file, request);
        if (!Objects.equals(uploadResponseBody.getCode(), "000000")) {
            return new ResponseUtil<>().setErrorMsg(500, SysRetCodeConstants.getMessage(uploadResponseBody.getCode()));//501上传错误，502格式错误，500系统错误
        }
        List<DTIPredictionResult> resultList = predictService.getDTIPrediction(uploadResponseBody.getPath().toString(), "lyn");
        if (resultList != null){
            return new ResponseUtil<>().setData(resultList);
        }
        return new ResponseUtil<>().setErrorMsg(SysRetCodeConstants.getMessage("005000"));

    }
    @GetMapping("/submit")
    public ResponseData submitSmilesSequence(@RequestParam("smiles")String smiles, HttpServletRequest request){
        List<DTIPredictionResult> resultList = predictService.getDTIPrediction(smiles, "lyn", "default");
        if (resultList != null){
            return new ResponseUtil<>().setData(resultList);
        }
        return new ResponseUtil<>().setErrorMsg(500, "System Error");

    }

//    @ExceptionHandler(Exception.class)
//    @RequestMapping("/error")
//    public ResponseData error() {
//        System.out.println("这是一个错误信息");
//        return new ResponseUtil<>().setErrorMsg("系统发生了错误");
//
//    }
//    @GetMapping("/error")
}
//    @PostMapping
//    public ResponseData submitSmileSerial(HttpServletRequest request) {
//        PredictResponseBody response = predictService.getPrediction(request.getParameter("smile"));
//        response =
//        if (response.getCode().equals(SysRetCodeConstants.SUCCESS.getCode())) {
//            return new ResponseUtil().setData(response.);
//        }
//        return new ResponseUtil().setErrorMsg(response.getMsg());
//    }
//}
