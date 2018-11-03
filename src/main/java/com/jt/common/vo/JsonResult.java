package com.jt.common.vo;

import java.io.Serializable;

public class JsonResult<T> implements Serializable{
	private static final long serialVersionUID = 2632762671144106565L;
	public static final int OK = 0;
	public static final int ERR = 1;
	//状态码
	private Integer state;
	//状态码对性的消息
	private String message;
	//返回的数据
	private T data;
	public JsonResult(String message) {
		this.state = OK;
		this.message = message;
	}
	public JsonResult(Integer state, String message) {
		super();
		this.state = state;
		this.message = message;
	}

	public JsonResult(T data) {
		this.state = OK;
		this.data = data;
	}
	public JsonResult(Throwable e){
		this.state = ERR;
		this.message = e.getMessage();
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
