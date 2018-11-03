package com.jt.sys.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.sys.mapper.SysMenuMapper;
@Service
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenuMapper sysMenuMapper;
	@Override
	public List<Map<String, Object>> findObjects() {
		return sysMenuMapper.findObjects();
	}

	
}
