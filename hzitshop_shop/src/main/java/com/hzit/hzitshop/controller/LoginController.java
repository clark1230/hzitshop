package com.hzit.hzitshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = {"login"},method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = {"login"},method = RequestMethod.POST)
    public String login(String username,String password){
        return null;
    }
    
    @RequestMapping(value = "logout")
    public String logout(){
        return "login";
    }
}
