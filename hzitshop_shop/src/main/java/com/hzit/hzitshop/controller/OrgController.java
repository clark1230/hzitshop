package com.hzit.hzitshop.controller;

import com.hzit.hzitshop.annotation.SystemLog;
import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Org;
import com.hzit.hzitshop.service.OrgService;
import com.hzit.hzitshop.util.StatusCode;
import com.hzit.hzitshop.util.StatusCodeUtil;
import com.hzit.hzitshop.util.SubjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @SystemLog(module = "组织管理",methods = "org")
    @RequestMapping(value = {"org"})
    public String org(){
        return "org/org";
    }

    /**
     * 异步获取组织数据
     * @return
     */
    @SystemLog(module = "组织管理",methods = "orgAjaxTree")
    @RequestMapping(value = {"orgAjaxTree"},method = RequestMethod.GET)
    @ResponseBody
    public List<Org>  orgAjaxTree(){
        List<Org> orgList = orgService.getOrg();
        return orgList;
    }

    /**
     * 异步获取表格分页
     * @param page
     * @param limit
     * @return
     */
    @SystemLog(module = "组织管理",methods = "orgAjax")
    @RequestMapping(value = {"orgAjax"},method = RequestMethod.GET)
    @ResponseBody
    public LayuiData<Org> orgAjax(int page,int limit){
        LayuiData<Org> layuiData = orgService.selectPage(page,limit);
        return layuiData;
    }
    /**
     * 跳转到添加组织页面
     * @return
     */
    @SystemLog(module = "组织管理",methods = "addOrg")
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
    @SystemLog(module = "组织管理",methods = "addOrg")
    @RequestMapping(value={"addOrg"},method = RequestMethod.POST)
    @ResponseBody
    public StatusCode addOrg(Org org){
        org.setCreateTime(new Date());
        org.setCreateBy(SubjectUtil.getUser());
        org.setCreateBy(SubjectUtil.getUser());
        //保存组织信息
        int result = orgService.insert(org);
        return StatusCodeUtil.check(result);
    }

    /**
     * 跳转到编辑组织页面
     * @param orgId
     * @return
     */
    @SystemLog(module = "组织管理",methods = "editOrg")
    @RequestMapping(value={"editOrg"},method=RequestMethod.GET)
    public String editOrg(int orgId,Model model){
        Org org = orgService.selectOne(orgId);
        model.addAttribute("org",org);
        model.addAttribute("orgList",orgService.getAll());
        return "org/editOrg";
    }

    /**
     * 处理表单数据
     * 
     * @return
     */
    @SystemLog(module = "组织管理",methods = "editOrg")
    @RequestMapping(value={"editOrg"},method=RequestMethod.POST)
    @ResponseBody
    public StatusCode editOrg(Org org){
        org.setUpdateTime(new Date());
        org.setUpdateBy(SubjectUtil.getUser());
        org.setUpdateBy(SubjectUtil.getUser());
        int result = orgService.update(org);
        return StatusCodeUtil.check(result);
    }

    /**
     * 异步获取组织信息
     * @param orgParentId
     * @return
     */
    @SystemLog(module = "组织管理",methods = "orgTypeAjax")
    @RequestMapping(value ={"orgTypeAjax"},method = RequestMethod.GET)
    @ResponseBody
    public List<Org> orgTypeAjax(String orgParentId){
        Map<String,Object> map = new HashMap<>();
        map.put("orgParentId",orgParentId);
        return orgService.findByType(map);
    }
}
