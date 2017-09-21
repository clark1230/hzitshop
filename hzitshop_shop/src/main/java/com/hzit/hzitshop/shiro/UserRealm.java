package com.hzit.hzitshop.shiro;


import com.hzit.hzitshop.service.SystemUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 自定义域对象
 */
public class UserRealm extends AuthorizingRealm {
    /**
     * 授权验证
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //到数据库中根据用户名查询该用户所对应的权限
        info.addStringPermission("index");
        return info;
    }

    /**
     * 登录验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();//获取用户名
        String password=  new String((char[])token.getCredentials());
        return new SimpleAuthenticationInfo(username,password,this.getName());
    }
//    @Autowired
//    private SystemUserService userService;
//    @Override
//    public String getName() {
//        return "userRealm";
//    }
//
//    @Override
//    public boolean supports(AuthenticationToken token) {
//        return token instanceof UsernamePasswordToken;
//    }
//
//    @Override
//    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        String username = (String) token.getPrincipal();//获取用户名
//        String password=  new String((char[])token.getCredentials());
//        return new SimpleAuthenticationInfo(username,password,this.getName());
//    }
}
