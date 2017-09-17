package com.hzit.hzitshop.service;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Role;
import org.apache.ibatis.annotations.Param;

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
}
