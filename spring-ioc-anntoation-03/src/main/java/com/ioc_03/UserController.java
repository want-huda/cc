package com.ioc_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    /*Autowired注解可以对成员变量、方法和构造函数进行标注，来完成自动装配的工作。/
    Autowired 的required属性默认为true，表示注入的bean必须存在，如果不存在则会抛出异常。
    为false时，表示注入的bean如果不存在，则不进行注入，不会抛出异常。后期会出现空指针异常。
     */
    @Qualifier("userServiceImpl")//指定注入的bean的id 一定搭配哦Autowired使用
    @Autowired
    private UserService userService;
    public void show(){
        String result = userService.save();
        System.out.println("result = " + result);
    }
}
