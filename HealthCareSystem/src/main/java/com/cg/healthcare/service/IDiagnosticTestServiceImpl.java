package com.cg.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthcare.dao.IDiagnosticTestRepository;
import com.cg.healthcare.dao.ImplementationClasses.QueryClassPersisitContext;
import com.cg.healthcare.entities.DiagnosticTest;

@Service
public class IDiagnosticTestServiceImpl implements IDiagnosticTestService {

	@Autowired
	IDiagnosticTestRepository testRepo;
	@Autowired
	QueryClassPersisitContext qcp;
	@Override
	public List<DiagnosticTest> getAllTest() {
		return testRepo.findAll();
	}

	@Override
	public DiagnosticTest addNewTest(DiagnosticTest test) {
		return testRepo.saveAndFlush(test);
	}

	@Override
	public List<DiagnosticTest> getTestsOfDiagnosticCenter(int centerId) throws Exception {
		
		return qcp.getTestsOfDiagnosticCenter(centerId);
	}

	@Override
	public DiagnosticTest updateTestDetail(DiagnosticTest test) {
		return testRepo.saveAndFlush(test);
	}

	@Override
	public DiagnosticTest removeTestFromDiagnosticCenter(int centerId, DiagnosticTest test) throws Exception {
		
		return qcp.removeTestFromDiagnosticCenter(centerId, test);
	}

}
