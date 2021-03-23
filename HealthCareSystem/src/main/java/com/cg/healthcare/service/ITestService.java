package com.cg.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
@Service
public interface ITestService {

	public DiagnosticTest addTest(DiagnosticTest test);
	public DiagnosticTest updateTest(DiagnosticTest test);
	public DiagnosticTest removeTest(DiagnosticTest test);
	public List<DiagnosticTest> viewAllTest(DiagnosticTest test);
	public DiagnosticTest addTestInCenter(DiagnosticTest test, DiagnosticCenter center);
	
}
