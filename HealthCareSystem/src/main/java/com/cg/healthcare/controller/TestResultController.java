package com.cg.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.exception.ForBiddenException;
import com.cg.healthcare.service.ITestResultService;

@RestController
@RequestMapping("/testresult")
public class TestResultController {
	@Autowired
	ITestResultService testresultService;
	
	@Autowired
	LoginController logCon;
	
	@PostMapping("/addresult")
	public TestResult addTestResult(@RequestBody TestResult tr) throws ForBiddenException {
		if(!logCon.loginStatus()) throw new ForBiddenException();
		return testresultService.addTestResult(tr);
	}
	@PutMapping("/updateresult")
	public TestResult updateResult(@RequestBody TestResult tr) throws DataNotFoundInDataBase, ForBiddenException {
		if(!logCon.loginStatus()) throw new ForBiddenException();
		return testresultService.updateResult(tr);
	}
	@DeleteMapping("/removeresult")
	public TestResult removeTestResult(@PathVariable int id) throws ForBiddenException {
		if(!logCon.loginStatus()) throw new ForBiddenException();
		return testresultService.removeTestResult(id);
	}
	@GetMapping("/viewresultsbypatient")
	public List<TestResult> viewResultsByPatient(@RequestBody Patient patient) throws ForBiddenException{
		if(!logCon.loginStatus()) throw new ForBiddenException();
		return testresultService.viewResultsByPatient(patient);
	}
	

}
