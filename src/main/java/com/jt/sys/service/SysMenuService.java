package com.jt.sys.service;

import java.util.List;
import java.util.Map;

import com.jt.common.vo.Node;
import com.jt.sys.entity.SysMenu;

public interface SysMenuService {
	List<Map<String,Object>> findObjects();
	Integer deleteObject(Integer id);
	List<Node> findZtreeMenuNodes();
	SysMenu saveObject(SysMenu sysMenu);
	Integer updateObject(SysMenu sysMenu);
	SysMenu selectObjectById(Integer id);
}
