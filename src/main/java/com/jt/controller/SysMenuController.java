package com.jt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class SysMenuController {
	@RequestMapping("/doMenuListUI.do")
	public String doMenuListUI() {
		return "sys/menu_list";
	}
}
