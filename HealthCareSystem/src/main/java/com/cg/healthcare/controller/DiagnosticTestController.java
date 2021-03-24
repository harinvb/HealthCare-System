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
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.service.IDiagnosticTestService;


@RestController
@RequestMapping("/DiagnosticTest")
public class DiagnosticTestController {
	@Autowired
	IDiagnosticTestService dtestService;
	@GetMapping("/getAllTests")
	public List<DiagnosticTest> getAllTest(){
		return dtestService.getAllTest();
	}
	@PostMapping("/addNewTest")
	public DiagnosticTest addNewTest(@RequestBody DiagnosticTest test) {
		return dtestService.addNewTest(test);
	}
	@GetMapping("/getTestofDiagnosticCenter/{centerId}")
	public List<DiagnosticTest> getTestsOfDiagnosticCenter(@PathVariable int centerId) throws Exception{
		return dtestService.getTestsOfDiagnosticCenter(centerId);
	}
	@PutMapping("/updateTestDetail")
	public DiagnosticTest updateTestDetail(@RequestBody DiagnosticTest test) throws DataNotFoundInDataBase {
		return dtestService.updateTestDetail(test);
		
	}
	@DeleteMapping("/removeTest/{centerId}/{test}")
	public DiagnosticTest removeTestFromDiagnosticCenter(@PathVariable int centerId,@PathVariable DiagnosticTest test) throws Exception{
		return dtestService.removeTestFromDiagnosticCenter(centerId, test);
	}
}
