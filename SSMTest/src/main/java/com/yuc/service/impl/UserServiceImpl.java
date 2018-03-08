package com.yuc.service.impl;

import com.yuc.dao.UserMapper;
import com.yuc.model.User;
import com.yuc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Transactional
    public int insert(User user) {
        return userMapper.insert(user);
    }
}
