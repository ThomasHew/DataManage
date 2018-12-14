package com.sicau.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class UserController {

    @RequestMapping("/tologin")
    public String test1(){
        System.out.println("kkk");
       return "login";
    }

}
