package com.cg.healthcare.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;

public interface IPatientRepository extends JpaRepository<Patient, Integer>{
//	Patient registerPatient(Patient patient) throws Exception;
//	Patient updatePatientDetails(Patient patient);
//	Patient viewPatient(String patientUserName);
//
//	List<TestResult> getAllTestResult(String patientUserName) throws Exception;
//	TestResult viewTestResult(int testResultId) throws Exception;
	
}
