package com.sicau.demo.dao;

import com.sicau.demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    //注册用户
    boolean registerUser(User user);
    //登录功能
    User findUserByNameAndPwd(User user);
    //获得所有用户
    List<User> getAllUsers(@Param("currentRow") int currentRow,@Param("pagesize") int pagesize);
    //用户总数
    Integer getUserNumber();
    //删除用户
    Integer deleteUser(Integer id);
}
