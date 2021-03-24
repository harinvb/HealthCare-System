package com.cg.healthcare.service;


import com.cg.healthcare.entities.User;
import com.cg.healthcare.exception.UserCreationError;

public interface IUserService {

	User validateUser(String username, String password) throws Exception;
	public User addUser(User user) throws UserCreationError;
	public User removeUser(User user);
}
