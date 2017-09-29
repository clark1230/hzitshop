package com.hzit.hzitshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 系统帮助控制器
 */
@Controller
public class HelpController {
    /**
     * 跳转到系统帮助页面
     * @return
     */
    @RequestMapping(value = "help",method = RequestMethod.GET)
    public String help(){
        return "help/help";
    }
}
