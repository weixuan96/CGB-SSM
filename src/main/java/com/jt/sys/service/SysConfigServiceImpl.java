package com.jt.sys.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysConfig;
import com.jt.sys.exception.ServiceException;
import com.jt.sys.mapper.SysConfigMapper;
@Service
public class SysConfigServiceImpl implements SysConfigService{
	@Autowired
	private SysConfigMapper sysConfigMapper;
	@Override
	@Transactional
	public PageObject<SysConfig> findPageObjects(String name, Integer pageCurrent) {
		//1.参数的合法性校验
		if(pageCurrent==null || pageCurrent<0) {
			pageCurrent = 1;
		}
		//2.查询总记录数
		int rows = sysConfigMapper.getRowCount(name);
		//3.验证总记录数(加入总记录数为0，则抛出异常)
		if(rows==0) {
			throw new ServiceException("没有找到符合条件的记录！请重新输入查询条件！");
		}
		PageObject<SysConfig> page = new PageObject<>();
		//4.查询当前页数据
		int pageSize = PageObject.PAGESIZE;
		int startIndex = (pageCurrent-1)*pageSize;
		List<SysConfig> list = sysConfigMapper.findPageObjects(name, startIndex, PageObject.PAGESIZE);
		//5.封装数据并返回
		page.setPageCurrent(pageCurrent);//设置当前页
		page.setRowCount(rows);//设置总页数
		page.setRecords(list);//设置查询记录
		return page;
	}
	@Override
	@Transactional
	public Integer deleteObject(Integer... ids) {
		if(ids==null || ids.length==0) {
			throw new IllegalArgumentException("请选择删除的选项！");
		}
		Integer rows = sysConfigMapper.deleteObjects(ids);
		if(rows==0) {
			throw new ServiceException("该记录已经被删除！");
		}
		return rows;
	}
	@Override
	public SysConfig saveObject(SysConfig sysConfig) {
		if(sysConfig==null)
		throw new IllegalArgumentException("保存对象不能为空！");
		if(StringUtils.isEmpty(sysConfig.getName())) 
		throw new IllegalArgumentException("参数名不能为空！");
		if(StringUtils.isEmpty(sysConfig.getValue()))
		throw new IllegalArgumentException("参数值不能为空！");
		try {
			sysConfig.setCreatedTime(new Date());
			sysConfig.setModifiedTime(new Date());
			sysConfig.setCreatedUser("system");
			sysConfig.setModifiedUser("system");
			sysConfigMapper.insertObject(sysConfig);
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServiceException("系统故障，请联系管理员！");
		}
		System.out.println(sysConfig);
		return sysConfig;
	}
	@Override
	public Integer updateObject(SysConfig sysConfig) {
		if(sysConfig==null)
		throw new IllegalArgumentException("保存对象不能为空！");
		if(StringUtils.isEmpty(sysConfig.getName())) 
		throw new IllegalArgumentException("参数名不能为空！");
		if(StringUtils.isEmpty(sysConfig.getValue()))
		throw new IllegalArgumentException("参数值不能为空！");
		Integer rows = null;
		try {
			sysConfig.setModifiedTime(new Date());
			sysConfig.setModifiedUser("System");
			rows = sysConfigMapper.updateObject(sysConfig);
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServiceException("系统故障，请联系管理员！");
		}
		return rows;
	}

}
