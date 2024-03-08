package com.test;

import com.config.JavaConfig;
import com.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfig.class)//加载配置类 classes加载配置类 也可以加载xml文件
public class Test {
    @Autowired
    private Calculator calculator;

    @org.junit.jupiter.api.Test

    public void test() {

        int add = calculator.add(1, 2);
        System.out.println("add = " + add);

    }
}
