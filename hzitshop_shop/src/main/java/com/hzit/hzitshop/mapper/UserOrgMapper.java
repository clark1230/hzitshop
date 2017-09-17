package com.hzit.hzitshop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.hzit.hzitshop.entity.UserOrg;

public interface UserOrgMapper {

	void insertTbUserOrg(UserOrg tbUserOrg);

	void deleteTbUserOrgById(Integer id);

	void updateTbUserOrg(UserOrg tbUserOrg);


	List<UserOrg> searchTbUserOrgByParams(@Param("map") Map<String, String> map);

} 
