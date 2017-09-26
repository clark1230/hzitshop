package com.hzit.hzitshop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.hzit.hzitshop.entity.SystemUser;

public interface SystemUserMapper {
	/**
	 * 添加用户数据
	 * @param tbSystemUser
	 * @return
	 */
	int insertTbSystemUser(SystemUser tbSystemUser);

	/**
	 * 根据id删除数据
	 * @param userId
	 * @return
	 */
	int deleteTbSystemUserByUserId(Integer userId);

	/**
	 * 根据用户编号更新数据
	 * @param tbSystemUser
	 * @return
	 */
	int updateTbSystemUser(SystemUser tbSystemUser);

	/**
	 * 数据分页
	 * @param map
	 * @return
	 */
	List<SystemUser> searchTbSystemUserByParams(@Param("map") Map<String, Object> map);

	/**
	 * 获取总记录数
	 */
	int getTotal();

	/**
	 * 根据userId查询单条路基
	 * @param userId
	 * @return
	 */
	SystemUser selectOne(int userId);

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
	 * 系统登陆
	 * @param map
	 * @return
	 */
	SystemUser login(@Param("map")Map<String,Object> map);

	/**
	 * 根据参数查询数据
	 * @param map
	 * @return
	 */
	List<SystemUser> selectByParams(@Param("map")Map<String,Object> map);
} 
