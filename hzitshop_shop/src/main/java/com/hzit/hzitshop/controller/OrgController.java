package com.hzit.hzitshop.controller;

import com.hzit.hzitshop.entity.Org;
import com.hzit.hzitshop.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrgController {
    @Autowired
    private OrgService orgService;

    /**
     * 跳转到组织页面
     * @return
     */
    @RequestMapping(value = {"org"})
    public String org(){
        return "org/org";
    }

    /**
     * 异步获取组织数据
     * @return
     */
    @RequestMapping(value = {"orgAjax"},method = RequestMethod.GET)
    @ResponseBody
    public List<Org>  orgAjax(){
        List<Org> orgList = orgService.getOrg();
        return orgList;
    }
}
