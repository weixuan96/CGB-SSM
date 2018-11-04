package com.jt.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;
import com.jt.common.vo.Node;
import com.jt.sys.entity.SysMenu;
import com.jt.sys.service.SysMenuService;

@Controller
@RequestMapping("/menu")
public class SysMenuController {
	@Autowired
	private SysMenuService sysMenuService;
	@RequestMapping("/doMenuListUI.do")
	public String doMenuListUI() {
		return "sys/menu_list";
	}
	
	@RequestMapping("/doFindObjects.do")
	@ResponseBody
	public JsonResult<List<Map<String,Object>>> doFindObjects() {
		return new JsonResult<>(sysMenuService.findObjects());
	}
	
	@RequestMapping("/doDeleteObject.do")
	@ResponseBody
	public JsonResult<Void> doDeleteObject(Integer id){
		sysMenuService.deleteObject(id);
		return new JsonResult<>(JsonResult.OK, "删除成功！");
	}
	@RequestMapping("/doMenuEditUI.do")
	public String doMenuEditUI() {
		return "sys/menu_edit";
	}
	
	@RequestMapping("/doFindZtreeMenuNodes.do")
	@ResponseBody
	public JsonResult<List<Node>> findZtreeMenuNodes(){
		return new JsonResult<>(sysMenuService.findZtreeMenuNodes());
	}
	
	@RequestMapping("/doSaveObject.do")
	@ResponseBody
	public JsonResult<Void> doSaveObject(SysMenu sysMenu){
		sysMenuService.saveObject(sysMenu);
		return new JsonResult<>(JsonResult.OK,"添加成功！");
	}
	
	@RequestMapping("/doUpdateObject.do")
	@ResponseBody
	public JsonResult<Void> doUpdateObject(SysMenu sysMenu){
		sysMenuService.updateObject(sysMenu);
		return new JsonResult<>(JsonResult.OK,"修改成功！");
	}
	
	@RequestMapping("/doSelectObjectById.do")
	@ResponseBody
	public JsonResult<SysMenu> doSelectObjectById(Integer id){
		SysMenu sysMenu = sysMenuService.selectObjectById(id);
		return new JsonResult<>(sysMenu);
	}
}
