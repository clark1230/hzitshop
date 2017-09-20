package com.hzit.hzitshop.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    /**
     * 后台系统主页
     * @return
     */
    @RequiresRoles("admin")
    @RequestMapping(value={"/","/index"})
    public String index(){
        return "index";
    }

    /**
     *  欢迎页
     * @return
     */
    @RequestMapping(value = {"main"})
    public String main(){
        return "main";
    }
}
