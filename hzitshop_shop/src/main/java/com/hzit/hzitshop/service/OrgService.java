package com.hzit.hzitshop.service;

import com.hzit.hzitshop.entity.Org;

import java.util.List;

public interface OrgService extends  BaseService<Org> {

   List<Org> getOrg();
}
