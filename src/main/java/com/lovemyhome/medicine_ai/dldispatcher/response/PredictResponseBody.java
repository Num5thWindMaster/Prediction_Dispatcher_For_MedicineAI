package com.lovemyhome.medicine_ai.dldispatcher.response;// -*- coding: utf-8 -*-

import com.lovemyhome.medicine_ai.dldispatcher.commons.core.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Author : HaiqingSun
// @Time : 2023/7/23 22:08
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PredictResponseBody extends AbstractResponse {
    private String smiles;
    private String probability;

    public PredictResponseBody(String line) {
        String[] s = line.split(" ");
        this.smiles = s[0].trim();
        this.probability = s[1].trim();
    }
}
