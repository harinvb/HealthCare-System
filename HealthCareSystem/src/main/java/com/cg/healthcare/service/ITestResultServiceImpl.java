package com.cg.healthcare.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthcare.dao.ITestResultRepository;
import com.cg.healthcare.dao.ImplementationClasses.QueryClassPersisitContext;
import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;
import com.cg.healthcare.exception.DataNotFoundInDataBase;

@Service
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
	public TestResult updateResult(TestResult tr) throws DataNotFoundInDataBase {
		if(!resultrepo.existsById(tr.getTestResultid()))throw new DataNotFoundInDataBase("TestResult Not Found in DataBase");
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
