package com.cg.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.healthcare.dao.IDiagnosticTestRepository;
import com.cg.healthcare.entities.DiagnosticTest;

public class DiagnosticTestService implements IDiagnosticTestService {

	@Autowired
	IDiagnosticTestRepository testRepo;
	@Override
	public List<DiagnosticTest> getAllTest() {
		// TODO Auto-generated method stub
		return testRepo.findAll();
	}

	@Override
	public DiagnosticTest addNewTest(DiagnosticTest test) {
		// TODO Auto-generated method stub
		return testRepo.saveAndFlush(test);
	}

	@Override
	public List<DiagnosticTest> getTestsOfDiagnosticCenter(int centerId) throws Exception {
		
		return null;
	}

	@Override
	public DiagnosticTest updateTestDetail(DiagnosticTest test) {
		return testRepo.saveAndFlush(test);
	}

	@Override
	public DiagnosticTest removeTestFromDiagnosticCenter(int centerId, DiagnosticTest test) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
