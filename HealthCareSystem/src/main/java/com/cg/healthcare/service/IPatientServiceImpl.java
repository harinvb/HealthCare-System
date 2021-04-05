package com.cg.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthcare.dao.IPatientRepository;
import com.cg.healthcare.dao.ITestResultRepository;
import com.cg.healthcare.dao.ManualQueries.QueryClassPersisitContext;
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
	

	
	/** 
	 * @param patient
	 * @return Patient
	 * @throws DataAlreadyExists
	 */
	@Override
	public Patient registerPatient(Patient patient) throws DataAlreadyExists {
		if(patRepo.existsById(patient.getPatientId()))throw new DataAlreadyExists("Patient Already exists with id "+ patient.getPatientId()+" use update to change");
		return patRepo.saveAndFlush(patient);
	}

	
	/** 
	 * @param patient
	 * @return Patient
	 * @throws DataNotFoundInDataBase
	 */
	@Override
	public Patient updatePatientDetails(Patient patient) throws DataNotFoundInDataBase {
		if(!patRepo.existsById(patient.getPatientId()))throw new DataNotFoundInDataBase("Patient Details Not Found in DataBase");
		return patRepo.saveAndFlush(patient);
	}

	
	/** 
	 * @param patientUserName
	 * @return List<Patient>
	 * @throws DataNotFoundInDataBase
	 */
	@Override
	public List<Patient> viewPatient(String patientUserName) throws DataNotFoundInDataBase {
		List<Patient> present = patRepo.findAllByname(patientUserName);
		if(present == null) throw new DataNotFoundInDataBase("No patient with "+patientUserName+" Exists");
		return present;
	}

	
	/** 
	 * @param patientUserName
	 * @return List<TestResult>
	 * @throws DataNotFoundInDataBase
	 */
	@Override
	public List<TestResult> getAllTestResult(String patientUserName) throws DataNotFoundInDataBase {
		List<TestResult> res = qcp.getAllTestResult(patientUserName);
		if(res == null) throw new DataNotFoundInDataBase("Patient UserName Might Not Exist");
		return res;
	}

	
	/** 
	 * @param testResultId
	 * @return TestResult
	 * @throws DataNotFoundInDataBase
	 */
	@Override
	public TestResult viewTestResult(int testResultId) throws DataNotFoundInDataBase {
		if(!testRepo.existsById(testResultId))throw new DataNotFoundInDataBase("TestResult Does not Exist!!");
		return testRepo.getOne(testResultId);
	}


	@Override
	public Patient deletePatient(Patient patient) throws DataNotFoundInDataBase {
		if(!patRepo.existsById(patient.getPatientId()))throw new DataNotFoundInDataBase("Patient Details Not Found in DataBase");
		Patient pat = patRepo.findById(patient.getPatientId()).get();
		patRepo.deleteById(patient.getPatientId());
		return pat;
	}

}
