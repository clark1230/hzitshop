package com.hzit.hzitshop.service.impl;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Org;
import com.hzit.hzitshop.entity.OrgRole;
import com.hzit.hzitshop.mapper.OrgMapper;
import com.hzit.hzitshop.mapper.OrgRoleMapper;
import com.hzit.hzitshop.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrgServiceImpl  implements OrgService {
    @Autowired
    private OrgMapper orgMapper;
    @Autowired
    private OrgRoleMapper orgRoleMapper;
    @Override
    public int insert(Org org) {
        return orgMapper.insertTbOrg(org);
    }

    @Override
    public int delete(Integer orgId) {
        return orgMapper.deleteTbOrgByOrgId(orgId);
    }

    @Override
    public int update(Org org) {
        return orgMapper.updateTbOrg(org);
    }

    @Override
    public Org selectOne(int id) {
        return orgMapper.selectOne(id);
    }

    /**
     * 获取所有的组织数据
     * @return
     */
    @Override
    public List<Org> getOrg() {
        Map<String,Object> map = new HashMap<>();
        map.put("offset",0);
        map.put("limit",orgMapper.getTotal(null));
        return orgMapper.searchTbOrgByParams(map);
    }

    @Override
    public List<Org> getAll() {
        Map<String,Object> map = new HashMap<>();
        map.put("offset",0);
        map.put("limit",orgMapper.getTotal(null));
        return orgMapper.searchTbOrgByParams(map);
    }

    @Override
    public LayuiData<Org> selectPage(int page, int limit) {
        LayuiData<Org> layuiData = new LayuiData<>();
        layuiData.setCount(orgMapper.getTotal(null));
        layuiData.setMsg("组织信息");
        layuiData.setCode(0);
        Map<String,Object> map = new HashMap<>();
        map.put("offset",(page-1)*limit);
        map.put("limit",limit);
        layuiData.setData(orgMapper.searchTbOrgByParams(map));
        return layuiData;
    }

    /**
     * 根据类型查询组织信息
     * @param map
     * @return
     */
    @Override
    public List<Org> findByType(Map<String, Object> map) {
        map.put("offset",0);
        map.put("limit",orgMapper.getTotal(map));
        return  orgMapper.searchTbOrgByParams(map);
    }

    /**
     * 为岗位授予权限
     * @param orgId
     * @param roleIds
     * @return
     */
    @Override
    public int grantRole(String orgId, String roleIds) {
        //删除数据
        orgRoleMapper.deleteByOrgId(Integer.parseInt(orgId));
        int result = 0;
        for(String roleId : roleIds.split(",")){
            result+=orgRoleMapper.insertTbOrgRole(new OrgRole(Integer.parseInt(orgId),Integer.parseInt(roleId)));
        }
        return result;
    }

    /**
     * 角色信息回显
     * @param orgId
     * @return
     */
    @Override
    public String checkRole(String orgId) {
        //List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(" ");
        Map<String,Object> map = new HashMap<>();
        map.put("orgId",orgId);
        List<OrgRole> orgRoles = orgRoleMapper.searchTbOrgRoleByParams(map);
        for(OrgRole orgRole : orgRoles){
            sb.append(orgRole.getRoleId()+",");
        }
        String roleIds = sb.toString();
        return roleIds.substring(0,roleIds.length()-1).trim();
    }
}
