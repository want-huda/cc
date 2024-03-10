package com.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * ProceedingJoinPoint 比 JoinPoint 多了一个方法 proceed()，用于执行目标方法

 */
@Component
@Aspect
public class TxAround {
    public Object transaction(ProceedingJoinPoint joinPoint){

        return null;
    }
}
