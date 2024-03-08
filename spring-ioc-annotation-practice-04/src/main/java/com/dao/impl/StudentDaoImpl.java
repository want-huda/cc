package com.dao.impl;

import com.dao.StudentDao;
import com.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Student> select() {
        String sql = "select id , name , age , gender , class as classes from students";

        List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println("dao = " + students);
        return students;
    }
}
