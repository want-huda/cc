package com.service.impl;

import com.dao.StudentDao;
import com.pojo.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> select() {
        System.out.println("studentService"+studentDao.select());
        return studentDao.select();
    }
}
