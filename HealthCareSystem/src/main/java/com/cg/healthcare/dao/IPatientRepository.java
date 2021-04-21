package com.cg.healthcare.dao;

import java.util.List;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.cg.healthcare.entities.DiagnosticCenter;
//import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.User;
//import com.cg.healthcare.entities.TestResult;

public interface IPatientRepository extends JpaRepository<Patient, Integer>{

	List<Patient> findAllByname(String name);
	
	Patient findByuser(User user);
}
