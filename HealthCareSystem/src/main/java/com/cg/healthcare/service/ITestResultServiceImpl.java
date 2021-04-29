package com.cg.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthcare.dao.ITestResultRepository;
import com.cg.healthcare.dao.ManualQueries.QueryClassPersisitContext;
import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;
import com.cg.healthcare.exception.DataAlreadyExists;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.exception.TestResultNotFoundException;

@Service
public class ITestResultServiceImpl implements ITestResultService {
	
	@Autowired
	ITestResultRepository resultrepo;
	
	@Autowired
	QueryClassPersisitContext qcp;
	
	/** 
	 * @param tr
	 * @return TestResult
	 * @throws DataAlreadyExists
	 */
	@Override
	public TestResult addTestResult(TestResult tr)  throws DataAlreadyExists{
		
		if(resultrepo.existsById(tr.getTestResultid())) throw new DataAlreadyExists("Test Result Already exists with id :"+tr.getTestResultid());
		return resultrepo.saveAndFlush(tr);
	}

	
	/** 
	 * @param tr
	 * @return TestResult
	 * @throws DataNotFoundInDataBase
	 */
	@Override
	public TestResult updateResult(TestResult tr) throws DataNotFoundInDataBase {
		if(!resultrepo.existsById(tr.getTestResultid()))throw new DataNotFoundInDataBase("TestResult Not Found in DataBase to update");
		return resultrepo.saveAndFlush(tr);
	}

	
	/** 
	 * @param id
	 * @return TestResult
	 * @throws TestResultNotFoundException
	 */
	@Override
	public List<TestResult> removeTestResult(int id) throws TestResultNotFoundException {
		// TODO Auto-generated method stub
		if(!resultrepo.existsById(id)) throw new TestResultNotFoundException("Test Result Does Not Exist  "+ id);
		TestResult tr = resultrepo.findById(id).get();
		resultrepo.deleteById(id);
		return resultrepo.findAll();
		
	}



	
	/** 
	 * @param patient
	 * @return List<TestResult>
	 * @throws DataNotFoundInDataBase 
	 * @throws TestResultNotFoundException 
	 */
	@Override
	public List<TestResult> viewResultsByPatient(Patient patient) throws DataNotFoundInDataBase, TestResultNotFoundException {
		List<TestResult> testRes =  qcp.viewResultsByPatient(patient);
		if(testRes.size() ==0 )throw new DataNotFoundInDataBase("User/Tests Doesn't Exits");
		return testRes;
	}


	@Override
	public List<TestResult> getAll() {
		return resultrepo.findAll();
	}
	
	@Override
	public TestResult getById(int id) throws DataNotFoundInDataBase {
		// TODO Auto-generated method stub
		return resultrepo.findById(id).orElseThrow(()-> new DataNotFoundInDataBase("No Patient With ID "+id));
	}


	


	

}
