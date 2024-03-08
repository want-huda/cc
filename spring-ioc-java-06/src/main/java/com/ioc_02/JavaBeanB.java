package com.ioc_02;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import(JavaBeanA.class)//导入JavaBeanA配置类
@Configuration//标注为配置类
public class JavaBeanB {
}
