package com.hzit.hzitshop.service;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.SystemUser;
import com.hzit.hzitshop.vo.PermissionVo;
import com.hzit.hzitshop.vo.SystemUserVo;
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
    LayuiData<SystemUserVo> selectPage(int page, int limit);

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
    List<SystemUserVo> selectByParams(Map<String,Object> map);

    /**
     * 修改密码
     * @param map
     * @return
     */
    int changePwd(Map<String,Object> map);

    /**
     * 重置密码
     * @param systemUser
     * @return
     */
    int resetPwd(SystemUser systemUser);

    /**
     * 根据用户名查询该用户所能访问的权限信息
     * @param userName
     * @return
     */
    List<PermissionVo> showMenu(String userName);
}
