package com.lijin.study.springcloud.service.svc;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PayServiceTest {

    @Resource
    private PayService payService;

    @Test
    public void test() {
        System.out.println(payService.getAll());
    }

}