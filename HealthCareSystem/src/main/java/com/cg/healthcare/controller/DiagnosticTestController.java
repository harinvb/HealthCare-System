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
import com.cg.healthcare.exception.ForBiddenException;
import com.cg.healthcare.service.IDiagnosticTestService;


@RestController
@RequestMapping("/DiagnosticTest")
public class DiagnosticTestController {
	@Autowired
	IDiagnosticTestService dtestService;
	
	@Autowired
	LoginController logCon;
	
	@GetMapping("/getAllTests")
	public List<DiagnosticTest> getAllTest() throws Exception{
		if(!logCon.loginStatus() & logCon.getRole().equalsIgnoreCase("ADMIN")) throw new ForBiddenException();
		return dtestService.getAllTest();
	}
	@PostMapping("/addNewTest")
	public DiagnosticTest addNewTest(@RequestBody DiagnosticTest test) throws Exception {
		if(!logCon.loginStatus() & logCon.getRole().equalsIgnoreCase("ADMIN")) throw new ForBiddenException();
		return dtestService.addNewTest(test);
	}
	@GetMapping("/getTestofDiagnosticCenter/{centerId}")
	public List<DiagnosticTest> getTestsOfDiagnosticCenter(@PathVariable int centerId) throws Exception{
		if(!logCon.loginStatus() & logCon.getRole().equalsIgnoreCase("ADMIN")) throw new ForBiddenException();
		try {
			dtestService.getTestsOfDiagnosticCenter(centerId);
		}
		catch(Exception e){
			throw new DataNotFoundInDataBase("Diagnostic center with given id not found");
		}
		return dtestService.getTestsOfDiagnosticCenter(centerId);
	}
	@PutMapping("/updateTestDetail")
	public DiagnosticTest updateTestDetail(@RequestBody DiagnosticTest test) throws DataNotFoundInDataBase, ForBiddenException {
		if(!logCon.loginStatus() & logCon.getRole().equalsIgnoreCase("ADMIN")) throw new ForBiddenException();
		return dtestService.updateTestDetail(test);
		
	}
	@DeleteMapping("/removeTest/{centerId}/{test}")
	public DiagnosticTest removeTestFromDiagnosticCenter(@PathVariable int centerId,@PathVariable DiagnosticTest test) throws Exception{
		if(!logCon.loginStatus() & logCon.getRole().equalsIgnoreCase("ADMIN")) throw new ForBiddenException();
		return dtestService.removeTestFromDiagnosticCenter(centerId, test);
	}
}
