package com.lijin.study.springcloud.common.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class FuncEnumTest {

    @Test
    public void test() {
        // 测试是否有重复的code
        final Set<String> funcSet = new HashSet<>();
        FuncEnum[] funcArr = FuncEnum.values();
        Arrays.stream(funcArr).forEach(func -> funcSet.add(func.getCode()));
        Assertions.assertEquals(funcSet.size(), funcArr.length);
    }


}