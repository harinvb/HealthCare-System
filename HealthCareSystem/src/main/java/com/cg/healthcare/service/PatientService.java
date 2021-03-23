package com.cg.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.healthcare.dao.IPatientRepository;
import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;

public class PatientService implements IPatientService {
	
	@Autowired
	IPatientRepository patRepo;
	

	@Override
	public Patient registerPatient(Patient patient) throws Exception {
		return patRepo.saveAndFlush(patient);
	}

	@Override
	public Patient updatePatientDetails(Patient patient) {
		return patRepo.saveAndFlush(patient);
	}

	@Override
	public Patient viewPatient(String patientUserName) {
		
		return patRepo.findByname(patientUserName);
	}

	@Override
	public List<TestResult> getAllTestResult(String patientUserName) throws Exception {
		
		return null;
	}

	@Override
	public TestResult viewTestResult(int testResultId) throws Exception {
		
		return null;
	}

}
