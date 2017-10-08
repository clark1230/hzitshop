package com.hzit.hzitshop.controller;

import com.hzit.hzitshop.annotation.SystemLog;
import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Role;
import com.hzit.hzitshop.service.PermissionService;
import com.hzit.hzitshop.service.RoleService;
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
 * 角色控制器
 */
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @SystemLog(module = "角色管理",methods = "role",msg="跳转到角色管理页面")
    @RequestMapping(value = {"role"},method = RequestMethod.GET)
    public String role(){
        return "role/role";
    }

    /**
     * 获取异步数据
     * @return
     */
    @SystemLog(module = "角色管理",methods = "roleAjax",msg="异步获取角色分页数据")
    @RequestMapping(value = {"roleAjax"},method = RequestMethod.GET)
    @ResponseBody
    public LayuiData<Role> roleAjax(int page,int limit){
        LayuiData<Role> layuiData =  roleService.selectPage(page,limit);
        return layuiData;
    }

    /**
     * 跳转到添加角色页面
     * @return
     */
    @SystemLog(module = "角色管理",methods = "addRole",msg="跳转到添加角色页面")
    @RequestMapping(value = {"addRole"},method = RequestMethod.GET)
    public String addRole(){
        return "role/addRole";
    }
    /**
     * 保存添加的角色信息
     * @return
     */
    @SystemLog(module = "角色管理",methods = "addRole",msg="异步保存添加角色信息数据")
    @RequestMapping(value = {"addRole"},method = RequestMethod.POST)
    @ResponseBody
    public StatusCode addRole(Role role){
        role.setCreateTime(new Date());
        role.setCreateBy(SubjectUtil.getUser());
        int result = roleService.insert(role);
        return StatusCodeUtil.check(result);
    }


    /**
     * 跳转到修改用户页面
     * @return
     */
    @SystemLog(module = "角色管理",methods = "editRole",msg="跳转到编辑角色信息页面")
    @RequestMapping(value = {"editRole"},method = RequestMethod.GET)
    public String editRole(int roleId, Model model){
        Role role = roleService.selectOne(roleId);
        model.addAttribute("role",role);
        //获取要修改的用户信息
        return "role/editRole";
    }

    /**
     * 保存用户信息
     * @param role
     * @return
     */
    @SystemLog(module = "角色管理",methods = "editRole",msg="异步保存编辑角色信息数据")
    @RequestMapping(value = {"editRole"},method = RequestMethod.POST)
    @ResponseBody
    public StatusCode editRole(Role role){
        role.setUpdateTime(new Date());
        role.setUpdateBy(SubjectUtil.getUser());
        int result = roleService.update(role);
        return StatusCodeUtil.check(result);
    }

    /**
     * 批量删除数据
     * @param roleId
     * @return
     */
    @SystemLog(module = "角色管理",methods = "deleteRole",msg="批量删除角色信息")
    @RequestMapping(value = {"deleteRole"})
    @ResponseBody
    public StatusCode deleteSystemUser(String[] roleId){
        int result = roleService.deleteByIds(roleId);
        return StatusCodeUtil.check(result);
    }

    /**
     * 禁用与启用角色
     * @param roleId
     * @param isLock
     * @return
     */
    @SystemLog(module = "角色管理",methods = "lockRole",msg="锁定/启用角色")
    @RequestMapping(value = {"lockRole"})
    @ResponseBody
    public StatusCode lockRole(int roleId,int isLock) {
        Map<String, Object> map = new HashMap<>();
        map.put("roleId", roleId);
        map.put("isLock", isLock);
        int result = roleService.lockRole(map);
        return StatusCodeUtil.check(result);

    }

    /**
     * 角色授权
     * 权限信息回显
     * @param  roleIds 角色编号数组
     * @return
     */
    @RequestMapping(value = {"grantPermission"},method = RequestMethod.GET)
    public String grantPerrmission(String roleIds, Model model){
        model.addAttribute("roleIds",roleIds);
        return "role/grantPermission";
    }

    /**
     * 保存权限信息
     * @param roleIds
     * @param perIds
     * @return
     */
    @RequestMapping(value = "grantPermission",method = RequestMethod.POST)
    @ResponseBody
    public StatusCode grantPermission(String roleIds,String perIds){
        System.out.println("---------------");
        int result= roleService.grantPermission(roleIds.split(","),perIds.split(","));
        return StatusCodeUtil.check(result);
    }

    /**
     * 角色权限信息回显
     * @return
     */
    @RequestMapping(value={"checkPermission"},method = RequestMethod.GET)
    @ResponseBody
    public List<Integer> checkPermission(String roleIds){
        return roleService.checkPerrmission(roleIds.split(",")[0]);
    }

}
