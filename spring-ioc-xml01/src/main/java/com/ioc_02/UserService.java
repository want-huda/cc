package com.ioc_02;
public class UserService {
    private UserDao userDao ;
    private String name;
    private int age;
    public UserService(UserDao userDao, String name, int age) {

        this.userDao = userDao;
        this.name = name;
        this.age = age;
    }
}