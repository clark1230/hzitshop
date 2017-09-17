package com.hzit.hzitshop.service.impl;

import com.hzit.hzitshop.entity.Org;
import com.hzit.hzitshop.mapper.OrgMapper;
import com.hzit.hzitshop.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    /**
     * 获取所有的组织数据
     * @return
     */
    @Override
    public List<Org> getOrg() {
        return orgMapper.searchTbOrgByParams(null);
    }
}
