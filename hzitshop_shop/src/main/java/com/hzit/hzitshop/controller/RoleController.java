package com.hzit.hzitshop.controller;

import com.hzit.hzitshop.annotation.SystemLog;
import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Role;
import com.hzit.hzitshop.entity.SystemUser;
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
import java.util.Map;

/**
 * 角色控制器
 */
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;
    @SystemLog(module = "角色管理",methods = "role")
    @RequestMapping(value = {"role"},method = RequestMethod.GET)
    public String role(){
        return "role/role";
    }

    /**
     * 获取异步数据
     * @return
     */
    @SystemLog(module = "角色管理",methods = "roleAjax")
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
    @SystemLog(module = "角色管理",methods = "addRole")
    @RequestMapping(value = {"addRole"},method = RequestMethod.GET)
    public String addRole(){
        return "role/addRole";
    }
    /**
     * 保存添加的角色信息
     * @return
     */
    @SystemLog(module = "角色管理",methods = "addRole")
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
    @SystemLog(module = "角色管理",methods = "editRole")
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
    @SystemLog(module = "角色管理",methods = "editRole")
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
    @SystemLog(module = "角色管理",methods = "deleteRole")
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
    @SystemLog(module = "角色管理",methods = "lockRole")
    @RequestMapping(value = {"lockRole"})
    @ResponseBody
    public StatusCode lockRole(int roleId,int isLock) {
        Map<String, Object> map = new HashMap<>();
        map.put("roleId", roleId);
        map.put("isLock", isLock);
        int result = roleService.lockRole(map);
        return StatusCodeUtil.check(result);

    }
}
