package com.cg.healthcare.exception;


/**
 * @category Exception
 */
public class UserCreationError extends Exception {
	
	
	private static final long serialVersionUID = -2928667618706847791L;

	public UserCreationError(String message) {
		super(message);
	}
}
