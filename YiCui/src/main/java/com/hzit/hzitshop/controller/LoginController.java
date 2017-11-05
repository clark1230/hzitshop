package com.hzit.hzitshop.controller;

import com.hzit.hzitshop.annotation.SystemLog;
import com.hzit.hzitshop.exception.JobStatusException;
import com.hzit.hzitshop.service.SystemUserService;
import com.hzit.hzitshop.util.Md5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.concurrent.atomic.AtomicInteger;


@Controller
public class LoginController {
    //自动注入缓存管理器实例
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private SystemUserService userService;
    @RequestMapping(value = {"login"},method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    
    @SystemLog(module = "登录",methods = "login",msg="处理登陆请求")
    @RequestMapping(value = {"login"},method = RequestMethod.POST)
    public String login(String username, String password, String rememberMe, Model model) throws Exception {

        //输出缓存时间
        Cache<String,AtomicInteger> cache = cacheManager.getCache("passwordRetryCache");
        System.out.println(cache.get(username));
        System.out.println("缓存尺寸:"+cache.size());
        Subject subject = SecurityUtils.getSubject();//获取主体
        boolean remember = false;//设置记住我功能
        if("true".equals(rememberMe)){//表单勾选了记住我时
            remember = true;
        }
        String error = null;
        UsernamePasswordToken token = new UsernamePasswordToken(username, Md5Util.getMD5("hzit#"+password));
        token.setRememberMe(remember);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            error = "用户名/密码错误";
        }catch ( IncorrectCredentialsException ice ) {
            //凭据不正确，例如密码不正确 ...
            error = "用户名/密码错误";
        } catch (ExcessiveAttemptsException e) {
            error = "账号:"+username+"登录失败多次，锁定15分钟后才能登陆";
        } catch (DisabledAccountException e) {
            // 其他错误，比如锁定，如果想单独处理请单独catch处理
            error = "账号:"+username+"被禁用了,请联系管理员!";
        } catch (JobStatusException e){
            error = username+"已经离职了,不允许再次登陆系统!";
        }
        if (error != null) {// 出错了，返回登录页面
            model.addAttribute("error", error);
            return "login";
        } else {// 登录成功
            return "redirect:/index.action";
        }
    }

    /**
     * 系统登出
     * @return
     */
    @SystemLog(module = "注销",methods = "logout",msg="系统注销")
    @RequestMapping(value = "logout")
    public String logout(){
        SecurityUtils.getSubject().logout();//注销 (RememberMe功能也消失了)
        return "redirect:/login.action"; //重定向到登录页
    }
}
