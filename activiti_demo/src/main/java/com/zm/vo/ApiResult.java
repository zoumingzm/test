package com.zm.vo;

public class ApiResult {
	
	private int code;
	
	private String message;
	
	private Object data;

	
	public ApiResult(){}
	
	public ApiResult(Object data){
		this.data = data;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static ApiResult success(Object data){
		return new ApiResult(data);
	}
}
