package com.lovemyhome.medicine_ai.dldispatcher.response;// -*- coding: utf-8 -*-            

// @Author : HaiqingSun
// @Time : 2023/12/13 20:21

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultiViewResponse {
    private int index;
    private String mole;
    private String score;
}
