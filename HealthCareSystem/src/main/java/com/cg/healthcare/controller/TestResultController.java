package com.cg.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.cg.healthcare.exception.DataAlreadyExists;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.exception.ForBiddenException;
import com.cg.healthcare.exception.TestResultNotFoundException;
import com.cg.healthcare.service.ITestResultService;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/testresult")
public class TestResultController {
	@Autowired
	ITestResultService testresultService;

	@Autowired
	LoginController logCon;

	/**
	 * @param tr
	 * @return TestResult
	 * @throws ForBiddenException
	 * @throws DataAlreadyExists
	 */
	@PostMapping("/addresult")
	public TestResult addTestResult(@RequestBody TestResult tr) throws ForBiddenException, DataAlreadyExists {
		return testresultService.addTestResult(tr);
	}

	/**
	 * @param tr
	 * @return TestResult
	 * @throws DataNotFoundInDataBase
	 * @throws ForBiddenException
	 */
	@PutMapping("/updateresult")
	public TestResult updateResult(@RequestBody TestResult tr) throws DataNotFoundInDataBase, ForBiddenException {
		return testresultService.updateResult(tr);
	}

	/**
	 * @param id
	 * @return TestResult
	 * @throws ForBiddenException
	 * @throws TestResultNotFoundException
	 */
	@DeleteMapping("/removeresult/{id}")
	public List<TestResult> removeTestResult(@PathVariable int id) throws ForBiddenException, TestResultNotFoundException {
		return testresultService.removeTestResult(id);
	}
	


	/**
	 * @param patient
	 * @return List<TestResult>
	 * @throws Exception
	 */
	@GetMapping("/viewresultsbypatient/{patientID}")
	public List<TestResult> viewResultsByPatient(@PathVariable int patientID) throws Exception {
		Patient pat = new Patient();
		try {
			pat.setPatientId(patientID);
		} catch (Exception e) {
			throw new Exception("This is Not An ID");
		}
		return testresultService.viewResultsByPatient(pat);
	}
	
	@GetMapping("/getAllTestResults")
	public List<TestResult> getAllTestResults(){
		return testresultService.getAll();
	}
	@GetMapping("/resultbyid/{id}")
	public TestResult getById(@PathVariable int id) throws DataNotFoundInDataBase {
		return testresultService.getById(id);
	}
	

}
