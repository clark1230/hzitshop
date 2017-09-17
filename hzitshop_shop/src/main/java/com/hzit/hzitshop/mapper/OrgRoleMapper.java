package com.hzit.hzitshop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.hzit.hzitshop.entity.OrgRole;

public interface OrgRoleMapper {

	void insertTbOrgRole(OrgRole tbOrgRole);

	void deleteTbOrgRoleById(Integer id);

	void updateTbOrgRole(OrgRole tbOrgRole);


	List<OrgRole> searchTbOrgRoleByParams(@Param("map") Map<String, String> map);

} 
