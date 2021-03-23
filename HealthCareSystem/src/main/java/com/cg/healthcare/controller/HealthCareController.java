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
import com.cg.healthcare.service.IAppointmentServiceImpl;
import com.cg.healthcare.service.IDiagnosticCenterService;
import com.cg.healthcare.service.IDiagnosticTestService;

@RestController
@RequestMapping("/healthcareapp")
public class HealthCareController {
	
	@Autowired
	IAppointmentServiceImpl appserv;
	IDiagnosticCenterService centerService;
	IDiagnosticTestService testService;
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
	@PostMapping("/diagnosticCenter/addCenter")
	public DiagnosticCenter addDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter) throws Exception {
		return centerService.addDiagnosticCenter(diagnosticCenter);
		
	}
	@GetMapping("/diagnosticCenter/getDiagnosticCenter/{diagnosticCenterId}")
	public DiagnosticCenter getDiagnosticCenterById(@PathVariable int diagnosticCenterId) {
		return centerService.getDiagnosticCenterById(diagnosticCenterId);
	}
	@PutMapping("/diagnosticCenter/updateDiagnosticCenter")
	public DiagnosticCenter updateDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter) {
		return centerService.updateDiagnosticCenter(diagnosticCenter);
	}
	@GetMapping("/diagnosticCenter/viewTestDetails/{diagnosticCenterId}")
	public DiagnosticTest viewTestDetails(@PathVariable int diagnosticCenterId,@PathVariable String testName) {
		return centerService.viewTestDetails(diagnosticCenterId, testName);
	}
	@PostMapping("/diagnosticCenter/addTest/{diagnosticcenterId}/{testid}")
	public DiagnosticTest addTest(@PathVariable int diagnosticcenterId,@PathVariable int testid) {
		return centerService.addTest(diagnosticcenterId, testid);
	}
	@GetMapping("/diagnosticCenter/getDiagnosticCenter/{centername}")
	public DiagnosticCenter getDiagnosticCenter(@PathVariable String centername) {
		return centerService.getDiagnosticCenter(centername);
	}
	@DeleteMapping("/diagnosticCenter/removeDiagnosticCenter/{id}")
	public DiagnosticCenter removeDiagnosticCenter(@PathVariable int id) throws DiagnosticCenterNotFoundException{
		return centerService.removeDiagnosticCenter(id);
	}
	@GetMapping("/diagnosticCenter/appointments/{centerName}")
	public List<Appointment> getListOfAppointments(@PathVariable String centerName){
		return centerService.getListOfAppointments(centerName);
	}
	@GetMapping("/diagnosticTest/getAllTests")
	public List<DiagnosticTest> getAllTest(){
		return testService.getAllTest();
	}
	@PostMapping("/diagnosticTest/addNewTest")
	public DiagnosticTest addNewTest(@RequestBody DiagnosticTest test) {
		return testService.addNewTest(test);
	}
	@GetMapping("/diagnosticTest/getTestofDiagnosticCenter/{centerId}")
	public List<DiagnosticTest> getTestsOfDiagnosticCenter(@PathVariable int centerId) throws Exception{
		return testService.getTestsOfDiagnosticCenter(centerId);
	}
	@PutMapping("/diagnosticTest/updateTestDetail")
	public DiagnosticTest updateTestDetail(@RequestBody DiagnosticTest test) {
		return testService.updateTestDetail(test);
		
	}
	@DeleteMapping("/diagnosticTest/removeTest/{centerId}/{test}")
	public DiagnosticTest removeTestFromDiagnosticCenter(@PathVariable int centerId,@PathVariable DiagnosticTest test) throws Exception{
		return testService.removeTestFromDiagnosticCenter(centerId, test);
	}
	
}
