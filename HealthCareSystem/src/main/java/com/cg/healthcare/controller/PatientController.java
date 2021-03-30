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
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.exception.ForBiddenException;
import com.cg.healthcare.service.IPatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	IPatientService patientService;
	
	@Autowired
	LoginController logCon;
	
	@PostMapping("/registerpatient")
	public Patient registerPatient(@RequestBody Patient patient) throws Exception{
		if(!logCon.loginStatus()) throw new ForBiddenException();
		return patientService.registerPatient(patient);
	}
	@PutMapping("/updatepatient")
	public Patient updatePatientDetails(@RequestBody Patient patient) throws DataNotFoundInDataBase, ForBiddenException {
		if(!logCon.loginStatus()) throw new ForBiddenException();
		return patientService.updatePatientDetails(patient);
	}
	@GetMapping("/viewpatient/{patientUserName}")
	Patient viewPatient(@PathVariable String patientUserName) throws ForBiddenException, DataNotFoundInDataBase {
		if(!logCon.loginStatus()) throw new ForBiddenException();
		return patientService.viewPatient(patientUserName);
	}
	@GetMapping("/viewtestresult/{testResultId}")
	TestResult viewTestResult(@PathVariable int testResultId) throws Exception{
		if(!logCon.loginStatus()) throw new ForBiddenException();
		return patientService.viewTestResult(testResultId);
	}
}
