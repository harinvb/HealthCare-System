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

	/**
	 * @param patient
	 * @return Patient
	 * @throws Exception
	 */
	@PostMapping("/registerpatient")
	public Patient registerPatient(@RequestBody Patient patient) throws Exception {
		return patientService.registerPatient(patient);
	}

	/**
	 * @param patient
	 * @return Patient
	 * @throws DataNotFoundInDataBase
	 * @throws ForBiddenException
	 */
	@PutMapping("/updatepatient")
	public Patient updatePatientDetails(@RequestBody Patient patient)
			throws DataNotFoundInDataBase, ForBiddenException {
		return patientService.updatePatientDetails(patient);
	}

	/**
	 * @param patientUserName
	 * @return List<Patient>
	 * @throws ForBiddenException
	 * @throws DataNotFoundInDataBase
	 */
	@GetMapping("/viewpatient/{patientUserName}")
	List<Patient> viewPatient(@PathVariable String patientUserName) throws ForBiddenException, DataNotFoundInDataBase {
		return patientService.viewPatient(patientUserName);
	}

	/**
	 * @param testResultId
	 * @return TestResult
	 * @throws Exception
	 */
	@GetMapping("/viewtestresult/{testResultId}")
	TestResult viewTestResult(@PathVariable int testResultId) throws Exception {
		return patientService.viewTestResult(testResultId);
	}

	@DeleteMapping("/deletePatient")
	Patient deletePatient(@RequestBody Patient patient) throws DataNotFoundInDataBase, ForBiddenException {
		return patientService.deletePatient(patient);
	}
}
