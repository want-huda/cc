package com.cc.json;

import com.cc.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/json")
@Controller
@ResponseBody
public class JsonController {
    //http://localhost:8080/json/test01?name=cc&age=18&gender=男
    @PostMapping("/test01")
    public String test01(@RequestBody Person person) {
        System.out.println("person = " + person);
        return person.toString();
    }
}
