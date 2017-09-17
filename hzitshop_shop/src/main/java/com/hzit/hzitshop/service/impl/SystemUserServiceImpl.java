package com.hzit.hzitshop.service.impl;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.SystemUser;
import com.hzit.hzitshop.mapper.SystemUserMapper;
import com.hzit.hzitshop.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Service
public class SystemUserServiceImpl  implements SystemUserService {
    @Autowired
    private SystemUserMapper userMapper;
    @Override
    public LayuiData<SystemUser> selectPage(int page,int limit) {
        LayuiData<SystemUser> layuiData = new LayuiData<>();
        layuiData.setCode(0);
        layuiData.setCount(userMapper.getTotal());
        layuiData.setMsg("系统用户列表");
        Map<String,Object> map = new HashMap<>();
        map.put("offset",(page-1)*limit);
        map.put("limit",limit);
        layuiData.setData(userMapper.searchTbSystemUserByParams(map));
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
