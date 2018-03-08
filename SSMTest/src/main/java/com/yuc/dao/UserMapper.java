package com.yuc.dao;

import com.yuc.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resources;

@Repository

public interface UserMapper {

    int insert(User user);
}
