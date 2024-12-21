package com.lijin.study.springcloud.service;

import com.lijin.study.springcloud.service.svc.PayService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppConfigTest {

    @Resource
    private PayService payService;

    @Test
    public void test() {
        System.out.println(payService.getAll());
    }

}