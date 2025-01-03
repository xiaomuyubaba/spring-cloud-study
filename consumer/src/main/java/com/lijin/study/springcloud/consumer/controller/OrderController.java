package com.lijin.study.springcloud.consumer.controller;

import com.lijin.study.springcloud.common.entity.PayDTO;
import com.lijin.study.springcloud.common.entity.Request;
import com.lijin.study.springcloud.common.entity.Response;
import com.lijin.study.springcloud.common.util.JsonUtil;
import com.lijin.study.springcloud.common.util.ReqUtil;
import com.lijin.study.springcloud.consumer.feignclient.PayServiceClient;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private PayServiceClient payServiceClient;

    @GetMapping(path = "/order/get/{id}")
    public String qryOrder(@PathVariable("id") Long id) {
        log.info("查询订单: {}", id);
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("id", String.valueOf(id));
        Request<Map<String, String>> req = ReqUtil.newRequest(reqMap);
//        Response<PayDTO> resp = restTemplate.postForObject("http://pay-service/pay/get", req, Response.class);
        System.out.println(payServiceClient.getClass());
        Response<PayDTO> resp = payServiceClient.getById(req);
        return JsonUtil.toJson(resp);
    }

}
