package com.lijin.study.springcloud.common.enums;

/**
 * 失败错误码枚举类
 */
public enum ErrorCodeEnum {

    RC_0001("0001", "请求接收失败"),
    RC_0002("0002", "请求参数格式错误"),
    RC_0003("0003", "数据库记录插入失败"),
    RC_0004("0004", "数据库记录更新失败"),
    RC_0005("0005", "未找到数据库记录"),
    RC_ZZZZ("ZZZZ", "未知异常");

    private final String code;
    private final String desc;

    ErrorCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
