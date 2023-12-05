package com.lovemyhome.medicine_ai.dldispatcher.commons.result;// -*- coding: utf-8 -*-

// @Author : HaiqingSun
// @Time : 2023/7/23 21:47
public enum SysRetCodeConstants {
    // 系统公用
    SUCCESS                             ("000000", "成功"),
    REQUEST_FORMAT_ILLEGAL              ("010000", "文件或数据格式非法"),
    REQUISITE_PARAMETER_NOT_EXIST       ("020000", "文件或数据不能为空"),
    SYSTEM_TIMEOUT                      ("004000", "系统超时"),
    SYSTEM_ERROR                        ("005000", "系统错误"),
    FILENAME_LENGTH_EXCEEDED ("011000", "文件名长度超过15字符");

    private String code;
    private String message;

    SysRetCodeConstants(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>message</tt>.
     *
     * @return property value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter method for property <tt>message</tt>.
     *
     * @param message value to be assigned to property message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public static String getMessage(String code) {
        for (SysRetCodeConstants s : SysRetCodeConstants.values()) {
            if (null == code)
                break;
            if (s.code.equals(code)) {
                return s.message;
            }
        }
        return null;
    }
}