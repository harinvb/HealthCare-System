package com.cg.healthcare.service;


import java.util.List;

import com.cg.healthcare.entities.User;
import com.cg.healthcare.exception.UserCreationError;
import com.cg.healthcare.exception.UserNotFoundException;

public interface IUserService {

	User validateUser(String username, String password) throws Exception;
	public User addUser(User user) throws UserCreationError;
	public User removeUser(User user) throws UserNotFoundException;
	User updateUser(User user) throws UserNotFoundException ;
	List<User> getAll();
}
