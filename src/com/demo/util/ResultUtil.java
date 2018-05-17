package com.demo.util;

/**
 * Controller层用于返回的封装类
 * @author sheng
 *
 */
public class ResultUtil {
	public String status;
	public String msg;
	public Object data;
	
	public ResultUtil() {
		super();
	}
	public ResultUtil(String status, String msg){
		this(status, msg, null);
	}
	public ResultUtil(String status, String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResultUtil [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
	
}
