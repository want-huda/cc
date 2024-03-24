package com.cc.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @RequestMapping("/user") // 会导致访问路径为 /user/login
@RequestMapping("/user")
public class UserController {

    /**
    @RequestMapping 是注册handlerMapping的方法 指定URL请求路径
    @WebServlet("/user/login") 必须要求斜杠开头
    @RequestMapping("/user/login") 可以不要求斜杠开头
    @RequestMapping 可以存在多个地址 底层是一个String[]数组
    写法：
    1. 精准地址 @RequestMapping(value = {"/user/login", "/login"})
    2.模糊地址 *任意一层地址 @RequestMapping("/user/*") | ** 任意多层地址 @RequestMapping("/user/**")
    3.类上可以添加 @RequestMapping("/user") 会导致访问路径为 /user/login 也可以不加 但是方法必须添加@RequestMapping 否则不h认为是可以web访问的\
    4. @RequestMapping(value = "/user/login", method = RequestMethod.GET) 可以指定请求方式 | @GetMapping("/user/login") | @PostMapping("/user/login") 只能使用在方法上
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return null;
    }
    @RequestMapping("register")
    public String register(){
        return null;
    }
}
