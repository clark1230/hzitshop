package com.hzit.hzitshop.service.impl;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.Org;
import com.hzit.hzitshop.mapper.OrgMapper;
import com.hzit.hzitshop.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrgServiceImpl  implements OrgService {
    @Autowired
    private OrgMapper orgMapper;
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
}
