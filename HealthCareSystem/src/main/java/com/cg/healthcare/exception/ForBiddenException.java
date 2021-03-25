package com.cg.healthcare.exception;

public class ForBiddenException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8320602447892236495L;

	public ForBiddenException() {
		super("Invalid Login/Not Logged In");
	}

}
