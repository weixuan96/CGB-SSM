package com.jt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;
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
}
