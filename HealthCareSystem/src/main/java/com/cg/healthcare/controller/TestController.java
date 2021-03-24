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
import com.cg.healthcare.service.ITestService;

@RestController
@RequestMapping("/Test")
public class TestController {
	@Autowired
	ITestService testService;
	@PostMapping("/addtest")
	public DiagnosticTest addTest(@RequestBody DiagnosticTest test) {
		return testService.addTest(test);
	}
	@PutMapping("/updatetest")
	public DiagnosticTest updateTest(@RequestBody DiagnosticTest test) {
		return testService.updateTest(test);
	}
	@DeleteMapping("/removetest")
	public DiagnosticTest removeTest(@RequestBody DiagnosticTest test) {
		return testService.removeTest(test);
	}
	@GetMapping("/viewalltest")
	public List<DiagnosticTest> viewAllTest(){
		return testService.viewAllTest();
	}
	@PostMapping("/addtestincenter")
	public DiagnosticTest addTestInCenter(@RequestBody DiagnosticTest test,@RequestBody DiagnosticCenter center) {
		return testService.addTestInCenter( test, center);
	}
}
