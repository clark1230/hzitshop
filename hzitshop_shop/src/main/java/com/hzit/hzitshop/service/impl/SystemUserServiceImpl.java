package com.hzit.hzitshop.service.impl;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Org;
import com.hzit.hzitshop.entity.Permission;
import com.hzit.hzitshop.entity.SystemUser;
import com.hzit.hzitshop.mapper.OrgMapper;
import com.hzit.hzitshop.mapper.PermissionMapper;
import com.hzit.hzitshop.mapper.SystemUserMapper;
import com.hzit.hzitshop.service.SystemUserService;
import com.hzit.hzitshop.vo.PermissionVo;
import com.hzit.hzitshop.vo.SystemUserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemUserServiceImpl  implements SystemUserService {
    @Autowired
    private SystemUserMapper userMapper;
    @Autowired
    private OrgMapper orgMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public LayuiData<SystemUserVo> selectPage(int page,int limit) {
        LayuiData<SystemUserVo> layuiData = new LayuiData<>();
        layuiData.setCode(0);
        layuiData.setCount(userMapper.getTotal());
        layuiData.setMsg("系统用户列表");
        Map<String,Object> map = new HashMap<>();
        map.put("offset",(page-1)*limit);
        map.put("limit",limit);


        List<SystemUserVo> systemUserVos = new ArrayList<>();
        SystemUserVo systemUserVo = null;
        List<SystemUser> systemUsers = userMapper.searchTbSystemUserByParams(map);
        common(systemUserVos, systemUsers);
        layuiData.setData(systemUserVos);
        return layuiData;
    }

    private void common(List<SystemUserVo> systemUserVos, List<SystemUser> systemUsers) {
        SystemUserVo systemUserVo = null;
        for(SystemUser systemUser : systemUsers){
            systemUserVo = new SystemUserVo();
            //根据id查询公司,部门岗位信息
            BeanUtils.copyProperties(systemUser,systemUserVo);
            Org org = null;
            if(StringUtils.isNoneEmpty(systemUser.getCompany())){
                org = orgMapper.selectOne(Integer.parseInt(systemUser.getCompany()));
                systemUserVo.setCompany(org.getName());
            }
            if(StringUtils.isNoneEmpty(systemUser.getDept())){
                org =orgMapper.selectOne(Integer.parseInt(systemUser.getDept()));
                systemUserVo.setDept(org.getName());
            }
            if(StringUtils.isNoneEmpty(systemUser.getJobId())){
                org = orgMapper.selectOne(Integer.parseInt(systemUser.getJobId()));
                systemUserVo.setJobId(org.getName());
            }
            systemUserVos.add(systemUserVo);
        }
    }

    /**
     * 启用或者禁用数据
     * @param map
     * @return
     */
    @Override
    public int lockUser(Map<String, Object> map) {
        return userMapper.lockUser(map);
    }

    /**
     * 批量删除数据
     * @param ids
     * @return
     */
    @Override
    public int deleteByIds(String[] ids) {
        return userMapper.deleteByIds(ids);
    }

    @Override
    public SystemUser login(Map<String, Object> map) {
        return userMapper.login(map);
    }

    /**
     * 根据参数查询数据
     * @param map
     * @return
     */
    @Override
    public List<SystemUserVo> selectByParams(Map<String, Object> map) {
        List<SystemUserVo> systemUserVos = new ArrayList<>();
        SystemUserVo systemUserVo = null;
        List<SystemUser> systemUsers = userMapper.selectByParams(map);
        common(systemUserVos,systemUsers);
        return systemUserVos;
    }

    /**
     * 修改密码
     * @param map
     * @return
     */
    @Override
    public int changePwd(Map<String, Object> map) {
        return userMapper.changePwd(map);
    }

    /**
     * 重置密码
     * @param systemUser
     * @return
     */
    @Override
    public int resetPwd(SystemUser systemUser) {
        return userMapper.resetPwd(systemUser);
    }

    @Override
    public int insert(SystemUser systemUser) {
       return userMapper.insertTbSystemUser(systemUser);
    }

    @Override
    public int delete(Integer userId) {
        return  userMapper.deleteTbSystemUserByUserId(userId);
    }

    @Override
    public int update(SystemUser systemUser) {
        return userMapper.updateTbSystemUser(systemUser);
    }

    /**
     * 根据id查询单条数据
     * @param id
     * @return
     */
    @Override
    public SystemUser selectOne(int id) {
        return userMapper.selectOne(id);
    }

    /**
     * 根据用户查询该用户所能访问的权限信息
     * @param userName
     * @return
     */
    @Override
    public List<PermissionVo> showMenu(String userName) {
        Map<String,Object> map = new HashMap<>();
        map.put("userName",userName);
        List<Permission> permissions = permissionMapper.showMenu(map);
        List<PermissionVo> permissionVos = new ArrayList<>();
        PermissionVo permissionVo =  null;
        for(Permission permission : permissions){
            if("1".equals(permission.getLevel())){//顶级菜单
                permissionVo =new PermissionVo();
                BeanUtils.copyProperties(permission,permissionVo);
                permissionVos.add(permissionVo);
            }else if("2".equals(permission.getLevel())){

            }else if("3".equals(permission.getLevel())){

            }
        }
        return null;
    }
}

