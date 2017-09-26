package com.hzit.hzitshop.service;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.SystemUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SystemUserService extends BaseService<SystemUser>{
    /**
     * 数据分页
     * @param page
     * @param limit
     * @return
     */
    LayuiData<SystemUser> selectPage(int page,int limit);

    /**
     * 禁用与启用用户
     * @param map
     * @return
     */
    int lockUser(@Param("map") Map<String,Object> map);

    /**
     * 批量删除数据
     * @param ids
     * @return
     */
    int deleteByIds(String[] ids);

    /**
     * 系统登录
     * @param map
     * @return
     */
    SystemUser login(Map<String,Object> map);
    /**
     * 根据参数查询数据
     * @param map
     * @return
     */
    List<SystemUser> selectByParams(Map<String,Object> map);
}
