package com.cg.healthcare.dao;


import com.cg.healthcare.entities.User;

public interface UserRepository {
	User validateUser(String username, String password) throws Exception;
	public User addUser(User user);
	public User removeUser(User user);
}
