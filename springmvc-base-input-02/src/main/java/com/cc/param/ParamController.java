package com.cc.param;

import com.cc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/param")
public class ParamController {
    //直接接收
    //要求参数名和请求参数名一致 不传值不会报错必须自己准备默认值
    @RequestMapping("/test01")
    @ResponseBody
    public String test01(String name, int age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return name+ + age;
    }

    /*
     * 求必须传值或者不传递值提供默认值
     *  @RequestParam(value = "account" , required = false, defaultValue = "admin")
     * value: 请求参数名
     * required: 是否必须传递 默认值为true 必须传递 false不传递也不会报错
     *  defaultValue: 默认值
     */
    @RequestMapping("/test02")
    @ResponseBody
    public String test02(@RequestParam(value = "account" ) String name, @RequestParam(required = false,defaultValue = "1") int age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return name+ + age;
    }
    //特殊值
    //param/test03?hbs=c&hbs=java&hbs=python
    @RequestMapping("/test03")
    @ResponseBody
    public String test03(@RequestParam List<String> hbs){
        System.out.println("hbs = " + hbs);
        return "ok";
    }
    //实体类
    @RequestMapping("/test04")
    @ResponseBody
    public  String test04(User user){
        System.out.println("user = " + user);
        return user.toString();
    }
}
