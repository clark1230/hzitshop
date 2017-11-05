package com.hzit.hzitshop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.hzit.hzitshop.entity.LogEntity;

public interface LogMapper {
	/**
	 * 添加日志信息
	 * @param tbLog
	 * @return
	 */
	int insertTbLog(LogEntity tbLog);

	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	List<LogEntity> searchTbLogByParams(@Param("map") Map<String, Object> map);

	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	int getTotal(@Param("map")Map<String,Object> map);
} 
