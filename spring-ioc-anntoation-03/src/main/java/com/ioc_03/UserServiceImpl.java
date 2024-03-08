package com.ioc_03;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public String save() {
        return "save";
    }
}
