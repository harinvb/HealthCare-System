package com.cg.healthcare.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD


=======
>>>>>>> 20f829a36187753f52095c4c6a3a44ff424bd856
import com.cg.healthcare.dao.ITestResultRepository;
import com.cg.healthcare.dao.ImplementationClasses.QueryClassPersisitContext;
import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;

public class ITestResultServiceImpl implements ITestResultService {
	
	@Autowired
	ITestResultRepository resultrepo;
	
	@Autowired
	QueryClassPersisitContext qcp;

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
	public List<TestResult> viewResultsByPatient(Patient patient) {
		
		return qcp.viewResultsByPatient(patient);
	}

}
