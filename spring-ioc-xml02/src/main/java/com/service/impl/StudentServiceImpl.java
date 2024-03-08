package com.service.impl;

import com.dao.StudentDao;
import com.pojo.Student;
import com.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> select() {
        System.out.println("studentService"+studentDao.select());
        return studentDao.select();
    }
}
