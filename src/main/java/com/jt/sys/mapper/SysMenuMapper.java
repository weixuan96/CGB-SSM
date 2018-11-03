package com.jt.sys.mapper;

import java.util.List;
import java.util.Map;

public interface SysMenuMapper {
	/**
	 * 查询所有菜单以及上级菜单信息
	 * @return
	 */
	List<Map<String,Object>> findObjects();
}
