package com.nishubin.work.bean.resp;

/**
 * 前端返回代码
 * @author Administrator
 *
 */
public class RespJson {
	private String msg;
	private String code;
	private Object data;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}	
