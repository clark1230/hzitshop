package com.hzit.hzitshop.controller;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Org;
import com.hzit.hzitshop.entity.Permission;
import com.hzit.hzitshop.service.PermissionService;
import com.hzit.hzitshop.util.StatusCode;
import com.hzit.hzitshop.util.StatusCodeUtil;
import com.hzit.hzitshop.util.SubjectUtil;
import com.hzit.hzitshop.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = {"permission"})
    public String permission(){
        return "permission/permission";
    }

    /**
     * 异步获取权限树信息
     * @return
     */
    @RequestMapping(value = {"permissionAjaxTree"},method = RequestMethod.GET)
    @ResponseBody
    public List<PermissionVo> pemissionAjaxTree(){
        return permissionService.getAll();
    }

    /**
     * 异步获取权限分页信息
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = {"permissionAjax"})
    @ResponseBody
    public LayuiData<Permission> permissionAjax(int page,int limit){
        LayuiData<Permission> layuiData = permissionService.selectPage(page,limit);
        return layuiData;
    }

    /**
     * 跳转到添加组织页面
     * @return
     */
    @RequestMapping(value = {"addPermission"},method = RequestMethod.GET)
    public String addOrg(String pid, String pName, Model model){
        //保存到域对象中
        model.addAttribute("pid",pid);
        model.addAttribute("pName",pName);
        return "permission/addPermission";
    }

    /**
     * 处理添加组织表单
     * @return
     */
    @RequestMapping(value={"addPermission"},method = RequestMethod.POST)
    @ResponseBody
    public StatusCode addOrg(Permission permission){
        permission.setCreateBy(SubjectUtil.getUser());
        permission.setCreateTime(new Date());
        //保存组织信息
        int result = permissionService.insert(permission);
        return StatusCodeUtil.check(result);
    }

    /**
     * 跳转到图标页面
     * @return
     */
    @RequestMapping(value={"icon"})
    public String icon(){
        return  "permission/icon";
    }

}
