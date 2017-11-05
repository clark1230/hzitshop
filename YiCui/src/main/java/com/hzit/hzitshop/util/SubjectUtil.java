package com.hzit.hzitshop.util;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class SubjectUtil {
    /**
     * 获取主体
     * @return
     */
    public static Subject getSub(){
            return SecurityUtils.getSubject();
    }

    /**
     * 获取会话信息
     * @return
     */
    public static Session getSession(){
            return SecurityUtils.getSubject().getSession();
    }

    /**
     * 获取用户名
     * @return
     */
    public static String getUser(){
        return (String) SecurityUtils.getSubject().getPrincipal();
    }
}
