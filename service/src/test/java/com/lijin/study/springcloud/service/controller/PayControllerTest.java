package com.lijin.study.springcloud.service.controller;

import com.lijin.study.springcloud.common.entity.Request;
import com.lijin.study.springcloud.common.util.JsonUtil;
import com.lijin.study.springcloud.common.util.ReqUtil;
import com.lijin.study.springcloud.service.dao.mapper.PayMapper;
import com.lijin.study.springcloud.service.svc.PayService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用WebMvcTest测试指定的Controller
 * 需要把依赖的Bean都模拟并注入，这样就可以脱离环境单独测试Controller了
 */
@WebMvcTest(PayController.class)
@AutoConfigureMockMvc
class PayControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PayService payService; // 注入模拟的PayService
    @MockBean
    private PayMapper payMapper; // 给PayService注入模拟的PayMapper

    @Test
    public void testGetById() throws Exception {
        Mockito.when(payMapper.selectByPrimaryKey(1L)).thenReturn(null);
        Mockito.when(payService.getById(1)).thenReturn(null);

        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("id", "1");
        Request<Map<String, String>> req = ReqUtil.newRequest(reqMap);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/pay/get")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.toJson(req))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}