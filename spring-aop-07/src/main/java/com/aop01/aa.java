package com.aop01;

public class aa {
    public static void main(String[] args) {
        Calculator target = new CalculatorPureImpl();



        //jdk动态代理只能代理实现了接口的类
        ProxyFactory proxyFactory = new ProxyFactory(target);

        Calculator proxy = (Calculator) proxyFactory.getProxy();
        int add = proxy.add(1, 2);
        System.out.println("add = " + add);
    }
}
