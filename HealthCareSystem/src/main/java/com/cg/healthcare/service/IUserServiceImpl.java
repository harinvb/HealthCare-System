package com.cg.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cg.healthcare.dao.UserRepository;
import com.cg.healthcare.dao.ImplementationClasses.QueryClassPersisitContext;
import com.cg.healthcare.entities.User;
import com.cg.healthcare.exception.UserCreationError;
import com.cg.healthcare.exception.UserNotFoundException;
import com.cg.healthcare.validators.InputValidator;

@Service
public class IUserServiceImpl implements IUserService {
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	InputValidator validate;
	
	@Autowired
	QueryClassPersisitContext qcp;

	@Override
	public HttpStatus validateUser(String username, String password) throws UserNotFoundException {
		User pUser = qcp.findByUserName(username);
		if(pUser.getPassword().equals(password)) return HttpStatus.ACCEPTED;
		else {
			throw new UserNotFoundException("Invalid Password");
		}
	}

	@Override
	public User addUser(User user) throws UserCreationError {
		if(!validate.usernameValidator(user.getUsername()))throw new UserCreationError("Check Username !!!!");
		if(!validate.passwordValidator(user.getPassword()))throw new UserCreationError("Cannot register this User with this password");
		return userrepo.saveAndFlush(user);
	}

	@Override
	public User removeUser(User user) {
		userrepo.delete(user);
		return user;
	}

}
