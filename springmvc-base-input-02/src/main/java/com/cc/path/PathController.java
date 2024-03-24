package com.cc.path;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/path")
public class PathController {
    /*
    path/账号/密码
    必须注解@PathVariable
    1. @PathVariable("account") String account
    */
    @RequestMapping("/login/{account}/{password}")
    @ResponseBody
    public String login(@PathVariable String account, @PathVariable String password) {
        System.out.println("account = " + account + ", password = " + password);
        return "account = " + account + ", password = " + password;
    }
}
