package com.cg.healthcare.Validators;

import org.springframework.stereotype.Component;

@Component
public class InputValidationImpl implements InputValidator {

	@Override
	public boolean nameValidator(String name) {
		
		return name.matches( "[A-Z][a-z]{3,}" );
	}

	@Override
	public boolean contactValidator(String contact) {
		return contact.matches("[0-9]{10}");
	}

	@Override
	public boolean emailValidator(String email) {
		return email.matches("^(.+)@(.+)$");
	}

}
