package com.cg.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthcare.entities.User;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.exception.ForBiddenException;
import com.cg.healthcare.exception.UserCreationError;
import com.cg.healthcare.service.IAdminService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	IAdminService adminService;
	/** 
	 * @param user
	 * @return HttpStatus
	 * @throws UserCreationError
	 * @throws ForBiddenException
	 */
	@PostMapping("/registeradmin")
	public	HttpStatus registerAdmin(@RequestBody User user) throws UserCreationError , ForBiddenException{
		adminService.registerAdmin(user.getUsername(), user.getPassword());
		return HttpStatus.CREATED;
	}
	
	@PutMapping("/updateAdmin")
	public User updateAdmin(@RequestBody User user) throws UserCreationError, DataNotFoundInDataBase, ForBiddenException{
		return adminService.updateAdmin(user);
	}
	
	@DeleteMapping("/deleteAdmin")
	public User deleteAdmin(@RequestBody User user) throws DataNotFoundInDataBase, ForBiddenException{
		return adminService.deleteAdmin(user);
	}
	
}
