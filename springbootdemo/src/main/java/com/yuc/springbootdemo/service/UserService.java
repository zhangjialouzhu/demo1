package com.yuc.springbootdemo.service;

import com.yuc.springbootdemo.model.User;

import java.util.List;

public interface UserService {
   void insert(User user);
   List<User> getById(String id);
}
