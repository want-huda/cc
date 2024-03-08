package com.ioc_02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
//scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE  代表多例
//默认是单例
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class JavaBean {
    @PostConstruct
    public void init() {
        System.out.println("JavaBean初始化");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("JavaBean销毁");
    }
}
