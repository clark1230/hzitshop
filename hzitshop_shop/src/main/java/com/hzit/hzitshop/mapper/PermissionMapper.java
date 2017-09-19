package com.hzit.hzitshop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.hzit.hzitshop.entity.Permission;

public interface PermissionMapper {

	int insertTbPermission(Permission tbPermission);

	int deleteTbPermissionById(Integer id);

	int updateTbPermission(Permission tbPermission);


	List<Permission> searchTbPermissionByParams(@Param("map") Map<String, Object> map);

	Permission selectOne(int id);


	int getTotal(@Param("map")Map<String,Object> map);

} 
