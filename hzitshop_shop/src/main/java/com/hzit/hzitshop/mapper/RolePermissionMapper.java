package com.hzit.hzitshop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.hzit.hzitshop.entity.RolePermission;

public interface RolePermissionMapper {

	void insertTbRolePermission(RolePermission tbRolePermission);

	void deleteTbRolePermissionById(Integer id);

	void updateTbRolePermission(RolePermission tbRolePermission);

	List<RolePermission> searchTbRolePermissionByParams(@Param("map") Map<String, String> map);

} 
