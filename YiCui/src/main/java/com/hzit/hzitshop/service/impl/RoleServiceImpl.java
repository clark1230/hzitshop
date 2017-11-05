package com.hzit.hzitshop.service.impl;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Role;
import com.hzit.hzitshop.entity.RolePermission;
import com.hzit.hzitshop.mapper.RoleMapper;
import com.hzit.hzitshop.mapper.RolePermissionMapper;
import com.hzit.hzitshop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl  implements RoleService{
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
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

    /**
     * 为角色授权
     * @param roleIds  多个角色编号
     * @param perIds  多个权限编号
     * @return
     */
    @Override
    public int grantPermission(String[] roleIds, String[] perIds) {
        //添加之前先删除该角色的权限信息
        int result = 0;
        for(String roleId : roleIds){
            rolePermissionMapper.deleteByRoleId(Integer.parseInt(roleId));
            for(String perId : perIds){

                result +=rolePermissionMapper.insertTbRolePermission(
                        new RolePermission(Integer.parseInt(roleId),Integer.parseInt(perId)));
            }
        }
        return result;
    }

    /**
     * 根据roleId获取该角色所拥有的权限信息
     * @param roleId
     * @return
     */
    @Override
    public List<Integer> checkPerrmission(String roleId) {
        List<Integer> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("roleId",roleId);
        List<RolePermission> rolePermissions = rolePermissionMapper.searchTbRolePermissionByParams(map);
        for(RolePermission rp : rolePermissions){
            list.add(rp.getPermissionId());
        }
        return list;
    }

    @Override
    public List<Role> getAll() {
        Map<String,Object> map = new HashMap<>();
        map.put("offset",0);
        map.put("limit",roleMapper.getTotal(null));
        return roleMapper.searchTbRoleByParams(map);
    }
}
