package com.ioc_04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;


@Controller("jda")
public class JavaBean {
    @Value("张三")//等于<property name="name" value="张三"/>
    String name;
    @Value("${jdbc.username}")//从配置文件中读取
    String username;
    @Value("${jdbc.password}")
    String password;
    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.driver}")
    String driverClassName;

}
