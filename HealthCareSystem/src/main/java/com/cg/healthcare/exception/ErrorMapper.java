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
	
	/** 
	 * @return String
	 */
	public String getUrl() {
		return url;
	}
	
	/** 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/** 
	 * @return String
	 */
	public String getMessage() {
		return message;
	}
	
	/** 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/** 
	 * @return Date
	 */
	public Date getraisedTime() {
		return raisedTime;
	}
	
	/** 
	 * @param raisedTime
	 */
	public void setNow(Date raisedTime) {
		this.raisedTime = raisedTime;
	}
	
	/** 
	 * @return String
	 */
	public String getExceptionName() {
		return ExceptionName;
	}
	
	/** 
	 * @param exceptionName
	 */
	public void setExceptionName(String exceptionName) {
		ExceptionName = exceptionName;
	}
	
	
	

}

