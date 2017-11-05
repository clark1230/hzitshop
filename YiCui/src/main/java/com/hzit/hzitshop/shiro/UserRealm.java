package com.hzit.hzitshop.shiro;


import com.hzit.hzitshop.entity.SystemUser;
import com.hzit.hzitshop.exception.JobStatusException;
import com.hzit.hzitshop.service.SystemUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;


/**
 * 自定义域对象
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private SystemUserService userService;
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
        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);

        SystemUser user = userService.login(map);
        System.out.println("user"+user);

        if (user == null) {
            // 抛出 帐号找不到异常
            throw  new UnknownAccountException();
        }
        // 该账号已被禁用/离职
        if ("0".equals(user.getIsLock()) ) {
            // 账号禁用异常
            throw new DisabledAccountException();
        }
        if("2".equals(user.getStatus())){
            throw  new JobStatusException("该员工已经离职了!");
        }
        // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserName(), // 用户名
                user.getPassword(), // 密码
                //YWRtaW4=
                ByteSource.Util.bytes(""),// salt=username+salt
                getName() // realm name
        );
        return authenticationInfo;
    }

}
