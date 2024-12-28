package com.lijin.study.springcloud.common.util;

import com.lijin.study.springcloud.common.entity.Request;

import java.util.Date;
import java.util.UUID;

public class ReqUtil {

    public static <T> Request<T> newRequest(T reqData) {
        Request<T> request = new Request<>();
        request.setReqId(UUID.randomUUID().toString().replace("-", ""));
        request.setReqTm(new Date().toString());
        request.setReqData(reqData);
        return request;
    }

}
