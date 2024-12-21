package com.lijin.study.springcloud.common.entity;

public enum RespCodeEnum {

    RC_0000("0000", "成功"),
    RC_ZZZZ("ZZZZ", "未知异常");

    private final String code;
    private final String msg;

    RespCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
