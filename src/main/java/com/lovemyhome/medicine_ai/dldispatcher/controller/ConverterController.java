package com.lovemyhome.medicine_ai.dldispatcher.controller;// -*- coding: utf-8 -*-


import com.lovemyhome.medicine_ai.dldispatcher.api.PredictService;
import com.lovemyhome.medicine_ai.dldispatcher.commons.result.ResponseData;
import com.lovemyhome.medicine_ai.dldispatcher.commons.result.ResponseUtil;
import com.lovemyhome.medicine_ai.dldispatcher.commons.result.SysRetCodeConstants;
import com.lovemyhome.medicine_ai.dldispatcher.dao.PredictResponseBody;
import com.lovemyhome.medicine_ai.dldispatcher.dao.UploadResponseBody;
import org.apache.dubbo.config.annotation.Reference;
import com.lovemyhome.medicine_ai.dldispatcher.service.PredictServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

// @Author : HaiqingSun
// @Time : 2023/7/21 14:30
@Slf4j
@RestController
@RequestMapping("/")
public class ConverterController {

    PredictService predictService;

    @Autowired
    public ConverterController(PredictService predictService){
        this.predictService = predictService;
    }

    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file") MultipartFile file) {
        if (Objects.equals(file, null)){
            return new ResponseUtil<>().setErrorMsg("未选择文件，请重新选择文件上传");
        }
        if (file.getSize() > 1024) {
            return new ResponseUtil<>().setErrorMsg("文件过大，请检查");
        }
        UploadResponseBody uploadResponseBody = predictService.getUploadedFile(file);
        if (!Objects.equals(uploadResponseBody.getCode(), "000000")) {
            return new ResponseUtil<>().setErrorMsg(500, SysRetCodeConstants.getMessage(uploadResponseBody.getCode()));//501上传错误，502格式错误，500系统错误
        }
        PredictResponseBody responseBody = predictService.getPrediction(uploadResponseBody.getFile());
        if (Objects.equals(responseBody.getCode(), SysRetCodeConstants.SUCCESS.getCode())){
            return new ResponseUtil<>().setData(responseBody);
        }
        return new ResponseUtil<>().setErrorMsg(SysRetCodeConstants.getMessage(responseBody.getCode()));

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
