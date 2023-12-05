package com.lovemyhome.medicine_ai.dldispatcher.commons.result;// -*- coding: utf-8 -*-            

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Author : HaiqingSun
// @Time : 2023/12/3 22:02
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTIPredictionResult {
    String smiles;
    String targetName;
    String Probability;
}
