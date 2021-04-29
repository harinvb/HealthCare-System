package com.cg.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthcare.dao.IPatientRepository;
import com.cg.healthcare.dao.ITestResultRepository;
import com.cg.healthcare.dao.UserRepository;
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
	
	@Autowired
	UserRepository userRepo;
	

	
	/** 
	 * @param patient
	 * @return Patient
	 * @throws DataAlreadyExists
	 * @throws DataNotFoundInDataBase 
	 */
	@Override
	public Patient registerPatient(Patient patient , int userID) throws DataAlreadyExists, DataNotFoundInDataBase {
		if(patRepo.existsById(patient.getPatientId()))throw new DataAlreadyExists("Patient Already exists with id "+ patient.getPatientId()+" use update to change");
		patient.setUser(userRepo.findById(userID).orElseThrow(()->new DataNotFoundInDataBase("No Such User Exists with Id :"+userID)));
		return patRepo.saveAndFlush(patient);
	}

	
	/** 
	 * @param patient
	 * @return Patient
	 * @throws DataNotFoundInDataBase
	 */
	@Override
	public Patient updatePatientDetails(Patient patient) throws DataNotFoundInDataBase {
		Patient p = patRepo.findById(patient.getPatientId()).orElseThrow(()->new DataNotFoundInDataBase("Patient Details Not Found in DataBase"));
		patient.setUser(p.getUser());
		return patRepo.saveAndFlush(patient);
	}

	
	/** 
	 * @param patientUserName
	 * @return List<Patient>
	 * @throws DataNotFoundInDataBase
	 */
	@Override
	public Patient viewPatient(String userid) throws DataNotFoundInDataBase {
		return patRepo.findByuser(
				userRepo.findById(Integer.parseInt(userid))
				.orElseThrow(()->new DataNotFoundInDataBase("No Such User Exists with Id :"+userid)));
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
		return testRepo.findById(testResultId).get();
	}


	@Override
	public Patient deletePatient(Patient patient) throws DataNotFoundInDataBase {
		if(!patRepo.existsById(patient.getPatientId()))throw new DataNotFoundInDataBase("Patient Details Not Found in DataBase");
		Patient pat = patRepo.findById(patient.getPatientId()).get();
		patRepo.deleteById(patient.getPatientId());
		return pat;
	}


	@Override
	public List<Patient> getAll() {
		// TODO Auto-generated method stub
		return patRepo.findAll();
	}

}
