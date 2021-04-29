package com.cg.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthcare.dao.IDiagnosticCenterRepositoryInt;
import com.cg.healthcare.dao.TestRepository;
import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.exception.ConflictException;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
@Service
public class ITestServiceImpl implements ITestService {

	@Autowired
	TestRepository testrepo;
	
	@Autowired
	IDiagnosticCenterRepositoryInt centerRepo;
	
	
	/** 
	 * @param test
	 * @return DiagnosticTest
	 * @throws DataNotFoundInDataBase 
	 */
	@Override
	public DiagnosticTest addTest(DiagnosticTest test) throws DataNotFoundInDataBase {
		if(!testrepo.existsById(test.getDiagonasticTestid())) throw new DataNotFoundInDataBase("Test Already Exists");
		return testrepo.saveAndFlush(test);
	}

	
	/** 
	 * @param test
	 * @return DiagnosticTest
	 * @throws DataNotFoundInDataBase
	 */
	@Override
	public DiagnosticTest updateTest(DiagnosticTest test) throws DataNotFoundInDataBase {
		if(!testrepo.existsById(test.getDiagonasticTestid())) throw new DataNotFoundInDataBase("Test Does Not Exist");
		return testrepo.saveAndFlush(test);
	}

	
	/** 
	 * @param test
	 * @return DiagnosticTest
	 * @throws ConflictException 
	 * @throws DataNotFoundInDataBase 
	 * @throws Exception 
	 */
	@Override
	public DiagnosticTest removeTest(int diagnosticTestid) throws ConflictException, DataNotFoundInDataBase {
		if(!testrepo.existsById(diagnosticTestid)) throw new DataNotFoundInDataBase("Test Does Not Exist");
		DiagnosticTest tes = testrepo.findById(diagnosticTestid).get();
		try {
		testrepo.delete(tes);
		}
		catch(Exception e ) {
			throw new ConflictException("This Test Is linked With Previous Other Entity So it is Preferebale Not to delete");
		}
		return tes;
	}

	
	/** 
	 * @return List<DiagnosticTest>
	 */
	@Override
	public List<DiagnosticTest> viewAllTest() {
		return testrepo.findAll();
	}
	
	
	/** 
	 * @param test
	 * @param center
	 * @return DiagnosticTest
	 */
	@Override
	public DiagnosticTest addTestInCenter(int testId, int centerId) throws DataNotFoundInDataBase{
		DiagnosticTest test = testrepo.findById(testId)
				.orElseThrow(()-> new DataNotFoundInDataBase(testId+" test Not Found"));
		DiagnosticCenter center = centerRepo.findById(centerId)
				.orElseThrow(()-> new DataNotFoundInDataBase(centerId+" center Not Found"));
		test.setDiagnosticCenter(center);
		center.getTests().add(test);
		testrepo.save(test);
		return test;
	}

}
