package com.jt.sys.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
/**
 * 全局异常处理类
 */
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult<Void> doHandleRunTimeException(RuntimeException e){
		return new JsonResult<>(e);
	}
}
