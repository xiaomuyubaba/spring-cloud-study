package com.lijin.study.springcloud.common.enums;

public enum ModuleEnum {

    COMMON("01", "公共模块"),
    PAY("02", "支付模块"),
    ORDER("03", "订单模块");

    private final String code;
    private final String desc;

    ModuleEnum(String code, String desc) {
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
