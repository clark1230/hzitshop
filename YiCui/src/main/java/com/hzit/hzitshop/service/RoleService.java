package com.hzit.hzitshop.service;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleService extends  BaseService<Role> {
    /**
     * 数据分页
     * @param page
     * @param limit
     * @return
     */
    LayuiData<Role> selectPage(int page,int limit);
    /**
     * 批量删除数据
     * @param ids
     * @return
     */
    int deleteByIds(String[] ids);
    /**
     * 禁用与启用用户
     * @param map
     * @return
     */
    int lockRole(@Param("map") Map<String,Object> map);

    /**
     * 角色授权
     * @param roleIds  多个角色编号
     * @param perIds  多个权限编号
     * @return
     */
    int grantPermission(String[] roleIds,String[] perIds);

    /**
     * 根据roleId编号获取该角色所拥有的权限信息
     * @param roleId
     * @return
     */
    List<Integer>  checkPerrmission(String roleId);

    List<Role> getAll();
}
