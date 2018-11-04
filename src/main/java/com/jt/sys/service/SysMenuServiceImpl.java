package com.jt.sys.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jt.common.vo.Node;
import com.jt.sys.entity.SysMenu;
import com.jt.sys.mapper.SysMenuMapper;
import com.jt.sys.mapper.SysRoleMenuMapper;
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenuMapper sysMenuMapper;
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;
	@Override
	public List<Map<String, Object>> findObjects() {
		return sysMenuMapper.findObjects();
	}
	@Override
	@Transactional
	public Integer deleteObject(Integer id) {
		if(id==null) 
		throw new IllegalArgumentException("删除的id不合法！");
		Integer count = sysMenuMapper.getChildCount(id);
		if(count>0) 
		throw new IllegalArgumentException("请删除子集目录！");
		Integer rows = sysMenuMapper.deleteObject(id);
		sysRoleMenuMapper.deleteObjectsByMenuId(id);
		return rows;
	}
	@Override
	public List<Node> findZtreeMenuNodes() {
		return sysMenuMapper.findZtreeMenuNodes();
	}
	@Override
	public SysMenu saveObject(SysMenu sysMenu) {
		if(sysMenu==null)
			throw new IllegalArgumentException("输入参数不合法！");
		if(StringUtils.isEmpty(sysMenu.getName()))
			throw new IllegalArgumentException("请输入菜单名称！");
		if(StringUtils.isEmpty(sysMenu.getParentId()))
			throw new IllegalArgumentException("请选择上级菜单！");
		Integer count = sysMenuMapper.countSameName(sysMenu.getName(), sysMenu.getParentId());
		if(count>0) 
			throw new IllegalArgumentException("该目录已经存在！");
		sysMenu.setCreatedTime(new Date());
		sysMenu.setModifiedTime(new Date());
		sysMenu.setCreatedUser("system");
		sysMenu.setModifiedUser("system");
		sysMenuMapper.saveObject(sysMenu);
		return sysMenu;
	}
	@Override
	public Integer updateObject(SysMenu sysMenu) {
		if(sysMenu==null)
			throw new IllegalArgumentException("输入参数不合法！");
		if(StringUtils.isEmpty(sysMenu.getName()))
			throw new IllegalArgumentException("请输入菜单名称！");
		if(StringUtils.isEmpty(sysMenu.getParentId()))
			throw new IllegalArgumentException("请选择上级菜单！");
		Integer count = sysMenuMapper.countSameName(sysMenu.getName(), sysMenu.getParentId());
		if(count>0) 
			throw new IllegalArgumentException("该目录已经存在！");
		sysMenu.setModifiedTime(new Date());
		sysMenu.setModifiedUser("system");
		Integer rows = sysMenuMapper.updateObject(sysMenu);
		if(rows==0)
			throw new IllegalArgumentException("该记录已经被管理员删除！");
		return rows;
	}
	@Override
	public SysMenu selectObjectById(Integer id) {
		if(id==null) 
			throw new IllegalArgumentException("请输入要修改的菜单选项！");
		SysMenu sysMenu = sysMenuMapper.selectObjectById(id);
		if(sysMenu==null) 
			throw new IllegalArgumentException("该菜单已经被删除！请联系管理员！");
		return sysMenu;
	}
	
}
