package com.sicau.demo.controller;

import com.sicau.demo.entity.User;
import com.sicau.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    //以下两个用于登录注册转换
    @RequestMapping("/tologin")
    public String logining(){
        System.out.println("kkk");
       return "login";
    }
    @RequestMapping("/toregister")
    public String register(){
        return "register";
    }
    //用户登录模块
    @RequestMapping("/login")
    public String userlogin(User user){
        System.out.println("登陆前");
       User user1 = userService.findUserByNameAndPwd(user);
        System.out.println(user1);
        System.out.println("登陆后");
        if(user1!=null&&user1.getIsAdmin()==1) {
            System.out.println("登录成功");
            return "administrator";
        }
        else if(user1!=null&&user1.getIsAdmin()==0){
            return "index";
        }
        else {
            String msg = "用户名或密码错误，请重新登录";//若没有查到此用户，返回错误信息，重新登录
            return "login";
        }
    }

    //用户注册模块
    @RequestMapping("register")
    public String Register(User user){
        Boolean flag = userService.registerUser(user);
        if(flag) {
            return "login";
        }
        else {
            return "register";
        }
    }

}
