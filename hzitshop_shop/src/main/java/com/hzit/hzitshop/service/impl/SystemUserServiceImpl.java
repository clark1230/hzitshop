package com.hzit.hzitshop.service.impl;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Org;
import com.hzit.hzitshop.entity.SystemUser;
import com.hzit.hzitshop.mapper.OrgMapper;
import com.hzit.hzitshop.mapper.SystemUserMapper;
import com.hzit.hzitshop.service.SystemUserService;
import com.hzit.hzitshop.vo.SystemUserVo;
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
        for(SystemUser systemUser : userMapper.searchTbSystemUserByParams(map)){
            systemUserVo = new SystemUserVo();
            //根据id查询公司,部门岗位信息
            BeanUtils.copyProperties(systemUser,systemUserVo);
            Org org = orgMapper.selectOne(Integer.parseInt(systemUser.getCompany()));
            systemUserVo.setCompany(org.getName());
            org =orgMapper.selectOne(Integer.parseInt(systemUser.getDept()));
            systemUserVo.setDept(org.getName());
            org = orgMapper.selectOne(Integer.parseInt(systemUser.getJobId()));
            systemUserVo.setJobId(org.getName());
            systemUserVos.add(systemUserVo);
        }
        layuiData.setData(systemUserVos);
        return layuiData;
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
    public List<SystemUser> selectByParams(Map<String, Object> map) {
        return this.userMapper.selectByParams(map);
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
}

