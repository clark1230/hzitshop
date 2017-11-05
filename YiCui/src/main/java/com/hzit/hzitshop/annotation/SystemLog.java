package com.hzit.hzitshop.annotation;

import java.lang.annotation.*;

/**
 * 自定义日志注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
    String module()  default ""; //模块
    String methods()  default "";  //方法
    String msg() default  "";//操作消息
}
