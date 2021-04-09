package com.cg.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.exception.ForBiddenException;
import com.cg.healthcare.service.ITestService;

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
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		if (!logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException("Not An Admin");
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
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		if (!logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException("Not An Admin");
		return testService.updateTest(test);
	}

	/**
	 * @param test
	 * @return DiagnosticTest
	 * @throws ForBiddenException
	 */
	@DeleteMapping("/removetest")
	public DiagnosticTest removeTest(@RequestBody DiagnosticTest test) throws ForBiddenException {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		if (!logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException("Not An Admin");
		return testService.removeTest(test);
	}

	/**
	 * @return List<DiagnosticTest>
	 * @throws ForBiddenException
	 */
	@GetMapping("/viewalltest")
	public List<DiagnosticTest> viewAllTest() throws ForBiddenException {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		if (!logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException("Not An Admin");
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
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		if (!logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException("Not An Admin");
		return testService.addTestInCenter(testID, centerId);
	}
}
