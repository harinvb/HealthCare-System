package com.cg.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthcare.entities.User;
import com.cg.healthcare.exception.ForBiddenException;
import com.cg.healthcare.exception.UserCreationError;
import com.cg.healthcare.exception.UserNotFoundException;
import com.cg.healthcare.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserService userService;

	@Autowired
	LoginController logCon;

	/**
	 * @param username
	 * @param password
	 * @return HttpStatus
	 * @throws Exception
	 */
	@PostMapping("/validateUser")
	public HttpStatus validateUser(@RequestBody User user) throws Exception {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		if (!logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException("Not An Admin");
		return userService.validateUser(user.getUsername(), user.getPassword());
	}

	/**
	 * @param user
	 * @return User
	 * @throws UserCreationError
	 * @throws ForBiddenException
	 */
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user) throws UserCreationError, ForBiddenException {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		if (!logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException("Not An Admin");
		return userService.addUser(user);
	}

	/**
	 * @param user
	 * @return User
	 * @throws ForBiddenException
	 * @throws UserNotFoundException
	 */
	@DeleteMapping("/removeuser")
	public User removeUser(@RequestBody User user) throws ForBiddenException, UserNotFoundException {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		if (!logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException("Not An Admin");
		return userService.removeUser(user);
	}

	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) throws ForBiddenException, UserNotFoundException {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		if (!logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException("Not An Admin");
		return userService.updateUser(user);

	}
}
