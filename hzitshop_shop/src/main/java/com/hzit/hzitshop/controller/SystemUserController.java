package com.hzit.hzitshop.controller;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Org;
import com.hzit.hzitshop.entity.SystemUser;
import com.hzit.hzitshop.service.OrgService;
import com.hzit.hzitshop.service.SystemUserService;
import com.hzit.hzitshop.util.StatusCode;
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

@Controller
public class SystemUserController {
    @Autowired
    private SystemUserService userService;
    @Autowired
    private OrgService orgService;

    /**
     * 跳转到系统用户主页
     * @return
     */
    @RequestMapping(value = {"systemUser"})
    public String systemUser(){
        return "/systemUser/systemUser";
    }
    /**
     * 获取json数据
     * @return
     */
    @RequestMapping(value = {"systemUserAjax"})
    @ResponseBody
    public LayuiData<SystemUser> systemUserAjajx(int page,int limit){
        LayuiData<SystemUser> layuiData = userService.selectPage(page,limit);
        return layuiData;
    }

    /**
     * 跳转到添加用户页面
     * @return
     */
    @RequestMapping(value = {"addSystemUser"},method = RequestMethod.GET)
    public String addSystemUser(Model model){
        Map<String,Object> map = new HashMap<>();
        map.put("type","公司");
        List<Org> orgCompany = orgService.findByType(map);
//        map.clear();;
//        map.put("type","部门");
//        List<Org> orgDept = orgService.findByType(map);
//        map.clear();;
//        map.put("type","岗位");
//        List<Org> orgJob = orgService.findByType(map);
        model.addAttribute("orgCompany",orgCompany);
//        model.addAttribute("orgDept",orgDept);
//        model.addAttribute("orgJob",orgJob);
        return "systemUser/addSystemUser";
    }

    /**
     * 保存添加的用户信息
     * @param systemUser
     * @return
     */
    @RequestMapping(value = {"addSystemUser"},method = RequestMethod.POST)
    @ResponseBody
    public StatusCode addSystemUser(SystemUser systemUser){
        StatusCode sc = new StatusCode();
        systemUser.setCreateTime(new Date());
        int result = userService.insert(systemUser);
        return  this.check(result);
    }

    /**
     * 跳转到修改用户页面
     * @return
     */
    @RequestMapping(value = {"editSystemUser"},method = RequestMethod.GET)
    public String editSystemUser(int userId, Model model){
        SystemUser systemUser = userService.selectOne(userId);
        model.addAttribute("systemUser",systemUser);
        //获取要修改的用户信息
        return "systemUser/editSystemUser";
    }

    /**
     * 保存用户信息
     * @param systemUser
     * @return
     */
    @RequestMapping(value = {"editSystemUser"},method = RequestMethod.POST)
    @ResponseBody
    public StatusCode editSystemUser(SystemUser systemUser){
        StatusCode sc = new StatusCode();
        systemUser.setUpdateTime(new Date());
        int result = userService.update(systemUser);
        return this.check(result);
    }

    public StatusCode check(int result){
        StatusCode sc = new StatusCode();
        if(result > 0){
            sc.setCode(200);
            sc.setMsg("保存成功!");
        }else{
            sc.setCode(500);
            sc.setMsg("保存失败!");
        }
        return sc;
    }

    /**
     * 禁用与启用用户
     * @param userId
     * @param isLock
     * @return
     */
    @RequestMapping(value = {"lockUser"})
    @ResponseBody
    public StatusCode lockUser(int userId,int isLock) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("isLock", isLock);
        int result = userService.lockUser(map);
        return this.check(result);

    }

    /**
     * 批量删除数据
     * @param userId
     * @return
     */
    @RequestMapping(value = {"deleteSystemUser"})
    @ResponseBody
    public StatusCode deleteSystemUser(String[] userId){
        int result = userService.deleteByIds(userId);
        return this.check(result);
    }
}
