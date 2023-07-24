package com.lovemyhome.medicine_ai.dldispatcher.commons.core;// -*- coding: utf-8 -*-

// @Author : HaiqingSun
// @Time : 2023/7/23 21:41
public abstract class AbstractResponse {
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
