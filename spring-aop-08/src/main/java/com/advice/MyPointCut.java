package com.advice;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 存放切入点
 */
@Component
public class MyPointCut {
    @Pointcut("execution(* com..*.*(..))")
    public void pc(){}
}
