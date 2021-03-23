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
import com.cg.healthcare.service.AppointmentService;
import com.cg.healthcare.service.IDiagnosticCenterService;

@RestController
@RequestMapping("/healthcareapp")
public class HealthCareController {
	
	@Autowired
	AppointmentService appserv;
	IDiagnosticCenterService centerService;
	@PostMapping
	public Appointment getAppointments(@RequestBody Appointment appointment) throws Exception {
		
		return appserv.addAppointment(appointment);
	}
	
	@GetMapping
	public List<Appointment> get() {
		return appserv.get();
	}
	@RequestMapping
	public List<DiagnosticCenter> getDiagnosticCenters(){
		return centerService.getAllDiagnosticCenters();
	}
	@PostMapping("/addCenter")
	public DiagnosticCenter addDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter) throws Exception {
		return centerService.addDiagnosticCenter(diagnosticCenter);
		
	}
	@GetMapping("/{diagnosticCenterId}")
	public DiagnosticCenter getDiagnosticCenterById(@PathVariable int diagnosticCenterId) {
		return centerService.getDiagnosticCenterById(diagnosticCenterId);
	}
	@PutMapping
	public DiagnosticCenter updateDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter) {
		return centerService.updateDiagnosticCenter(diagnosticCenter);
	}
	@GetMapping("/viewTestDetails")
	public DiagnosticTest viewTestDetails(@PathVariable int diagnosticCenterId,String testName) {
		return centerService.viewTestDetails(diagnosticCenterId, testName);
	}
	@PostMapping("/addTest")
	public DiagnosticTest addTest(@PathVariable int diagnosticcenterId, int testid) {
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
