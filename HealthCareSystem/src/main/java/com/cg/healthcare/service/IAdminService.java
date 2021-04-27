package com.cg.healthcare.service;

import org.springframework.stereotype.Service;

import com.cg.healthcare.entities.User;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.exception.UserCreationError;



@Service
public interface IAdminService {
	
	public void registerAdmin(String username, String password) throws UserCreationError;
	public User updateAdmin(User user) throws UserCreationError, DataNotFoundInDataBase;
	public User deleteAdmin(int id) throws DataNotFoundInDataBase;
}