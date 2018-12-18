package com.sicau.demo.serviceimpl;

import com.sicau.demo.dao.UserDao;
import com.sicau.demo.entity.User;
import com.sicau.demo.service.UserService;
import com.sicau.demo.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Integer getUserNumber() {
        return userDao.getUserNumber();
    }

    @Override
    public Page<User> findAllUserByPage(int currentPage, int pagesize) {
        //总记录（用户）数
        Integer userNumber = getUserNumber();
        //总页数
        int totalPage = (int) Math.ceil(userNumber * 1.0 / pagesize);
        //所有用户
        int currentRow = (currentPage-1)*pagesize;
        List<User> allUsers = userDao.getAllUsers(currentRow, pagesize);

        Page<User> page = new Page<>(userNumber,currentRow,pagesize,totalPage,allUsers);

        return  page;
    }

    //管理员删除用户
    @Override
    public Integer deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }
}
