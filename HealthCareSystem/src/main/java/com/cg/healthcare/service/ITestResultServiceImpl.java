package com.cg.healthcare.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.healthcare.dao.ITestResultRepository;
import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;

public class ITestResultServiceImpl implements ITestResultService {
	
	@Autowired
	ITestResultRepository resultrepo;

	@Override
	public TestResult addTestResult(TestResult tr) {
		
		return resultrepo.saveAndFlush(tr);
	}

	@Override
	public TestResult updateResult(TestResult tr) {
		return resultrepo.saveAndFlush(tr);
	}

	@Override
	public TestResult removeTestResult(int id) {
		TestResult tr = resultrepo.getOne(id);
		resultrepo.deleteById(id);
		return tr;
	}

	@Override
	public Set<TestResult> viewResultsByPatient(Patient patient) {
		
		return null;
	}

}
