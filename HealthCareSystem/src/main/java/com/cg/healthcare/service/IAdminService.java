package com.cg.healthcare.service;

import org.springframework.stereotype.Service;

//import java.util.List;
//import java.util.Set;
//
//import com.cg.healthcare.entities.Appointment;
//import com.cg.healthcare.entities.DiagnosticCenter;
//import com.cg.healthcare.entities.DiagnosticTest;
//import com.cg.healthcare.entities.Patient;
//import com.cg.healthcare.entities.User;


@Service
public interface IAdminService {
	
	public	void registerAdmin(String username, String password) throws Exception;
}