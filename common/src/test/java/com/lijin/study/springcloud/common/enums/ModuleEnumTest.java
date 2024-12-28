package com.lijin.study.springcloud.common.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ModuleEnumTest {

    @Test
    public void test() {
        // 测试是否有重复的code
        final Set<String> codeSet = new HashSet<>();
        ModuleEnum[] modules = ModuleEnum.values();
        Arrays.stream(modules).forEach(module -> codeSet.add(module.getCode()));
        Assertions.assertEquals(codeSet.size(), modules.length);
    }

}