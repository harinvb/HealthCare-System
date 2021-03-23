package com.cg.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Service;

//import com.cg.healthcare.entities.DiagnosticCenter;
//import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;
@Service
public interface IPatientService {

	Patient registerPatient(Patient patient) throws Exception;
	Patient updatePatientDetails(Patient patient);
	Patient viewPatient(String patientUserName);

	List<TestResult> getAllTestResult(String patientUserName) throws Exception;
	TestResult viewTestResult(int testResultId) throws Exception;
	//add functionalities if required
	
}