package com.cg.healthcare.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthcare.dao.TestRepository;
import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
@Service
public class ITestServiceImpl implements ITestService {

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
	public List<DiagnosticTest> viewAllTest() {
		return testrepo.findAll();
	}



	@Override
	public DiagnosticTest addTestInCenter(DiagnosticTest test, DiagnosticCenter center) {
		test.setDiagnosticCenter(center);
		center.getTests().add(test);
		testrepo.save(test);
		return test;
	}

}
