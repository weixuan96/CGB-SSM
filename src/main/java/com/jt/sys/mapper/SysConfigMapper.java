package com.jt.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.sys.entity.SysConfig;

public interface SysConfigMapper {
	/**
	 * 基于条件和页码查询记录数
	 * @param name 查询参数名
	 * @param startIndex 起始页
	 * @param pageSize 每页记录数
	 * @return 封装记录对象的集合
	 */
	List<SysConfig> findPageObjects(
			@Param("name") String name,
			@Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize);
	/**
	 * 根据参数查询的总的记录数
	 * @param name 查询参数名
	 * @return 记录数
	 */
	Integer getRowCount(@Param("name") String name);
	/**
	 * 删除用户勾选的记录
	 * @param ids 勾选的id数组
	 * @return 受影响的行数
	 */
	Integer deleteObjects(@Param("ids") Integer... ids);
	/**
	 * 增加一条记录信息
	 * @param sysConfig pojo对象
	 * @return 受影响的行数
	 */
	Integer insertObject(SysConfig sysConfig);
	/**
	 * 修改一条配置信息
	 * @param sysConfig
	 * @return
	 */
	Integer updateObject(SysConfig sysConfig);
}
