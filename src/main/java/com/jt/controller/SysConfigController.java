package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;

@Controller
@RequestMapping("/config")
public class SysConfigController {
	@Autowired
	private SysConfigService sysConfigService;
	@RequestMapping("/doConfigListUI.do")
	public String doConfigLisgtUI() {
		return "sys/config_list";
	}
	
	@RequestMapping("/doConfigEditUI.do")
	public String doConfigEditUI() {
		return "sys/config_edit";
	}
	
	@RequestMapping("/doFindPageObjects.do")
	@ResponseBody
	public JsonResult<PageObject<SysConfig>> doFindPageObjects(
			String name,Integer pageCurrent) {
			PageObject<SysConfig> recordList = sysConfigService.findPageObjects(name, pageCurrent);
			return new JsonResult<>(recordList);
	}
	
	@RequestMapping("/doDeleteObjects.do")
	@ResponseBody
	public JsonResult<Void> doDeleteObjects(
			@RequestParam("ids") Integer... ids) {
			sysConfigService.deleteObject(ids);
			return new JsonResult<Void>(JsonResult.OK,"删除成功");
	}
	
	@RequestMapping("/doSaveObject.do")
	@ResponseBody
	public JsonResult<Void> doSaveObject(SysConfig sysConfig){
		System.out.println("增加了");
		sysConfigService.saveObject(sysConfig);
		return new JsonResult<>(JsonResult.OK, "添加成功！");
	}
	
	@RequestMapping("/doUpdateObject.do")
	@ResponseBody
	public JsonResult<Void> doUpdateObject(SysConfig sysConfig){
		sysConfigService.updateObject(sysConfig);
		return new JsonResult<>(JsonResult.OK,"修改成功");
	}
}
