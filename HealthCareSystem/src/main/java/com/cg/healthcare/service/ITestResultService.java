package com.cg.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;
@Service
public interface ITestResultService {

	public TestResult addTestResult(TestResult tr);
	public TestResult updateResult(TestResult tr);
	public TestResult removeTestResult(int id);
	public List<TestResult> viewResultsByPatient(Patient patient);
	

}
