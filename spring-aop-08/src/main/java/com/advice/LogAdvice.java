package com.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 日志通知 增强类
 * 1.定义方法储存通知
 * 2.使用通知注解
 *  前置 @Before
 *  后置 @After
 *  返回后 @AfterReturning
 *  异常 @AfterThrowing
 *  环绕 @Around
 *  "execution(*com..*.*(..)" 任意返回值 任意包任意类任意方法任意参数
 * 3.配置aop
 */
@Component
@Aspect
public class LogAdvice {
    @Before("execution( * com..*.*(..) ) ")
    public void before() {
        System.out.println("前置通知");
    }
    @AfterThrowing("execution( * com..*.*(..) ) ")
    public void after() {
        System.out.println("后置通知");
    }
    @AfterReturning("execution( * com..*.*(..) ) ")
    public void afterReturning() {
        System.out.println("返回后通知");
    }
    @AfterThrowing("execution( * com..*.*(..) ) ")
    public void afterThrowing() {
            System.out.println("异常通知");
        }
}
