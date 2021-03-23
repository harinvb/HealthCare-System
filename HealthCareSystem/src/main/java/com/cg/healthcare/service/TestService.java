package com.cg.healthcare.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.healthcare.dao.TestRepository;
import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;

public class TestService implements ITestService {

	@Autowired
	TestRepository testrepo;
	@Override
	public DiagnosticTest addTest(DiagnosticTest test) {
		return testrepo.saveAndFlush(test);
	}

	@Override
	public DiagnosticTest updateTest(DiagnosticTest test) {
		return testrepo.saveAndFlush(test);
	}

	@Override
	public DiagnosticTest removeTest(DiagnosticTest test) {
		testrepo.delete(test);
		return test;
	}

	@Override
	public List<DiagnosticTest> viewAllTest(DiagnosticTest test) {
		
		return testrepo.findAll();
	}

	@Override
	public DiagnosticTest addTestInCenter(DiagnosticCenter center) {
		
		return null;
	}

}
