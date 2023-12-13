package com.lovemyhome.medicine_ai.dldispatcher.commons.request;// -*- coding: utf-8 -*-            

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// @Author : HaiqingSun
// @Time : 2023/12/13 11:57
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTIPredictionRequestBody {
    String inputsmiles;
    MultipartFile file;
    List<String> form_check_target;
    String option_datasource;
    String jsmeSmile;
}
