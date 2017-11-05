package com.hzit.hzitshop.controller;

import com.hzit.hzitshop.annotation.SystemLog;
import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.LogEntity;
import com.hzit.hzitshop.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 日志控制器
 */
@Controller
public class LogController {
    /**
     * 自动注入LogService实例
     */
    @Autowired
    private LogService logService;

    /**
     * 跳转到日志页面
     * 跳转到日志页面
     * @return
     */
    //@SystemLog(module ="系统日志",methods = "log")
    @RequestMapping(value = {"log"},method = RequestMethod.GET)
    public String log(){
        return  "log/log";
    }

    /**
     * 异步获取系统日志信息
     * @param page
     * @param limit
     * @return
     */
   // @SystemLog(module = "系统日志",methods = "logAjax")
    @RequestMapping(value = {"logAjax"},method = RequestMethod.GET)
    @ResponseBody
    public LayuiData<LogEntity> logAjax(int page,int limit){
        Map<String,Object>  map = new HashMap<>();
        map.put("offset",(page-1)*limit);
        map.put("limit",limit);
        return logService.page(map);
    }
}
