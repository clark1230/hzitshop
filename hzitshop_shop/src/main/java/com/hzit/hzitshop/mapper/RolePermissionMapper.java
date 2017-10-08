package com.hzit.hzitshop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.hzit.hzitshop.entity.RolePermission;

public interface RolePermissionMapper {

	int insertTbRolePermission(RolePermission tbRolePermission);

	/**
	 * 根据roleId删除数据
	 * @param roleId
	 * @return
	 */
	int deleteByRoleId(int roleId);

	List<RolePermission> searchTbRolePermissionByParams(@Param("map") Map<String, Object> map);

} 
