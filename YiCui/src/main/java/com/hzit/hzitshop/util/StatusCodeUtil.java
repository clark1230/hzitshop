package com.hzit.hzitshop.util;

public class StatusCodeUtil {
    public static StatusCode check(int result){
        StatusCode sc = new StatusCode();
        if(result > 0){
            sc.setCode(200);
            sc.setMsg("保存成功!");
        }else{
            sc.setCode(500);
            sc.setMsg("保存失败!");
        }
        return sc;
    }
}
