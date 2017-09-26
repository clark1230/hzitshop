package com.hzit.hzitshop.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 限制重试次数的验证匹配器
 */
public class RetryLimitCredentialMatcher extends HashedCredentialsMatcher {
    //集群中可能会导致出现验证多过3次的现象，因为AtomicInteger只能保证单节点并发
    private Cache<String, AtomicInteger> passwordRetryCache;

    public RetryLimitCredentialMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String)token.getPrincipal();
        //retry count + 1
        AtomicInteger retryCount =passwordRetryCache.get(username);//从缓存中根据用户名获取缓存信息
        //可以替换为redis数据库
        if(null == retryCount) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);//缓存   将信息添加到缓存中
        }
        if(retryCount.incrementAndGet() > 3) {
            throw new ExcessiveAttemptsException("username: " + username + " tried to login more than 3 times in period"
            ); }
        boolean matches = super.doCredentialsMatch(token, info);
        if(matches) {
            //clear retry data
            passwordRetryCache.remove(username); //清空缓存数据
        }
        return matches;
    }
}