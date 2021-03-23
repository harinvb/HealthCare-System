package com.cg.healthcare.service;

import org.springframework.stereotype.Service;

import com.cg.healthcare.entities.User;
@Service
public interface IUserService {

	User validateUser(String username, String password) throws Exception;
	public User addUser(User user);
	public User removeUser(User user);
}
