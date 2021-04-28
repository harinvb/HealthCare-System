package com.cg.healthcare.service;

import java.util.List;


import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.exception.DataAlreadyExists;
import com.cg.healthcare.exception.DataNotFoundInDataBase;

public interface IDiagnosticTestService {

	public List<DiagnosticTest> getAllTest();
	DiagnosticTest addNewTest(DiagnosticTest test) throws DataAlreadyExists;
	List<DiagnosticTest> getTestsOfDiagnosticCenter(int centerId) throws Exception;
	DiagnosticTest updateTestDetail(DiagnosticTest test) throws DataNotFoundInDataBase;
	DiagnosticTest removeTestFromDiagnosticCenter(int centerId, int test) throws Exception;
	DiagnosticTest getTestById(int diagnosticTestid) throws DataNotFoundInDataBase;

}
