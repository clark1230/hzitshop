package com.hzit.hzitshop.mapper;

import java.util.List;
import java.util.Map;

import com.hzit.hzitshop.entity.OrgPermission;

public interface OrgPermissionMapper {

	void insertTbOrgPermission(OrgPermission tbOrgPermission);

	void deleteTbOrgPermissionById(Integer id);

	void updateTbOrgPermission(OrgPermission tbOrgPermission);


	List<OrgPermission> searchTbOrgPermissionByParams(Map<String, String> map);

} 
