package com.hzit.hzitshop.util;

/**
 * 服务器异步返回客户端的响应消息
 */
public class StatusCode {
    private int code;//状态码        200:表示服务器处理成功  500:表示服务器处理失败
    private String msg;//消息

    public StatusCode() {
    }

    public StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "StatusCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
