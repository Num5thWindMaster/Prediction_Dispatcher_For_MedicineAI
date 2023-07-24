package com.lovemyhome.medicine_ai.dldispatcher.dao;// -*- coding: utf-8 -*-

import com.lovemyhome.medicine_ai.dldispatcher.commons.core.AbstractResponse;
import lombok.Data;

// @Author : HaiqingSun
// @Time : 2023/7/23 22:08
@Data
public class PredictResponseBody extends AbstractResponse {
    private String smiles;
    private String probability;
}
