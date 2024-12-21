package com.lijin.study.springcloud.common.entity;

import java.util.Date;
import java.util.UUID;

public class Request<T> {

    private String reqId;
    private String reqTm;
    private T reqData;

    public static <T> Request<T> newRequest(T reqData) {
        Request<T> request = new Request<>();
        request.reqId = UUID.randomUUID().toString().replace("-", "");
        request.reqTm = new Date().toString();
        request.reqData = reqData;
        return request;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getReqTm() {
        return reqTm;
    }

    public void setReqTm(String reqTm) {
        this.reqTm = reqTm;
    }

    public T getReqData() {
        return reqData;
    }

    public void setReqData(T reqData) {
        this.reqData = reqData;
    }
}
