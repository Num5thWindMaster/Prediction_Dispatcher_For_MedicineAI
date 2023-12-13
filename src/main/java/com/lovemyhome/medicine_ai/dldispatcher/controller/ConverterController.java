package com.lovemyhome.medicine_ai.dldispatcher.controller;// -*- coding: utf-8 -*-


import com.lovemyhome.medicine_ai.dldispatcher.api.PredictService;
import com.lovemyhome.medicine_ai.dldispatcher.commons.request.DTIPredictionRequestBody;
import com.lovemyhome.medicine_ai.dldispatcher.commons.result.DTIPredictionResult;
import com.lovemyhome.medicine_ai.dldispatcher.commons.result.ResponseData;
import com.lovemyhome.medicine_ai.dldispatcher.commons.result.ResponseUtil;
import com.lovemyhome.medicine_ai.dldispatcher.commons.result.SysRetCodeConstants;
import com.lovemyhome.medicine_ai.dldispatcher.response.MultiViewResponse;
import com.lovemyhome.medicine_ai.dldispatcher.response.UploadResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

// @Author : HaiqingSun
// @Time : 2023/7/21 14:30

@Controller
@RequestMapping("/request")
public class ConverterController {

    PredictService predictService;

    HashSet<String> tasks;
    HashSet<String> submitType;

    @Autowired
    public ConverterController(PredictService predictService, HashSet<String> tasks, HashSet<String> submitType) {
        this.predictService = predictService;
        this.tasks = tasks;
        tasks.add("LYN");
        tasks.add("TLR4");
        this.submitType = submitType;
        submitType.add("smiles");
        submitType.add("jsme");
        submitType.add("csv");
    }

    @ResponseBody
    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("task") String task, HttpServletRequest request) {
        if (Objects.equals(file, null)) {
            return new ResponseUtil<>().setErrorMsg("No file selected");
        }
        if (file.getSize() > 10240) {
            return new ResponseUtil<>().setErrorMsg("Too large file");
        }
        if (task == null || "".equals(task) || !tasks.contains(task)) {
            return new ResponseUtil<>().setErrorMsg("Task not supported");
        }
        UploadResponseBody uploadResponseBody = predictService.getUploadedFile(file, task, request);
        if (!Objects.equals(uploadResponseBody.getCode(), "000000")) {
            return new ResponseUtil<>().setErrorMsg(500, SysRetCodeConstants.getMessage(uploadResponseBody.getCode()));//501上传错误，502格式错误，500系统错误
        }
        List<DTIPredictionResult> resultList = predictService.getDTIPrediction(uploadResponseBody.getPath().toString(), task);
        if (resultList != null && resultList.size() != 0) {
            return new ResponseUtil<>().setData(resultList);
        }
        return new ResponseUtil<>().setErrorMsg(SysRetCodeConstants.getMessage("005000"));

    }

    @ResponseBody
    @GetMapping("/submit")
    public ResponseData submitSmilesSequence(@RequestParam("smiles") String smiles, @RequestParam("task") String task, HttpServletRequest request) {
        if (task == null || "".equals(task) || !tasks.contains(task)) {
            return new ResponseUtil<>().setErrorMsg("Task not supported");
        }
        List<DTIPredictionResult> resultList = predictService.getDTIPrediction(smiles, "default", task);
        if (resultList != null && resultList.size() != 0) {
            return new ResponseUtil<>().setData(resultList);
        }
        return new ResponseUtil<>().setErrorMsg(SysRetCodeConstants.getMessage("005000"));

    }

    //    @ExceptionHandler(Exception.class)
//    @RequestMapping("/error")
//    public ResponseData error() {
//        System.out.println("这是一个错误信息");
//        return new ResponseUtil<>().setErrorMsg("系统发生了错误");
//
//    }
//    @GetMapping("/error")
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
    @PostMapping("/result")
    public String submitMultiSelection(Model model, @ModelAttribute DTIPredictionRequestBody requestBody, HttpServletRequest request) {
        if (requestBody == null) {
            model.addAttribute("errorCode", 500);
            model.addAttribute("errorMsg", "Request Params Error!");
            model.addAttribute("solveTips", "Please check your request params and retry.");
            return "problem";
        }
        if (requestBody.getForm_check_target() == null || !tasks.contains(requestBody.getForm_check_target().get(0))) {
            model.addAttribute("errorCode", 500);
            model.addAttribute("errorMsg", "Request Task Undefined!");
            model.addAttribute("solveTips", "Please check your task type and retry.");
            return "problem";
        }
        if (requestBody.getOption_datasource() == null || !submitType.contains(requestBody.getOption_datasource())) {
            model.addAttribute("errorCode", 500);
            model.addAttribute("errorMsg", "Request Datasource Undefined!");
            model.addAttribute("solveTips", "Please check your datasource type and retry.");
            return "problem";
        }
        if (("slimes".equals(requestBody.getOption_datasource()) && requestBody.getInputsmiles().length() > 1024) || ("jsme".equals(requestBody.getOption_datasource()) && requestBody.getJsmeSmile().length() > 1024) || ("csv".equals(requestBody.getOption_datasource()) && requestBody.getFile().getSize() > 1024)) {
            model.addAttribute("errorCode", 500);
            model.addAttribute("errorMsg", "Request Data Length Exceed Limit!(1KB)");
            model.addAttribute("solveTips", "Please check your data size and retry.");
            return "problem";
        }
        List<MultiViewResponse> list = predictService.getDTIPredictionByMultitask(requestBody, request);
        model.addAttribute("resultItems", list);
        return "result";
    }

}
