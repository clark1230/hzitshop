package com.hzit.hzitshop.controller;

import com.hzit.hzitshop.annotation.SystemLog;
import com.hzit.hzitshop.entity.LayuiData;
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
    @SystemLog(module = "权限管理",methods = "permission",msg="跳转到权限管理页面")
    @RequestMapping(value = {"permission"})
    public String permission(){
        return "permission/permission";
    }

    /**
     * 异步获取权限树信息
     * @return
     */
    @SystemLog(module = "权限管理",methods = "permissionAjaxTree",msg="异步获取树形权限管理数据")
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
    @SystemLog(module = "权限管理",methods = "permissionAjax",msg="异步获取权限管理分页数据")
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
    @SystemLog(module = "权限管理",methods = "addPermission",msg="跳转到权限管理页面")
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
    @SystemLog(module = "权限管理",methods = "addPermission",msg="异步保存添加权限信息数据")
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
    @SystemLog(module = "权限管理",methods = "icon",msg="跳转到图标页面")
    @RequestMapping(value={"icon"})
    public String icon(){
        return  "permission/icon";
    }

    /**
     * 跳转到编辑页面
     * @param id
     * @param pid
     * @return
     */
    @SystemLog(module = "权限管理",methods = "editPemission",msg="跳转到权限信息编辑页面")
    @RequestMapping(value={"editPermission"},method = RequestMethod.GET)
    public String editPermission(String id,String pid,Model model){
            //到数据库中根据id查询权限信息
            Permission permission = permissionService.selectOne(Integer.parseInt(id));
            model.addAttribute("permission",permission);
            model.addAttribute("pid",pid);
            return "permission/editPermission";
    }

    /**
     * 处理修改权限表单请求
     * @param permission
     * @return
     */
    @SystemLog(module = "权限管理",methods = "editPermission",msg="异步保存编辑权限信息数据")
    @RequestMapping(value={"editPermission"},method=RequestMethod.POST)
    @ResponseBody
    public StatusCode editPermission(Permission permission){
        permission.setUpdateBy(SubjectUtil.getUser());
        permission.setUpdateTime(new Date());
        int result = permissionService.update(permission);
        return StatusCodeUtil.check(result);
    }
}
