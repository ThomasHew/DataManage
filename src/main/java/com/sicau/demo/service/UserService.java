package com.sicau.demo.service;

import com.sicau.demo.entity.User;

public interface UserService {
    //注册用户
    boolean registerUser(User user);
    //登录功能
    User findUserByNameAndPwd(User user);

}
