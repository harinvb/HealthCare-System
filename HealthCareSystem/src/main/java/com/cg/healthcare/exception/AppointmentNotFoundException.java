package com.cg.healthcare.exception;
/**
 * @category Exception
 */
public class AppointmentNotFoundException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	public AppointmentNotFoundException(String msg) {
		super(msg);
	}

}
