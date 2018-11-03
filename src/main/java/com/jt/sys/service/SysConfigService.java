package com.jt.sys.service;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysConfig;

public interface SysConfigService {
	/**
	 * 查询当前页数据
	 * 查询总记录数
	 * @param name 查询时的参数名
	 * @param pageCurrent 当前页码
	 * @return 封装页面数据的对象
	 */
	PageObject<SysConfig> findPageObjects(
			String name,
			Integer pageCurrent);
	/**
	 * 删除选的记录
	 * @param ids 记录的Id
	 * @return 受影响的行数
	 */
	Integer deleteObject(Integer... ids);
	/**
	 * 保存一条信息
	 * @param sysConfig 信息对象
	 * @return 包含id的信息对象
	 */
	SysConfig saveObject(SysConfig sysConfig);
	/**
	 * 修改一条信息
	 * @param sysConfig
	 * @return
	 */
	Integer updateObject(SysConfig sysConfig);
}
