package com.cg.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;
import com.cg.healthcare.service.IPatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	IPatientService patientService;
	@PostMapping("/registerpatient")
	public Patient registerPatient(@RequestBody Patient patient) throws Exception{
		return patientService.registerPatient(patient);
	}
	@PutMapping("/updatepatient")
	public Patient updatePatientDetails(@RequestBody Patient patient) {
		return patientService.updatePatientDetails(patient);
	}
	@GetMapping("/viewpatient/{patientUserName}")
	Patient viewPatient(@PathVariable String patientUserName) {
		return patientService.viewPatient(patientUserName);
	}
	@GetMapping("/viewtestresult/{testResultId}")
	TestResult viewTestResult(@PathVariable int testResultId) throws Exception{
		return patientService.viewTestResult(testResultId);
	}
}
