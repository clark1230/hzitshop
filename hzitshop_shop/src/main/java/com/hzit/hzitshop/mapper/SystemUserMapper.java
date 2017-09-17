package com.hzit.hzitshop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.hzit.hzitshop.entity.SystemUser;

public interface SystemUserMapper {

	int insertTbSystemUser(SystemUser tbSystemUser);

	int deleteTbSystemUserByUserId(Integer userId);

	int updateTbSystemUser(SystemUser tbSystemUser);

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
} 
