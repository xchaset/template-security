package com.xchaset.dto;

/**
 * 返回对象
 * @author xiaozhaoming
 *
 * @param <T>
 */
public class BaseResponse<T> {

	
	private T data;
	
	private String retCode;
	
	private String retMsg;


	

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	
	
}
