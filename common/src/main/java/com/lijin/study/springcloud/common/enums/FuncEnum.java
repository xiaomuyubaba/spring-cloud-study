package com.lijin.study.springcloud.common.enums;

/**
 * 功能点枚举类
 * <p>
 * 功能码：2位模块编码+4位功能点编码
 */
public enum FuncEnum {

    COMMON_0001(ModuleEnum.COMMON + "0001", "插入数据库记录"),
    COMMON_0002(ModuleEnum.COMMON + "0002", "更新数据库记录"),
    PAY_0001(ModuleEnum.PAY + "0001", "创建支付流水"),
    PAY_0002(ModuleEnum.PAY + "0002", "修改支付流水"),
    PAY_0003(ModuleEnum.PAY + "0003", "删除支付流水"),
    PAY_0004(ModuleEnum.PAY + "0004", "查询单笔支付流水"),
    PAY_0005(ModuleEnum.PAY + "0005", "查询多笔支付流水"),
    UNKNOWN("ZZZZZZ", "未知功能"),
    ;

    private final String code; // 功能代码
    private final String desc; // 功能描述

    FuncEnum(String code, String desc) {
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
