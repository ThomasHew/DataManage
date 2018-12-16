package com.sicau.demo.dao;

import com.sicau.demo.entity.User;

public interface UserDao {
    //注册用户
    boolean registerUser(User user);
    //登录功能
    User findUserByNameAndPwd(User user);
}
