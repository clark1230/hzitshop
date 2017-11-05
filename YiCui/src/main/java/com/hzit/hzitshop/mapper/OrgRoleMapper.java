package com.hzit.hzitshop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.hzit.hzitshop.entity.OrgRole;

public interface OrgRoleMapper {

	int insertTbOrgRole(OrgRole tbOrgRole);

	int deleteByOrgId(int orgId);




	List<OrgRole> searchTbOrgRoleByParams(@Param("map") Map<String, Object> map);

} 
