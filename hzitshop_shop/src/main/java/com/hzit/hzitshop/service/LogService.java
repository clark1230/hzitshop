package com.hzit.hzitshop.service;

import com.hzit.hzitshop.entity.LayuiData;
import com.hzit.hzitshop.entity.LogEntity;

import java.util.Map;

public interface LogService {
    /**
     * 保存日志信息
     * @param log
     * @return
     */
    public int saveLog(LogEntity log);

    /**
     * 查询分页
     * @param map
     * @return
     */
    public LayuiData<LogEntity> page(Map<String,Object> map);
}
