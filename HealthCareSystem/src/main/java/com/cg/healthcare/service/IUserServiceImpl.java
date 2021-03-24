package com.cg.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.healthcare.dao.UserRepository;
import com.cg.healthcare.entities.User;
import com.cg.healthcare.exception.UserNotFoundException;

public class IUserServiceImpl implements IUserService {
	
	@Autowired
	UserRepository userrepo;

	@Override
	public User validateUser(String username, String password) throws Exception {
		User pUser = userrepo.findByusername(username);
		if(pUser.getPassword().equals(password)) return pUser;
		else {
			throw new UserNotFoundException();
		}
	}

	@Override
	public User addUser(User user) {
		return userrepo.saveAndFlush(user);
	}

	@Override
	public User removeUser(User user) {
		userrepo.delete(user);
		return user;
	}

}
