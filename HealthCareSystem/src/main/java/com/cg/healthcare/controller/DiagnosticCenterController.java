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
import com.cg.healthcare.exception.DataNotFoundInDataBase;
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
		DiagnosticCenter d;
		try {
			d=centerService.addDiagnosticCenter(diagnosticCenter);
		}
		catch(Exception e) {
			throw new Exception("Please recheck all the fields properly");
		}
		return d;
		
	}
	@GetMapping("/getDiagnosticCenter/{diagnosticCenterId}")
<<<<<<< HEAD

	public DiagnosticCenter getDiagnosticCenterById(@PathVariable int diagnosticCenterId) throws DiagnosticCenterNotFoundException, DataNotFoundInDataBase {
=======
	public DiagnosticCenter getDiagnosticCenterById(@PathVariable int diagnosticCenterId) throws DiagnosticCenterNotFoundException {
		DiagnosticCenter d;
>>>>>>> 54b20fc3a3f6a0cefad3521924dd6b98e9f0feb0
		try {
			d=centerService.getDiagnosticCenterById(diagnosticCenterId);
		}
		catch(Exception e) {
			throw new DiagnosticCenterNotFoundException("diagnostic center with given id not found");
		}
<<<<<<< HEAD
		return centerService.getDiagnosticCenterById(diagnosticCenterId);
=======
		return d;
>>>>>>> 54b20fc3a3f6a0cefad3521924dd6b98e9f0feb0
	}

	@PutMapping("/updateDiagnosticCenter")
	public DiagnosticCenter updateDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter) throws DataNotFoundInDataBase {
		return centerService.updateDiagnosticCenter(diagnosticCenter);
	}
	@GetMapping("/viewTestDetails/{diagnosticCenterId}/{testName}")
	public DiagnosticTest viewTestDetails(@PathVariable int diagnosticCenterId,@PathVariable String testName) {
		return centerService.viewTestDetails(diagnosticCenterId, testName);
	}
	@PostMapping("/addTest/{diagnosticcenterId}/{testid}")
	public DiagnosticTest addTest(@PathVariable int diagnosticcenterId,@PathVariable int testid) throws DataNotFoundInDataBase {
		return centerService.addTest(diagnosticcenterId, testid);
	}
	@GetMapping("/getDiagnosticCenterbyname/{centername}")
	public DiagnosticCenter getDiagnosticCenter(@PathVariable String centername) throws DataNotFoundInDataBase {
		return centerService.getDiagnosticCenter(centername);
	}
	@DeleteMapping("/removeDiagnosticCenter/{id}")
<<<<<<< HEAD

=======
>>>>>>> 54b20fc3a3f6a0cefad3521924dd6b98e9f0feb0
	public DiagnosticCenter removeDiagnosticCenter(@PathVariable int id) throws DiagnosticCenterNotFoundException{
		DiagnosticCenter d;
		try {
			d=centerService.removeDiagnosticCenter(id);
		}
		catch(Exception e) {
			throw new DiagnosticCenterNotFoundException("diagnostic center with given id not found");
		}
<<<<<<< HEAD
		return centerService.removeDiagnosticCenter(id);
}
=======
		return d;
	}
>>>>>>> 54b20fc3a3f6a0cefad3521924dd6b98e9f0feb0
	@GetMapping("/appointments/{centerName}")
	public List<Appointment> getListOfAppointments(@PathVariable String centerName){
		return centerService.getListOfAppointments(centerName);
	}
	
	
}
