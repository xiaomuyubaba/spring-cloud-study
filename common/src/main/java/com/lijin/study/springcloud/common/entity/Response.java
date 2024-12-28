package com.lijin.study.springcloud.common.entity;

/**
 * 同一应答对象
 *
 * @param <T>
 */
public class Response<T> {

    private String code; // 应答码
    private String msg; // 应答描述
    private final long respTm; // 应答时间
    private T respData; // 应答报文体

    public Response() {
        this.respTm = System.currentTimeMillis();
    }

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

    public long getRespTm() {
        return respTm;
    }

    public T getRespData() {
        return respData;
    }

    public void setRespData(T respData) {
        this.respData = respData;
    }
}
