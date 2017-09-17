package com.hzit.hzitshop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.hzit.hzitshop.entity.Role;

public interface RoleMapper {

	int insertTbRole(Role tbRole);

	int deleteTbRoleByRoleId(Integer roleId);

	int updateTbRole(Role tbRole);

	/**
	 * 数据分页查询
	 * @param map
	 * @return
	 */
	List<Role> searchTbRoleByParams(@Param("map") Map<String, Object> map);

	/**
	 * 获取查询记录数
	 * @param map
	 * @return
	 */
	int getTotal(@Param("map")Map<String,Object> map);

	/**
	 * 根据roleId查询数据
	 * @param roleId
	 * @return
	 */
	Role selectOne(int roleId);

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	int deleteByIds(String[] ids);
	/**
	 * 禁用与启用角色
	 * @param map
	 * @return
	 */
	int lockRole(@Param("map") Map<String,Object> map);
} 
