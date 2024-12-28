package com.lijin.study.springcloud.service.controller;

import com.lijin.study.springcloud.common.entity.PayDTO;
import com.lijin.study.springcloud.common.entity.Request;
import com.lijin.study.springcloud.common.entity.Response;
import com.lijin.study.springcloud.common.enums.ErrorCodeEnum;
import com.lijin.study.springcloud.common.enums.FuncEnum;
import com.lijin.study.springcloud.common.util.JsonUtil;
import com.lijin.study.springcloud.common.util.RespUtil;
import com.lijin.study.springcloud.service.dao.model.Pay;
import com.lijin.study.springcloud.service.svc.PayService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PayController {

    private static final Logger log = LoggerFactory.getLogger(PayController.class);

    @Resource
    private PayService payService;

    @PostMapping(value = "/pay/add")
    public Response<String> addPay(@RequestBody Request<Pay> req) {
        log.info("add pay entity: {}", JsonUtil.toJson(req));
        int i = payService.add(req.getReqData());
        return RespUtil.success("成功插入记录，返回值：" + i);
    }

    @PostMapping(value = "/pay/del")
    public Response<Integer> deletePay(@RequestBody Request<Map<String, String>> req) {
        log.info("delete pay entity: {}", JsonUtil.toJson(req));
        return RespUtil.success(payService.delete(Long.parseLong(req.getReqData().get("id"))));
    }

    @PostMapping(value = "/pay/update")
    public Response<String> updatePay(@RequestBody Request<PayDTO> req) {
        log.info("update pay entity: {}", JsonUtil.toJson(req));
        Pay pay = new Pay();
        BeanUtils.copyProperties(req.getReqData(), pay);
        int i = payService.update(pay);
        log.info("成功更新记录: {}", pay.getId());
        return RespUtil.success("成功更新记录, 返回值：" + i);
    }

    @PostMapping(value = "/pay/get")
    public Response<PayDTO> getById(@RequestBody Request<Map<String, String>> req) {
        log.info("query pay by Id: {}", JsonUtil.toJson(req));
        Pay pay = payService.getById(Long.parseLong(req.getReqData().get("id")));
        if (pay != null) {
            PayDTO payDTO = new PayDTO();
            BeanUtils.copyProperties(pay, payDTO);
            return RespUtil.success(payDTO);
        } else {
            return RespUtil.fail(FuncEnum.PAY_0004, ErrorCodeEnum.RC_0005, "查询支付流水失败");
        }
    }

    @PostMapping(value = "/pay/getAll")
    public Response<List<Pay>> getAll(@RequestBody Request<Void> req) {
        log.info("query all pay flow: {}", JsonUtil.toJson(req));
        return RespUtil.success(payService.getAll());
    }
}
