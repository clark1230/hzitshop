package com.hzit.hzitshop.shiro;


import com.hzit.hzitshop.service.SystemUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 自定义域对象
 */
public class UserRealm implements Realm {
    @Autowired
    private SystemUserService userService;
    @Override
    public String getName() {
        return "userRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();//获取用户名
        String password=  new String((char[])token.getCredentials());
        return new SimpleAuthenticationInfo(username,password,this.getName());
    }
}
