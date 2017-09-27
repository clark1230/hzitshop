package com.hzit.hzitshop.controller;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Org;
import com.hzit.hzitshop.entity.SystemUser;
import com.hzit.hzitshop.service.OrgService;
import com.hzit.hzitshop.service.SystemUserService;
import com.hzit.hzitshop.util.StatusCode;
import com.hzit.hzitshop.util.StatusCodeUtil;
import com.hzit.hzitshop.util.SubjectUtil;
import com.hzit.hzitshop.vo.SystemUserVo;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class SystemUserController {
    @Autowired
    private SystemUserService userService;
    @Autowired
    private OrgService orgService;
    @Autowired
    private SessionDAO sessionDAO;

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
    public LayuiData<SystemUserVo> systemUserAjajx(int page, int limit){
        LayuiData<SystemUserVo> layuiData = userService.selectPage(page,limit);
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

        model.addAttribute("orgCompany",orgCompany);

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
        systemUser.setCreateBy(SubjectUtil.getUser());
        systemUser.setCreateTime(new Date());
        int result = userService.insert(systemUser);
        return StatusCodeUtil.check(result);
    }

    /**
     * 跳转到修改用户页面
     * @return
     */
    @RequestMapping(value = {"editSystemUser"},method = RequestMethod.GET)
    public String editSystemUser(int userId, Model model){
        SystemUser systemUser = userService.selectOne(userId);
        model.addAttribute("systemUser",systemUser);
        //获取公司，部门，岗位信息
        Map<String,Object> map = new HashMap<>();
        map.put("type","公司");
        List<Org> orgCompany = orgService.findByType(map);
        model.addAttribute("orgCompany",orgCompany);

        map.clear();
        map.put("type","部门");
        model.addAttribute("orgDept",orgService.findByType(map));
        map.clear();
        map.put("type","岗位");
        model.addAttribute("orgJob",orgService.findByType(map));
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
        systemUser.setUpdateBy(SubjectUtil.getUser());
        int result = userService.update(systemUser);
        return StatusCodeUtil.check(result);
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
        return StatusCodeUtil.check(result);

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
        return StatusCodeUtil.check(result);
    }

    /**
     * 获取在线用户信息
     * @return
     */
    @RequestMapping(value = {"onlineUser"})
    @ResponseBody
    public String onlineUser(){
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        for(Session session : sessions){
            System.out.println(session.getHost());
            System.out.println(session.getTimeout());
            System.out.println(session.getLastAccessTime());   //上次访问时间
            System.out.println(session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY"));
        }
        return "哈哈";
    }

    /**
     * 展示个人信息
     * @return
     */
    @RequestMapping(value={"/showUser"},method = RequestMethod.GET)
    public String showUser(Model model){
        Map<String,Object> map = new HashMap<>();
        map.put("userName",SubjectUtil.getUser());
        List<SystemUser> systemUsers = userService.selectByParams(map);
        model.addAttribute("systemUser",systemUsers.get(0));
        return "systemUser/showUser";
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping(value={"/changePwd"},method = RequestMethod.GET)
    public String changePwd(){
        return "systemUser/changePwd";
    }
}
