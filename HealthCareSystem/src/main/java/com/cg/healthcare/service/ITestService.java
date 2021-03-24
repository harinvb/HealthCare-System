package com.cg.healthcare.service;

import java.util.List;


import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.exception.DataNotFoundInDataBase;

public interface ITestService {

	public DiagnosticTest addTest(DiagnosticTest test);
	public DiagnosticTest updateTest(DiagnosticTest test) throws DataNotFoundInDataBase;
	public DiagnosticTest removeTest(DiagnosticTest test);
	public List<DiagnosticTest> viewAllTest();
	public DiagnosticTest addTestInCenter(DiagnosticTest test, DiagnosticCenter center);
	
}
