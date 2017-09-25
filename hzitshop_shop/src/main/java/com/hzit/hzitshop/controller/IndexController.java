package com.hzit.hzitshop.controller;

import com.hzit.hzitshop.util.SubjectUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
    /**
     * 后台系统主页
     * @return
     */
    @RequiresPermissions("index")
    @RequestMapping(value={"/","/index"})
    public String index(Model model){
        System.out.println("超时时间:"+SubjectUtil.getSession().getTimeout());
        model.addAttribute("username", SubjectUtil.getUser());
        Session session = SecurityUtils.getSubject().getSession();
        System.out.println(SecurityUtils.getSubject().getSession().getId());
        System.out.println(session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY"));
        return "index";
    }

    /**
     *  欢迎页
     * @return
     */
//    @RequiresPermissions("main")
    @RequestMapping(value = {"main"})
    public String main(Model model){
        model.addAttribute("username",SubjectUtil.getUser());
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
