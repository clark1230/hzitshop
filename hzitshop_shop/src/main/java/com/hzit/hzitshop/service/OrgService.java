package com.hzit.hzitshop.service;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Org;

import java.util.List;

public interface OrgService extends  BaseService<Org> {

   List<Org> getOrg();

   /**
    * 根据组织编号查询数据
    * @return
    */
   //Org selectOne(int orgId);

   List<Org> getAll();

   LayuiData<Org> selectPage(int page,int limit);

}
