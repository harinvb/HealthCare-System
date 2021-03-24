package com.cg.healthcare.service;


import com.cg.healthcare.entities.User;

public interface IUserService {

	User validateUser(String username, String password) throws Exception;
	public User addUser(User user);
	public User removeUser(User user);
}
