package com.controller;

import com.pojo.Student;
import com.service.StudentService;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class StudentController {
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    public void select(){
        List<Student> list = studentService.select();
        System.out.println("controller"+ list);
    }

}
