package com.cg.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.healthcare.entities.DiagnosticTest;
@Service("dtestService")
public interface IDiagnosticTestService {

	public List<DiagnosticTest> getAllTest();
	DiagnosticTest addNewTest(DiagnosticTest test);
	List<DiagnosticTest> getTestsOfDiagnosticCenter(int centerId) throws Exception;
	DiagnosticTest updateTestDetail(DiagnosticTest test);
	DiagnosticTest removeTestFromDiagnosticCenter(int centerId, DiagnosticTest test) throws Exception;

}
