package com.ioc_05;

import org.springframework.beans.factory.FactoryBean;

public class JavaBeanFactory implements FactoryBean {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public Object getObject() throws Exception {
        //使用自己的方式实例化
        JavaBean javaBean = new JavaBean();
        javaBean.setName(value);
        return javaBean;
    }
    //返回实例化的类
    @Override
    public Class<?> getObjectType() {
        return JavaBean.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
