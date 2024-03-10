package com.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * TODO：切点表达式
 *      固定格式：execution(访问修饰符 返回值类型 方法所属类的全类名.方法名(参数))
 *      1. 访问修饰符：public protected private * 任意访问修饰符
 *      2. 返回值类型：* 任意返回值类型 也可以指定具体的返回值类型
 *      3. 方法所属类的全类名：com.service.impl.CalculatorPureImpl 任意类 com..impl.* 以impl结尾的所有类
 *      4. 方法名：add 任意方法名 add* 以add开头的所有方法
 *      5. 参数：(int,int) 两个int类型的参数 任意参数 (..) 任意参数
 */
@Aspect
@Component
public class MyAdvice {
    /**
     * @Pointcut 定义切点表达式
     */
    @Pointcut("execution(* com ..impl.*.*(..))")
    public void pc(){}


    @Before("execution(* com ..impl.*.*(..))")
    public void before(JoinPoint joinPoint) { // JoinPoint 用于获取连接点的信息
        // 获取方法属于类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        // 获取方法名
        String name = joinPoint.getSignature().getName();

        // 获取方法参数
        Object[] args = joinPoint.getArgs();


    }
    @After("execution(* com ..impl.*.*(..))")
    public void after() {
        System.out.println("后置通知");
    }
    @AfterReturning(value = "execution(* com ..impl.*.*(..))",returning = "result")
    public void afterReturning(Object    result) {
        System.out.println("返回后通知");
    }
    @AfterReturning("execution(* com ..impl.*.*(..))")
    public void afterThrowing() {
        System.out.println("异常通知");
    }
    public void around() {
        System.out.println("环绕通知");
    }
}
