package com.cg.healthcare.service;

import java.util.Set;

import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;

public interface ITestResultService {

	public TestResult addTestResult(TestResult tr);
	public TestResult updateResult(TestResult tr);
	public TestResult removeTestResult(int id);
	public Set<TestResult> viewResultsByPatient(Patient patient);
	

}
