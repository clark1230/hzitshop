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

	/**
	 * 根据id查询数据
	 * @param id
	 * @return
	 */
	Permission selectOne(int id);

	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	int getTotal(@Param("map")Map<String,Object> map);



} 
