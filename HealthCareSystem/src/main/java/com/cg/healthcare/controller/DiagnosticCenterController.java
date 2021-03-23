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

import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.exception.DiagnosticCenterNotFoundException;
import com.cg.healthcare.service.IDiagnosticCenterService;

@RestController
@RequestMapping("/DiagnosticCenter")
public class DiagnosticCenterController {
	
	@Autowired
	IDiagnosticCenterService centerService;
	public List<DiagnosticCenter> getDiagnosticCenters(){
		return centerService.getAllDiagnosticCenters();
	}
	@PostMapping("/addCenter")
	public DiagnosticCenter addDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter) throws Exception {
		return centerService.addDiagnosticCenter(diagnosticCenter);
		
	}
	@GetMapping("/getDiagnosticCenter/{diagnosticCenterId}")
	public DiagnosticCenter getDiagnosticCenterById(@PathVariable int diagnosticCenterId) {
		return centerService.getDiagnosticCenterById(diagnosticCenterId);
	}
	@PutMapping("/updateDiagnosticCenter")
	public DiagnosticCenter updateDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter) {
		return centerService.updateDiagnosticCenter(diagnosticCenter);
	}
	@GetMapping("/viewTestDetails/{diagnosticCenterId}")
	public DiagnosticTest viewTestDetails(@PathVariable int diagnosticCenterId,@PathVariable String testName) {
		return centerService.viewTestDetails(diagnosticCenterId, testName);
	}
	@PostMapping("/addTest/{diagnosticcenterId}/{testid}")
	public DiagnosticTest addTest(@PathVariable int diagnosticcenterId,@PathVariable int testid) {
		return centerService.addTest(diagnosticcenterId, testid);
	}
	@GetMapping("/getDiagnosticCenter/{centername}")
	public DiagnosticCenter getDiagnosticCenter(@PathVariable String centername) {
		return centerService.getDiagnosticCenter(centername);
	}
	@DeleteMapping("/removeDiagnosticCenter/{id}")
	public DiagnosticCenter removeDiagnosticCenter(@PathVariable int id) throws DiagnosticCenterNotFoundException{
		return centerService.removeDiagnosticCenter(id);
	}
	@GetMapping("/appointments/{centerName}")
	public List<Appointment> getListOfAppointments(@PathVariable String centerName){
		return centerService.getListOfAppointments(centerName);
	}
	
	
}
