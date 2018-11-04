package com.jt.sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jt.common.vo.Node;
import com.jt.sys.entity.SysMenu;

public interface SysMenuMapper {
	/**
	 * 基于菜单id统计子菜单的个数
	 * @param id
	 * @return
	 */
	Integer getChildCount(Integer id);
	/**
	 * 查询所有菜单以及上级菜单信息（）
	 * @param id
	 * @return
	 */
	Integer deleteObject(Integer id);
	/**
	 * 查询所有菜单以及上级菜单信息
	 * @return
	 */
	List<Map<String,Object>> findObjects();
	/**
	 * 查询菜单的节点，此信息会在客户端的zTree对象上呈现
	 */
	List<Node> findZtreeMenuNodes();
	/**
	 * 增加一条菜单信息
	 * @param sysMenu
	 * @return 受影响的行数
	 */
	Integer saveObject(SysMenu sysMenu);
	Integer countSameName(
			@Param("name")String name,
			@Param("parentId") Integer parentId);
	/**
	 * 修改一条菜单信息
	 * @param sysMenu
	 * @return
	 */
	Integer updateObject(SysMenu sysMenu);
	/**
	 * 根据id查找菜单信息
	 * @param id
	 * @return
	 */
	SysMenu selectObjectById(Integer id);
}
