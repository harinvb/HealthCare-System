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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.exception.ConflictException;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.exception.ForBiddenException;
import com.cg.healthcare.service.ITestService;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/Test")
public class TestController {
	@Autowired
	ITestService testService;

	@Autowired
	LoginController logCon;

	/**
	 * @param test
	 * @return DiagnosticTest
	 * @throws ForBiddenException
	 * @throws DataNotFoundInDataBase 
	 */
	@PostMapping("/addtest")
	public DiagnosticTest addTest(@RequestBody DiagnosticTest test) throws ForBiddenException, DataNotFoundInDataBase {
		return testService.addTest(test);
	}

	/**
	 * @param test
	 * @return DiagnosticTest
	 * @throws DataNotFoundInDataBase
	 * @throws ForBiddenException
	 */
	@PutMapping("/updatetest")
	public DiagnosticTest updateTest(@RequestBody DiagnosticTest test)
			throws DataNotFoundInDataBase, ForBiddenException {
		return testService.updateTest(test);
	}

	/**
	 * @param test
	 * @return DiagnosticTest
	 * @throws ConflictException 
	 * @throws DataNotFoundInDataBase 
	 * @throws ForBiddenException 
	 * @throws Exception 
	 */
	@DeleteMapping("/removetest/{diagnosticTestid}")
	public DiagnosticTest removeTest(@PathVariable int diagnosticTestid) throws DataNotFoundInDataBase, ConflictException, ForBiddenException {
		return testService.removeTest(diagnosticTestid);
	}

	/**
	 * @return List<DiagnosticTest>
	 * @throws ForBiddenException
	 */
	@GetMapping("/viewalltest")
	public List<DiagnosticTest> viewAllTest() throws ForBiddenException {
		return testService.viewAllTest();
	}

	/**
	 * @param test
	 * @param center
	 * @return DiagnosticTest
	 * @throws ForBiddenException
	 * @throws DataNotFoundInDataBase
	 */
	@PostMapping("/addtestincenter")
	public DiagnosticTest addTestInCenter(@RequestParam int testID, @RequestParam int centerId)
			throws ForBiddenException, DataNotFoundInDataBase {
		return testService.addTestInCenter(testID, centerId);
	}
}
