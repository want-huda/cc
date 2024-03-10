package com.advice;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;

public class TxAdvice {
    @Before("com.advice.MyPointCut.pc()")
    public void begin() {
        System.out.println("begin");
    }
    @AfterThrowing("com.advice.MyPointCut.pc()")
    public void commit() {
        System.out.println("commit");
    }
    @AfterThrowing("com.advice.MyPointCut.pc()")
    public void rollback() {
        System.out.println("rollback");
    }

}
