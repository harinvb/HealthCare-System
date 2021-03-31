package com.cg.healthcare.validators;

import org.springframework.stereotype.Component;

@Component
public class InputValidationImpl implements InputValidator {

	
	/** 
	 * @param name
	 * @return boolean
	 */
	@Override
	public boolean nameValidator(String name) {
		
		return name.matches( "[A-Z][a-z]{3,}" );
	}

	
	/** 
	 * @param contact
	 * @return boolean
	 */
	@Override
	public boolean contactValidator(String contact) {
		return contact.matches("[0-9]{10}");
	}

	
	/** 
	 * @param email
	 * @return boolean
	 */
	@Override
	public boolean emailValidator(String email) {
		return email.matches("^(.+)@(.+)$");
	}

	
	/** 
	 * @param password
	 * @return boolean
	 */
	@Override
	public boolean passwordValidator(String password) {
		return password.length()>=3;
	}

	
	/** 
	 * @param username
	 * @return boolean
	 */
	public boolean usernameValidator(String username) {
		return username.length()>=3;
	}

}
