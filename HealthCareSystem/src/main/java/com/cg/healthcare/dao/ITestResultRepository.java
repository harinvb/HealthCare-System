package com.cg.healthcare.dao;

import java.util.Set;

import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;

public interface ITestResultRepository {
	public TestResult addTestResult(TestResult tr);
	public TestResult updateResult(TestResult tr);
	public TestResult removeTestResult(int id);
	public Set<TestResult> viewResultsByPatient(Patient patient);
	

}
