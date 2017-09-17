package com.hzit.hzitshop.service.impl;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Role;
import com.hzit.hzitshop.mapper.RoleMapper;
import com.hzit.hzitshop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RoleServiceImpl  implements RoleService{
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public int insert(Role role) {
        return roleMapper.insertTbRole(role);
    }

    @Override
    public int delete(Integer roleId) {
        return roleMapper.deleteTbRoleByRoleId(roleId);
    }

    @Override
    public int update(Role role) {
        return roleMapper.updateTbRole(role);
    }

    @Override
    public Role selectOne(int id) {
        return roleMapper.selectOne(id);
    }

    /**
     * 数据分页
     * @param page
     * @param limit
     * @return
     */
    @Override
    public LayuiData<Role> selectPage(int page, int limit) {
        LayuiData<Role> layuiData = new LayuiData<>();
        layuiData.setCode(0);
        layuiData.setMsg("角色列表");
        Map<String,Object> map = new HashMap<>();
        map.put("offset",(page-1)*limit);
        map.put("limit",limit);
        layuiData.setData(roleMapper.searchTbRoleByParams(map));
        layuiData.setCount(roleMapper.getTotal(null));
        return layuiData;
    }

    @Override
    public int deleteByIds(String[] ids) {
        return roleMapper.deleteByIds(ids);
    }

    /**
     * 角色的启用与禁用
     * @param map
     * @return
     */
    @Override
    public int lockRole(Map<String, Object> map) {
        return roleMapper.lockRole(map);
    }
}
