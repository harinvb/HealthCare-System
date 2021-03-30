package com.cg.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthcare.validators.InputValidator;
import com.cg.healthcare.dao.IAdminRepository;
import com.cg.healthcare.entities.User;
import com.cg.healthcare.exception.UserCreationError;
@Service
public class IAdminServiceImpl implements IAdminService {
	
	@Autowired
	IAdminRepository adminRepo;
	
	@Autowired
	InputValidator validate;

	@Override
	public void registerAdmin(String username, String password) throws UserCreationError {
		if(!validate.usernameValidator(username))throw new UserCreationError("Check Username !!!!");
		if(!validate.passwordValidator(password))throw new UserCreationError("Cannot register this admin with this password");
		User u  = new User(username,password,"ADMIN");
		adminRepo.saveAndFlush(u);
	}

}
