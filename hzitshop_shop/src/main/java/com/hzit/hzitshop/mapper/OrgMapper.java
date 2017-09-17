package com.hzit.hzitshop.mapper;

import java.util.List;
import java.util.Map;

import com.hzit.hzitshop.entity.Org;
import org.apache.ibatis.annotations.Param;

public interface OrgMapper {

	int insertTbOrg(Org tbOrg);

	int deleteTbOrgByOrgId(Integer orgId);

	int updateTbOrg(Org tbOrg);


	List<Org> searchTbOrgByParams(@Param("map") Map<String, String> map);

} 
