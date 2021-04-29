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
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.exception.ForBiddenException;
import com.cg.healthcare.service.IDiagnosticTestService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/DiagnosticTest")
public class DiagnosticTestController {
	@Autowired
	IDiagnosticTestService dtestService;

	@Autowired
	LoginController logCon;

	/**
	 * @return List<DiagnosticTest>
	 * @throws Exception
	 */
	@GetMapping("/getAllTests")
	public List<DiagnosticTest> getAllTest() throws Exception {
		return dtestService.getAllTest();
	}

	/**
	 * @param test
	 * @return DiagnosticTest
	 * @throws Exception
	 */
	@PostMapping("/addNewTest")
	public DiagnosticTest addNewTest(@RequestBody DiagnosticTest test) throws Exception {
		return dtestService.addNewTest(test);
	}

	/**
	 * @param centerId
	 * @return List<DiagnosticTest>
	 * @throws Exception
	 */
	@GetMapping("/getTestofDiagnosticCenter/{centerId}")
	public List<DiagnosticTest> getTestsOfDiagnosticCenter(@PathVariable int centerId) throws Exception {
		try {
			dtestService.getTestsOfDiagnosticCenter(centerId);
		} catch (Exception e) {
			throw new DataNotFoundInDataBase("Diagnostic center with given id not found");
		}
		return dtestService.getTestsOfDiagnosticCenter(centerId);
	}
	@GetMapping("/getTestById/{diagnosticTestid}")
	public DiagnosticTest getTestById(@PathVariable int diagnosticTestid) throws Exception{
		try {
			dtestService.getTestById(diagnosticTestid);
		}
		catch(Exception e) {
			throw new DataNotFoundInDataBase("Diagnostic test with given id not found");
			
		}
		return dtestService.getTestById(diagnosticTestid);
	}

	/**
	 * @param test
	 * @return DiagnosticTest
	 * @throws DataNotFoundInDataBase
	 * @throws ForBiddenException
	 */
	@PutMapping("/updateTestDetail")
	public DiagnosticTest updateTestDetail(@RequestBody DiagnosticTest test)
			throws DataNotFoundInDataBase, ForBiddenException {
		return dtestService.updateTestDetail(test);
	}

	/**
	 * @param centerId
	 * @param test
	 * @return DiagnosticTest
	 * @throws Exception
	 */
	@DeleteMapping("/removeTest/{centerId}/{test}")
	public DiagnosticTest removeTestFromDiagnosticCenter(@PathVariable int centerId, @PathVariable int test)
			throws Exception {
		return dtestService.removeTestFromDiagnosticCenter(centerId, test);
	}
}
