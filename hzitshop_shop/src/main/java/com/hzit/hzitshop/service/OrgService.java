package com.hzit.hzitshop.service;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Org;

import java.util.List;
import java.util.Map;

public interface OrgService extends  BaseService<Org> {

   List<Org> getOrg();

   /**
    * 根据组织编号查询数据
    * @return
    */
   //Org selectOne(int orgId);

   List<Org> getAll();

   LayuiData<Org> selectPage(int page,int limit);

   /**
    * 根据类型查询组织信息
    * @param map
    * @return
    */
   List<Org> findByType(Map<String,Object> map);

   /**
    * 为岗位授予权限
    * @param orgId
    * @param roleIds
    * @return
    */
   int grantRole(String orgId,String roleIds);

   /**
    * 角色信息回显
    * @param orgId
    * @return
    */
   String checkRole(String orgId);

}
