package com.sicau.demo.serviceimpl;

import com.sicau.demo.dao.UserDao;
import com.sicau.demo.entity.User;
import com.sicau.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override//注册用户
    public boolean registerUser(User user) {
        return userDao.registerUser(user);
    }

    @Override//用户登录模块
    public User findUserByNameAndPwd(User user) {
        return userDao.findUserByNameAndPwd(user);
    }
}
