package com.test;

import com.ioc_02.JavaBean;
import com.ioc_03.UserController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    @Test
    public void test1() {
        // 1. 创建spring的IOC容器对象
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-01.xml");

        // 2. 从IOC容器中获取bean实例
         XxxService xxxService = applicationContext.getBean(XxxService.class);
        System.out.println("xxxService = " + xxxService);

        //4.使用注解配置的bean默认名为类名首字母小写 可以使用@Qualifier("beanName")指定bean的名字
        Object xxxDAO = applicationContext.getBean("xxxDao");
        System.out.println("xxxDAO = " + xxxDAO);

    }
    @Test
    public void test2() {
        // 1. 创建spring的IOC容器对象
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-02.xml");

        // 2. 从IOC容器中获取bean实例
        Object javaBean = applicationContext.getBean(JavaBean.class);
        System.out.println("javaBean = " + javaBean);
        //手动销毁bean 多列手动销毁是不会执行销毁方法的
        applicationContext.close();
    }

    @Test
    public void test3() {
        // 1. 创建spring的IOC容器对象
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-03.xml");

        // 2. 从IOC容器中获取bean实例
        UserController bean = applicationContext.getBean(UserController.class);
        bean.show();
    }

    @Test
    public void test4() {
        // 1. 创建spring的IOC容器对象
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-04.xml");

        // 2. 从IOC容器中获取bean实例
        Object javaBean = applicationContext.getBean("jda");//
        System.out.println("javaBean = " + javaBean);

    }
}