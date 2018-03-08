package com.yuc.springbootdemo.mapper;

import com.yuc.springbootdemo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface UserMapper {
    List<User> getById(String id);
    void insert(User user);
}
