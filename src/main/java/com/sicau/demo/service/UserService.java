package com.sicau.demo.service;

import com.sicau.demo.entity.User;
import com.sicau.demo.utils.Page;

public interface UserService {
    //注册用户
    boolean registerUser(User user);
    //登录功能
    User findUserByNameAndPwd(User user);
    //获得所有用户分页
    Page<User> findAllUserByPage(int currentRow,int pagesize);
    //用户总数
    Integer getUserNumber();
    //删除用户
    Integer deleteUser(Integer id);

}
