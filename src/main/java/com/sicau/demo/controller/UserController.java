package com.sicau.demo.controller;

import com.sicau.demo.entity.FileList;
import com.sicau.demo.entity.QueryBean;
import com.sicau.demo.entity.QueryCondition;
import com.sicau.demo.entity.User;
import com.sicau.demo.service.FileService;
import com.sicau.demo.service.UserService;
import com.sicau.demo.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    FileService fileService;
    //以下两个用于登录注册转换
    @RequestMapping("/tologin")
    public String logining(){

       return "login";
    }
    @RequestMapping("/toregister")
    public String register(){
        return "register";
    }
    //用户登录模块
    @RequestMapping("/login")
    public String userlogin(User user, HttpServletRequest request, QueryBean queryBean, QueryCondition queryCondition){
        System.out.println("登陆前");
       User user1 = userService.findUserByNameAndPwd(user);
        System.out.println(user1);
        System.out.println("登陆后");
        if(user1!=null&&user1.getIsAdmin()==1) {
            System.out.println("登录成功");
            request.getSession().setAttribute("user",user1);
            return "administrator";
        }
        else if(user1!=null&&user1.getIsAdmin()==0){
            //分页操作
            if (request.getSession().getAttribute("querycondition")==null){
                request.getSession().setAttribute("querycondition",queryCondition);
            }

            QueryCondition querycondition = (QueryCondition) request.getAttribute("querycondition");
            request.getSession().setAttribute("user",user1);
            queryBean.setGroupName(queryCondition.getGroupName());
            queryBean.setTureFileName(queryCondition.getTureFileName());
            System.out.println(queryBean);
            Page<FileList> page = fileService.getFileListByQueryBean(queryBean);
            request.setAttribute("page",page);
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
