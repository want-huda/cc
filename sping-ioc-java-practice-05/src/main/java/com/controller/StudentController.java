package com.controller;

import com.pojo.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    public void select(){
        List<Student> list = studentService.select();
        System.out.println("controller"+ list);
    }

}
