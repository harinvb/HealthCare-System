package com.cg.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthcare.validators.InputValidator;
import com.cg.healthcare.dao.IAdminRepository;
import com.cg.healthcare.entities.User;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.exception.UserCreationError;
@Service
public class IAdminServiceImpl implements IAdminService {
	
	@Autowired
	IAdminRepository adminRepo;
	
	@Autowired
	InputValidator validate;

	
	/** 
	 * @param username
	 * @param password
	 * @throws UserCreationError
	 */
	@Override
	public void registerAdmin(String username, String password) throws UserCreationError {
		if(!validate.usernameValidator(username))throw new UserCreationError("Check Username !!!!");
		if(!validate.passwordValidator(password))throw new UserCreationError("Cannot register this admin with this password");
		if(adminRepo.existsByusername(username)) throw new UserCreationError("username Already exists");
		User u  = new User(username,password,"ADMIN");
		adminRepo.saveAndFlush(u);
	}


	@Override
	public User updateAdmin(User user) throws UserCreationError, DataNotFoundInDataBase {
		if(!validate.usernameValidator(user.getUsername()))throw new UserCreationError("Check Username !!!!");
		if(!validate.passwordValidator(user.getPassword()))throw new UserCreationError("Cannot register this admin with this password");
		if(!adminRepo.existsById(user.getUserid())) throw new DataNotFoundInDataBase("No Such User Exists with id : "+user.getUserid());
		adminRepo.saveAndFlush(user);
		return adminRepo.findById(user.getUserid()).get();
	}


	@Override
	public User deleteAdmin(int id) throws DataNotFoundInDataBase{
		if(!adminRepo.existsById(id)) throw new DataNotFoundInDataBase("No Such User Exists with id : "+id);
		User user1 = adminRepo.findById(id).get();
		adminRepo.delete(user1);
		return user1;
	}
	
	
	

}
