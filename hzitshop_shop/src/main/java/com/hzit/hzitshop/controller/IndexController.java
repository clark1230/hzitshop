package com.hzit.hzitshop.controller;

import com.hzit.hzitshop.annotation.SystemLog;
import com.hzit.hzitshop.entity.Permission;
import com.hzit.hzitshop.util.SubjectUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class IndexController {
    /**
     * 后台系统主页
     * @return
     */
    @SystemLog(module = "系统主页",methods = "index",msg = "跳转到系统主页")

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
    @SystemLog(module = "工作台",methods = "main",msg = "跳转到欢迎页面")
    @RequestMapping(value = {"main"})
    public String main(Model model){
        model.addAttribute("username",SubjectUtil.getUser());
        return "main";
    }

//    @SystemLog(module = "未授权",methods = "unauthorized",msg = "跳转到未授权页面")
//    @RequestMapping(value={"unauthorized"})
//    public  String unauthorized(){
//        return "unauthorized";
//    }

    /**
     * 锁定屏幕页面
     * @return
     */
    @RequestMapping(value = "/lockScreen",method = RequestMethod.GET)
    public String lockScreen(){
        return "lockScreen";
    }

    /**
     * 根据用户的权限展示响应的菜单
     * @return
     */
    @RequestMapping(value={"showMenu"},method = RequestMethod.GET)
    @ResponseBody
    public List<Permission> showMenu(){
        String userName = SubjectUtil.getUser();
        return null;
    }
}
