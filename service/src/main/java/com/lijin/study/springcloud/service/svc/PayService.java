package com.lijin.study.springcloud.service.svc;

import com.lijin.study.springcloud.service.dao.mapper.PayMapper;
import com.lijin.study.springcloud.service.dao.model.Pay;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayService {

    @Resource
    private PayMapper payMapper;

    public int add(Pay pay) {
        return payMapper.insert(pay);
    }

    public int delete(long id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    public int update(Pay pay) {
        return payMapper.updateByPrimaryKey(pay);
    }

    public Pay getById(long id) {
        return payMapper.selectByPrimaryKey(id);
    }

    public List<Pay> getAll() {
        return payMapper.selectByExample(null);
    }
}
