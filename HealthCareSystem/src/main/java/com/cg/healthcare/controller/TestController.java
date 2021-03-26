package com.cg.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthcare.entities.DiagnosticCenter;
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
	
	@PostMapping("/addtest")
	public DiagnosticTest addTest(@RequestBody DiagnosticTest test) throws ForBiddenException {
		if(!logCon.loginStatus() & logCon.getRole().equalsIgnoreCase("ADMIN")) throw new ForBiddenException();
		return testService.addTest(test);
	}
	@PutMapping("/updatetest")
	public DiagnosticTest updateTest(@RequestBody DiagnosticTest test) throws DataNotFoundInDataBase, ForBiddenException {
		if(!logCon.loginStatus() & logCon.getRole().equalsIgnoreCase("ADMIN")) throw new ForBiddenException();
		return testService.updateTest(test);
	}
	@DeleteMapping("/removetest")
	public DiagnosticTest removeTest(@RequestBody DiagnosticTest test) throws ForBiddenException {
		if(!logCon.loginStatus() & logCon.getRole().equalsIgnoreCase("ADMIN")) throw new ForBiddenException();
		return testService.removeTest(test);
	}
	@GetMapping("/viewalltest")
	public List<DiagnosticTest> viewAllTest() throws ForBiddenException{
		if(!logCon.loginStatus()) throw new ForBiddenException();
		return testService.viewAllTest();
	}
	@PostMapping("/addtestincenter")
	public DiagnosticTest addTestInCenter(@RequestBody DiagnosticTest test,@RequestBody DiagnosticCenter center) throws ForBiddenException {
		if(!logCon.loginStatus() & logCon.getRole().equalsIgnoreCase("ADMIN")) throw new ForBiddenException();
		return testService.addTestInCenter( test, center);
	}
}
