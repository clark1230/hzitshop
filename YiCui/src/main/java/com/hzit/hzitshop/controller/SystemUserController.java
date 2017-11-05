package com.hzit.hzitshop.controller;

import com.hzit.hzitshop.annotation.SystemLog;
import com.hzit.hzitshop.email.EmailUtil;
import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Org;
import com.hzit.hzitshop.entity.SystemUser;
import com.hzit.hzitshop.service.OrgService;
import com.hzit.hzitshop.service.SystemUserService;
import com.hzit.hzitshop.util.Md5Util;
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
    @SystemLog(module = "用户管理",methods = "systemUser",msg="跳转到用户管理界面")
    @RequestMapping(value = {"systemUser"})
    public String systemUser(){
        return "/systemUser/systemUser";
    }
    /**
     * 获取json数据
     * @return
     */
    @SystemLog(module = "用户管理",methods = "systemUserAjax",msg="异步获取用户分页数据")
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
    @SystemLog(module = "用户管理",methods = "addSystemUser",msg="跳转到添加用户页面")
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
    @SystemLog(module = "用户管理",methods = "addSystemUser",msg="异步保存添加用户信息数据")
    @RequestMapping(value = {"addSystemUser"},method = RequestMethod.POST)
    @ResponseBody
    public StatusCode addSystemUser(SystemUser systemUser) throws Exception {
        StatusCode sc = new StatusCode();
        systemUser.setCreateBy(SubjectUtil.getUser());
        systemUser.setCreateTime(new Date());
        Random random = new Random();
        int randomValue = random.nextInt(1000000);
        systemUser.setPassword(Md5Util.getMD5(Md5Util.getMD5("hzit#"+randomValue)));
        try{
            EmailUtil.sendEmail("","",systemUser.getEmail(),
                    "合众艾特咨询系统登陆用户名:"+systemUser.getUserName()+",密码:"+randomValue);
        }catch (Exception e){
            systemUser.setPassword(Md5Util.getMD5(Md5Util.getMD5("hzit#hzit123456")));
        }
        int result = userService.insert(systemUser);
        return StatusCodeUtil.check(result);
    }

    /**
     * 跳转到修改用户页面
     * @return
     */
    @SystemLog(module = "用户管理",methods = "editSystemUser",msg="跳转到编辑用户信息页面")
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
    @SystemLog(module = "用户管理",methods = "editSystemUser",msg="异步保存编辑用户信息")
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
    @SystemLog(module = "用户管理",methods = "lockUser",msg="禁用/启用用户")
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
    @SystemLog(module = "用户管理",methods = "deleteSystemUser",msg="批量删除用户数据")
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
    @SystemLog(module = "用户管理",methods = "onlineUser",msg="获取在线用户信息")
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
    @SystemLog(module = "用户管理",methods = "showUser",msg="展示个人信息")
    @RequestMapping(value={"showUser"})
    public String showUser(Model model){
        Map<String,Object> map = new HashMap<>();
        map.put("userName",SubjectUtil.getUser());
        List<SystemUserVo> systemUsers = userService.selectByParams(map);
        model.addAttribute("systemUser",systemUsers.get(0));
        return "systemUser/showUser";
    }

    /**
     * 修改密码
     * @return
     */
    @SystemLog(module = "用户管理",methods = "changePwd",msg="修改密码")
    @RequestMapping(value={"/changePwd"},method = RequestMethod.GET)
    public String changePwd(){
        return "systemUser/changePwd";
    }

    /**
     * 异步处理用户修改密码
     * @param oldPwd  旧密码
     * @param newPwd  新密码
     * @param newPwd2  校验密码
     * @return
     */
    @SystemLog(module = "用户管理",methods = "changePwd",msg="异步获取用户修改的密码")
    @RequestMapping(value="changePwd",method = RequestMethod.POST)
    @ResponseBody
    public StatusCode changePwd(String oldPwd,String newPwd,String newPwd2) throws Exception {
        if(newPwd!= null &&!newPwd.trim().equals(newPwd2.trim())){
            StatusCode sc = new StatusCode();
            sc.setMsg("两次密码不一致！");
            sc.setCode(500);
            return  sc;
        }else{
            Map<String,Object> paramsMap =new HashMap<>();
            paramsMap.put("userName", SubjectUtil.getUser());
            paramsMap.put("newPwd",Md5Util.getMD5(Md5Util.getMD5("hzit#"+oldPwd)));
            paramsMap.put("oldPwd",Md5Util.getMD5(Md5Util.getMD5("hzit#"+newPwd)));
            int result = userService.changePwd(paramsMap);
            System.out.println(result);
            return StatusCodeUtil.check(result);
        }

    }

    /**
     * 跳转到分配岗位
     * @param userId  用户编号
     * @param model
     * @return
     */
    @RequestMapping(value={"grantJob"},method = RequestMethod.GET)
    public String grantJob(String userId,Model model){
        model.addAttribute("userId",userId);
        return "systemUser/grantJob";
    }

    /**
     * 重置密码
     * @param systemUser
     * @return
     * @throws Exception
     */
    @RequestMapping(value="resetPwd",method = RequestMethod.POST)
    @ResponseBody
    public StatusCode resetPwd(SystemUser systemUser) throws Exception {
        Random random = new Random();
        int randomValue = random.nextInt(1000000);
        systemUser.setPassword(Md5Util.getMD5(Md5Util.getMD5("hzit#"+randomValue)));
        try{
            EmailUtil.sendEmail("","",systemUser.getEmail(),
                    "合众艾特咨询系统登陆用户名:"+systemUser.getUserName()+",密码:"+randomValue);
        }catch (Exception e){
            systemUser.setPassword(Md5Util.getMD5(Md5Util.getMD5("hzit#hzit123456")));
        }

        int result = userService.resetPwd(systemUser);
        return StatusCodeUtil.check(result);
    }



}
