package com.lijin.study.springcloud.common.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ErrorCodeEnumTest {

    @Test
    public void test() {
        // 测试是否有重复的code
        final Set<String> errCodeSet = new HashSet<>();
        ErrorCodeEnum[] errorCodeEnums = ErrorCodeEnum.values();
        Arrays.stream(errorCodeEnums).forEach(errorCodeEnum -> errCodeSet.add(errorCodeEnum.getCode()));
        Assertions.assertEquals(errCodeSet.size(), errorCodeEnums.length);
    }

}