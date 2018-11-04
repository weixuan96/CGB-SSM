package com.jt.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
	@RequestMapping("/doIndexUI.do")
	public String doIndexUI() {
		return "starter";//start.html
	}
	@RequestMapping("/doPageUI.do")
	public String doPageUI() {
		return "common/page";
	}
}
