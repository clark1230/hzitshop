package com.hzit.hzitshop.controller;

import com.hzit.hzitshop.entity.Org;
import com.hzit.hzitshop.service.OrgService;
import com.hzit.hzitshop.util.StatusCode;
import com.hzit.hzitshop.util.StatusCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 组织控制器
 */
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

    /**
     * 跳转到添加组织页面
     * @return
     */
    @RequestMapping(value = {"addOrg"},method = RequestMethod.GET)
    public String addOrg(String parentOrgId, String parentOrgName, Model model){
        //保存到域对象中
        model.addAttribute("parentOrgId",parentOrgId);
        model.addAttribute("parentOrgName",parentOrgName);
        return "org/addOrg";
    }

    /**
     * 处理添加组织表单
     * @param org
     * @return
     */
    @RequestMapping(value={"addOrg"},method = RequestMethod.POST)
    @ResponseBody
    public StatusCode addOrg(Org org){
        //保存组织信息
        int result = orgService.insert(org);
        return StatusCodeUtil.check(result);
    }

    /**
     * 跳转到编辑组织页面
     * @param orgId
     * @return
     */
    @RequestMapping(value={"editOrg"},method=RequestMethod.GET)
    public String editOrg(int orgId){
        return "org/editOrg";
    }

    /**
     * 处理表单数据
     * @return
     */
    @RequestMapping(value={"editOrg"},method=RequestMethod.POST)
    @ResponseBody
    public StatusCode editOrg(Org org){
        return null;
    }
    
}
