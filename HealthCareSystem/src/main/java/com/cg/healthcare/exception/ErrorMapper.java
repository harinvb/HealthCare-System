package com.cg.healthcare.exception;


import java.util.Date;


public class ErrorMapper {
	private String url;
	private String message;
	private Date raisedTime;
	private String ExceptionName;
	
	public ErrorMapper(String url, String message, Date raisedTime,String en) {
		super();
		this.url = url;
		this.message = message;
		this.raisedTime=raisedTime;
		this.ExceptionName = en;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getraisedTime() {
		return raisedTime;
	}
	public void setNow(Date raisedTime) {
		this.raisedTime = raisedTime;
	}
	public String getExceptionName() {
		return ExceptionName;
	}
	public void setExceptionName(String exceptionName) {
		ExceptionName = exceptionName;
	}
	
	
	

}

