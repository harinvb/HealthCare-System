package com.cg.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD

=======
>>>>>>> 20f829a36187753f52095c4c6a3a44ff424bd856
import com.cg.healthcare.dao.IPatientRepository;
import com.cg.healthcare.dao.ITestResultRepository;
import com.cg.healthcare.dao.ImplementationClasses.QueryClassPersisitContext;
import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;

public class IPatientServiceImpl implements IPatientService {
	
	@Autowired
	IPatientRepository patRepo;
	
	@Autowired
	QueryClassPersisitContext qcp;
	
	@Autowired
	ITestResultRepository testRepo;
	

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
		return qcp.getAllTestResult(patientUserName);
	}

	@Override
	public TestResult viewTestResult(int testResultId) throws Exception {
		
		return testRepo.getOne(testResultId);
	}

}
