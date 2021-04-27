package com.cg.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthcare.dao.UserRepository;
import com.cg.healthcare.dao.ManualQueries.QueryClassPersisitContext;
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

	
	/** 
	 * @param username
	 * @param password
	 * @return HttpStatus
	 * @throws UserNotFoundException
	 */
	@Override
	public User validateUser(String username, String password) throws UserNotFoundException {
		User pUser = qcp.findByUserName(username);
		if(pUser == null )throw new UserNotFoundException("Invalid Username");
		if(pUser.getPassword().equals(password)) return pUser;
		else {
			throw new UserNotFoundException("Invalid Password");
		}
	}

	
	/** 
	 * @param user
	 * @return User
	 * @throws UserCreationError
	 */
	@Override
	public User addUser(User user) throws UserCreationError {
		if(!validate.usernameValidator(user.getUsername()))throw new UserCreationError("Check Username !!!!");
		if(userrepo.existsByusername(user.getUsername())) throw new UserCreationError("username Already exists");
		if(!validate.passwordValidator(user.getPassword()))throw new UserCreationError("Cannot register this User with this password");
		user.setRole("user");
		return userrepo.saveAndFlush(user);
	}

	
	/** 
	 * @param user
	 * @return User
	 * @throws UserNotFoundException 
	 */
	@Override
	public User removeUser(User user) throws UserNotFoundException {
		if(!userrepo.existsById(user.getUserid()))throw new UserNotFoundException("User with id :" + user.getUserid()+" Doesn't Exist");
		userrepo.deleteById(user.getUserid());
		return user;
	}


	@Override
	public User updateUser(User user) throws UserNotFoundException {
		if(!userrepo.existsById(user.getUserid()))throw new UserNotFoundException("User with id :" + user.getUserid()+" Doesn't Exist");
		User use = userrepo.findById(user.getUserid()).get();
		userrepo.delete(use);
		return use;
	}


	@Override
	public List<User> getAll() {
		return userrepo.findAll();
	}

}
