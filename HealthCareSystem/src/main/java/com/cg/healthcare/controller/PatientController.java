package com.cg.healthcare.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.cg.healthcare.exception.DataAlreadyExists;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.exception.ForBiddenException;
import com.cg.healthcare.service.IPatientService;

@RestController
@RequestMapping("/patient")
@CrossOrigin("http://localhost:4200")
public class PatientController {

	@Autowired
	IPatientService patientService;

	@Autowired
	LoginController logCon;

	/**
	 * @param patient
	 * @return Patient
	 * @throws DataNotFoundInDataBase 
	 * @throws DataAlreadyExists 
	 */
	@PostMapping("/registerpatient/{userID}")
	public Patient registerPatient(@RequestBody Patient patient,@PathVariable int userID) throws DataAlreadyExists, DataNotFoundInDataBase {
		return patientService.registerPatient(patient,userID);
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
	@GetMapping("/viewpatient/{userid}")
	Patient viewPatient(@PathVariable String userid) throws ForBiddenException, DataNotFoundInDataBase {
		return patientService.viewPatient(userid);
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
	
	@GetMapping("/getAll")
	public List<Patient> getAll(){
		return patientService.getAll();
	}
}
