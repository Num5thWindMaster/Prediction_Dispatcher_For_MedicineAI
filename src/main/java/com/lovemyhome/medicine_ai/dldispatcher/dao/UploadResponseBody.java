package com.lovemyhome.medicine_ai.dldispatcher.dao;// -*- coding: utf-8 -*-            

import com.lovemyhome.medicine_ai.dldispatcher.commons.core.AbstractResponse;
import lombok.Data;

import java.io.File;

// @Author : HaiqingSun
// @Time : 2023/7/24 1:05
@Data
public class UploadResponseBody extends AbstractResponse {
    private File file;
}
