package com.lijin.study.springcloud.consumer.feignclient;

import com.lijin.study.springcloud.common.entity.PayDTO;
import com.lijin.study.springcloud.common.entity.Request;
import com.lijin.study.springcloud.common.entity.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient("pay-service")
public interface PayServiceClient {

    @PostMapping(value = "/pay/get")
    public Response<PayDTO> getById(@RequestBody Request<Map<String, String>> req);

}
