package com.hzit.hzitshop.service.impl;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Permission;
import com.hzit.hzitshop.mapper.PermissionMapper;
import com.hzit.hzitshop.service.PermissionService;
import com.hzit.hzitshop.vo.PermissionVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl  implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<PermissionVo> getAll() {
        Map<String,Object> map = new HashMap<>();
        map.put("offset",0);
        map.put("limit",permissionMapper.getTotal(null));
        List<PermissionVo> list = new ArrayList<>();
        PermissionVo vo = null;
        for(Permission p : permissionMapper.searchTbPermissionByParams(map)){
            vo = new PermissionVo();
            BeanUtils.copyProperties(p,vo,"icon");
            list.add(vo);
        }
        return list;
    }

    @Override
    public LayuiData<Permission> selectPage(int page, int limit) {
        LayuiData<Permission> layuiData = new LayuiData<>();
        layuiData.setCount(permissionMapper.getTotal(null));
        layuiData.setMsg("权限");
        layuiData.setCode(0);
        Map<String,Object> map = new HashMap<>();
        map.put("offset",(page-1)*limit);
        map.put("limit",limit);
        layuiData.setData(permissionMapper.searchTbPermissionByParams(map));
        return layuiData;
    }

    @Override
    public int insert(Permission permission) {
        return permissionMapper.insertTbPermission(permission);
    }

    @Override
    public int delete(Integer id) {
        return permissionMapper.deleteTbPermissionById(id);
    }

    @Override
    public int update(Permission permission) {
        return permissionMapper.updateTbPermission(permission);
    }

    @Override
    public Permission selectOne(int id) {
        return permissionMapper.selectOne(id);
    }
}
