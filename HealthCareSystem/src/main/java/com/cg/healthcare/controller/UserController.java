package com.cg.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

@CrossOrigin("http://localhost:4200")
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
	public User validateUser(@RequestBody User user) throws Exception {
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
		return userService.removeUser(user);
	}

	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) throws ForBiddenException, UserNotFoundException {
		return userService.updateUser(user);

	}
	
	@GetMapping("/getAll")
	public List<User> getAll(){
		return userService.getAll();
	}
}
