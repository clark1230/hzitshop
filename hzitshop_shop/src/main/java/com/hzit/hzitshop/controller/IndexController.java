package com.hzit.hzitshop.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    /**
     * 后台系统主页
     * @return
     */
    @RequiresPermissions("index")
    @RequestMapping(value={"/","/index"})
    public String index(){
        return "index";
    }

    /**
     *  欢迎页
     * @return
     */
    @RequiresPermissions("main")
    @RequestMapping(value = {"main"})
    public String main(){
        return "main";
    }
    @RequestMapping(value={"unauthorized"})
    public  String unauthorized(){
        return "unauthorized";
    }

    @RequestMapping(value="notFound")
    public String notFound(){
             return "403";
    }
}
