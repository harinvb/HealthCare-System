package com.cg.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthcare.dao.IPatientRepository;
import com.cg.healthcare.dao.ITestResultRepository;
import com.cg.healthcare.dao.ImplementationClasses.QueryClassPersisitContext;
import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;
import com.cg.healthcare.exception.DataAlreadyExists;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
@Service
public class IPatientServiceImpl implements IPatientService {
	
	@Autowired
	IPatientRepository patRepo;
	
	@Autowired
	QueryClassPersisitContext qcp;
	
	@Autowired
	ITestResultRepository testRepo;
	

	@Override
	public Patient registerPatient(Patient patient) throws DataAlreadyExists {
		if(patRepo.existsById(patient.getPatientId()))throw new DataAlreadyExists("Patient Already exists with id "+ patient.getPatientId()+" use update to change");
		return patRepo.saveAndFlush(patient);
	}

	@Override
	public Patient updatePatientDetails(Patient patient) throws DataNotFoundInDataBase {
		if(!patRepo.existsById(patient.getPatientId()))throw new DataNotFoundInDataBase("Patient Details Not Found in DataBase");
		return patRepo.saveAndFlush(patient);
	}

	@Override
	public Patient viewPatient(String patientUserName) throws DataNotFoundInDataBase {
		Patient present = patRepo.findByname(patientUserName);
		if(present == null) throw new DataNotFoundInDataBase("No patient with "+patientUserName+" Exists");
		return present;
	}

	@Override
	public List<TestResult> getAllTestResult(String patientUserName) throws DataNotFoundInDataBase {
		List<TestResult> res = qcp.getAllTestResult(patientUserName);
		if(res == null) throw new DataNotFoundInDataBase("Patient UserName Might Not Exist");
		return res;
	}

	@Override
	public TestResult viewTestResult(int testResultId) throws DataNotFoundInDataBase {
		if(!testRepo.existsById(testResultId))throw new DataNotFoundInDataBase("TestResult Does not Exist!!");
		return testRepo.getOne(testResultId);
	}

}
