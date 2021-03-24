package com.cg.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthcare.dao.IAdminRepository;
import com.cg.healthcare.entities.User;
@Service
public class IAdminServiceImpl implements IAdminService {
	
	@Autowired
	IAdminRepository adminRepo;

	@Override
	public void registerAdmin(String username, String password) throws Exception {
		User u  = new User(username,password,"ADMIN");
		adminRepo.saveAndFlush(u);
	}

}
