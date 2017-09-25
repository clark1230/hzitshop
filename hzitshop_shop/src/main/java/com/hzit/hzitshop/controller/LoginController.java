package com.hzit.hzitshop.controller;

import com.hzit.hzitshop.entity.SystemUser;
import com.hzit.hzitshop.service.SystemUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private SystemUserService userService;
    @RequestMapping(value = {"login"},method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = {"login"},method = RequestMethod.POST)
    public String login(String username, String password, String rememberMe, Model model){
        Subject subject = SecurityUtils.getSubject();//获取主体
        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        SystemUser systemUser = userService.login(map); //查询登录信息
        if(systemUser == null){
            model.addAttribute("error","登陆失败!用户名或者密码错误!");
            return "login";
        }else  if("0".equals(systemUser.getIsLock())){ // 0:账号被锁定  1:未锁定
            model.addAttribute("error","登陆失败!\""+username+"\"这个账号已被锁定!");
            return "login";
        }else{
            boolean remember = false;
            if("true".equals(rememberMe)){
                remember = true;
            }
            //登陆
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            token.setRememberMe(remember);
            subject.login(token);
            return "redirect:/index.action";//重定向到主页
        }

    }
    
    @RequestMapping(value = "logout")
    public String logout(){
        SecurityUtils.getSubject().logout();//注销 (RememberMe功能也消失了)
        return "redirect:/login.action"; //重定向到登录页
    }
}
