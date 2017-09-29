package com.hzit.hzitshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 获取服务器信息控制器
 */
@Controller
public class ServerController {
    /**
     * 跳转到服务器信息页面
     * @return
     */
    @RequestMapping(value = {"serverInfo"},method = RequestMethod.GET)
    public String serverInfo(){
        Properties properties =  System.getProperties();
        Set<Map.Entry<Object,Object>> entrySet = properties.entrySet();
        for(Map.Entry<Object,Object> entry : entrySet){
            System.out.println(entry.getKey()+"----"+entry.getValue());
        }
        return null;
    }
}
