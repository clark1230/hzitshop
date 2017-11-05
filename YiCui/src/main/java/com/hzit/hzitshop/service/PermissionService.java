package com.hzit.hzitshop.service;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Permission;
import com.hzit.hzitshop.vo.PermissionVo;

import java.util.List;

public interface PermissionService extends  BaseService<Permission> {
    List<PermissionVo> getAll();

    LayuiData<Permission> selectPage(int page,int limit);
}
