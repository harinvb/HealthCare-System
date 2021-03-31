package com.cg.healthcare.exception;
/**
 * @category Exception
 */
public class PatientNotFoundException extends Exception{
	
	
	private static final long serialVersionUID = -2277914054417247326L;

	public PatientNotFoundException(String msg) {
		super(msg);
	}

}
