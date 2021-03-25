package com.cg.healthcare.Validators;

public interface InputValidator {
	
	public boolean nameValidator(String name);
	
	public boolean contactValidator(String contact);
	
	public boolean emailValidator(String email);
	
	public boolean passwordValidator(String password);
	
	public boolean usernameValidator(String username);

}
