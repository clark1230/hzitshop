package com.hzit.hzitshop.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

public class SessioonListener implements SessionListener {
    @Override
    public void onStart(Session session) {
        System.out.println("创建会话.................");
    }

    @Override
    public void onStop(Session session) {
        System.out.println("停止会话.............");
    }

    @Override
    public void onExpiration(Session session) {
        System.out.println("会话过期.,,,,,,,,,,,,,,,,,,,");
    }
}
