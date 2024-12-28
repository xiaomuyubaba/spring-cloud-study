package com.lijin.study.springcloud.service.config;

import com.lijin.study.springcloud.service.svc.PayService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class AppConfigTest {

    @Resource
    private AppConfig appConfig;

    @Test
    public void test() {
        System.out.println(appConfig.getVersion());
        Assertions.assertEquals("UNIT_TEST", appConfig.getVersion());
    }

}