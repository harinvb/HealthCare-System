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
import com.cg.healthcare.exception.DataAlreadyExists;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.exception.ForBiddenException;
import com.cg.healthcare.exception.TestResultNotFoundException;
import com.cg.healthcare.service.ITestResultService;

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
		if(!logCon.loginStatus()) throw new ForBiddenException("Not Logged In");
		if(!logCon.getRole().equalsIgnoreCase("ADMIN")) throw new ForBiddenException("Not An Admin");
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
		if(!logCon.loginStatus()) throw new ForBiddenException("Not Logged In");
		if(!logCon.getRole().equalsIgnoreCase("ADMIN")) throw new ForBiddenException("Not An Admin");
		return testresultService.updateResult(tr);
	}
	
	/** 
	 * @param id
	 * @return TestResult
	 * @throws ForBiddenException
	 * @throws TestResultNotFoundException
	 */
	@DeleteMapping("/removeresult/{id}")
	public TestResult removeTestResult(@PathVariable int id) throws ForBiddenException, TestResultNotFoundException {
		if(!logCon.loginStatus()) throw new ForBiddenException("Not Logged In");
		if(!logCon.getRole().equalsIgnoreCase("ADMIN")) throw new ForBiddenException("Not An Admin");
		return testresultService.removeTestResult(id);
	}
	
	/** 
	 * @param patient
	 * @return List<TestResult>
	 * @throws ForBiddenException
	 */
	@GetMapping("/viewresultsbypatient")
	public List<TestResult> viewResultsByPatient(@RequestBody Patient patient) throws ForBiddenException{
		if(!logCon.loginStatus()) throw new ForBiddenException("Not Logged In");
		if(!logCon.getRole().equalsIgnoreCase("ADMIN")) throw new ForBiddenException("Not An Admin");
		return testresultService.viewResultsByPatient(patient);
	}
	

}
