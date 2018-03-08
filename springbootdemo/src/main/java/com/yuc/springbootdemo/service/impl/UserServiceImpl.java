package com.yuc.springbootdemo.service.impl;

import com.yuc.springbootdemo.mapper.UserMapper;
import com.yuc.springbootdemo.model.User;
import com.yuc.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<User> getById(String id) {
        return userMapper.getById(id);
    }
}
