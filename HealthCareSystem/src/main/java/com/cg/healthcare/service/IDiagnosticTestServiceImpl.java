package com.cg.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthcare.dao.IDiagnosticTestRepository;
import com.cg.healthcare.dao.ManualQueries.QueryClassPersisitContext;
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.exception.DataAlreadyExists;
import com.cg.healthcare.exception.DataNotFoundInDataBase;

@Service
public class IDiagnosticTestServiceImpl implements IDiagnosticTestService {

	@Autowired
	IDiagnosticTestRepository testRepo;
	@Autowired
	QueryClassPersisitContext qcp;
	
	/** 
	 * @return List<DiagnosticTest>
	 */
	@Override
	public List<DiagnosticTest> getAllTest() {
		return testRepo.findAll();
	}

	
	/** 
	 * @param test
	 * @return DiagnosticTest
	 * @throws DataAlreadyExists
	 */
	@Override
	public DiagnosticTest addNewTest(DiagnosticTest test) throws DataAlreadyExists {
		if(testRepo.existsById(test.getDiagonasticTestid())) throw new DataAlreadyExists("Test Already Exists Use Update To Change");
		return testRepo.saveAndFlush(test);
	}

	
	/** 
	 * @param centerId
	 * @return List<DiagnosticTest>
	 * @throws DataNotFoundInDataBase
	 */
	@Override
	public List<DiagnosticTest> getTestsOfDiagnosticCenter(int centerId) throws DataNotFoundInDataBase {
		List<DiagnosticTest> tests = qcp.getTestsOfDiagnosticCenter(centerId);
		if(tests.size()==0)throw new DataNotFoundInDataBase("No Diagnostic Tests Exist");
		return tests;
	}
	@Override
	public DiagnosticTest getTestById(int diagnosticTestid) throws DataNotFoundInDataBase {
		//DiagnosticTest test = qcp.getTestById(diagnosticTestid);
		return testRepo.findById(diagnosticTestid).get();	
	}

	
	/** 
	 * @param test
	 * @return DiagnosticTest
	 * @throws DataNotFoundInDataBase
	 */
	@Override
	public DiagnosticTest updateTestDetail(DiagnosticTest test) throws DataNotFoundInDataBase{
		
		if(!testRepo.existsById(test.getDiagonasticTestid())) throw new DataNotFoundInDataBase("No test Exist with id : "+test.getDiagonasticTestid()+" To Update");
		
		return testRepo.saveAndFlush(test);
	}

	
	/** 
	 * @param centerId
	 * @param test
	 * @return DiagnosticTest
	 * @throws Exception
	 */
	@Override
	public DiagnosticTest removeTestFromDiagnosticCenter(int centerId, int test) throws Exception {
		return qcp.removeTestFromDiagnosticCenter(centerId, test);
	}


	

}
