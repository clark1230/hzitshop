package com.hzit.hzitshop.log;

import com.hzit.hzitshop.annotation.SystemLog;
import com.hzit.hzitshop.entity.LogEntity;
import com.hzit.hzitshop.service.LogService;
import com.hzit.hzitshop.util.SubjectUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

//@Component
//@Aspect
public class SystemLogAspect {

    @Autowired
    private LogService  logservice;

    //配置接入点
    //@Pointcut("execution(* com.hzit.hzitshop.controller.*.*(..))")
    private void controllerAspect(){}//定义一个切入点

    //@Around("controllerAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //常见日志实体对象
        LogEntity log = new LogEntity();
        //获取登录用户账户
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String name = SubjectUtil.getUser();   //从主体中获取用户信息
        log.setUsername(name);
        //获取系统时间
        String time = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
        log.setDate(time);  

        //获取系统ip
        String ip =request.getRemoteHost() ;
        log.setIp(ip);

        //方法通知前获取时间,用来计算模块执行时间的
        long start = System.currentTimeMillis();
        // 拦截的实体类，就是当前正在执行的controller
        Object target = pjp.getTarget();
        // 拦截的方法名称。当前正在执行的方法
        String methodName = pjp.getSignature().getName();
        // 拦截的方法参数
        Object[] args = pjp.getArgs();
        // 拦截的放参数类型
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Class[] parameterTypes = msig.getMethod().getParameterTypes();

        Object object = null;
        // 获得被拦截的方法
        Method method = null;
        try {
            method = target.getClass().getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        } catch (SecurityException e1) {
            e1.printStackTrace();
        }
        if (null != method) {
            // 判断是否包含自定义的注解，说明一下这里的SystemLog就是我自己自定义的注解
            if (method.isAnnotationPresent(SystemLog.class)) {
                SystemLog systemlog = method.getAnnotation(SystemLog.class);
                log.setModule(systemlog.module());
                log.setMethod(systemlog.methods());
                log.setMsg(systemlog.msg());
                try {
                    object = pjp.proceed();
                    long end = System.currentTimeMillis();
                    //将计算好的时间保存在实体中
                    log.setResponseDate(""+(end-start));
                    log.setCommit("success");
                    //保存进数据库
                    logservice.saveLog(log);
                } catch (Throwable e) {
                    e.printStackTrace();
                    long end = System.currentTimeMillis();
                    log.setResponseDate(""+(end-start));
                    log.setCommit("error");
                    //保存日志
                    logservice.saveLog(log);
                }
            } else {//没有包含注解
                object = pjp.proceed();
            }
        } else { //不需要拦截直接执行
            object = pjp.proceed();
        }
        return object;
    }
}
