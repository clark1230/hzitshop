package com.hzit.hzitshop.exception;

import org.apache.shiro.authc.AccountException;

/**
 * 自定义异常
 */
public class JobStatusException extends AccountException {

    public JobStatusException(){
        super();
    }
    public JobStatusException(String msg){
        super(msg);
    }
}
