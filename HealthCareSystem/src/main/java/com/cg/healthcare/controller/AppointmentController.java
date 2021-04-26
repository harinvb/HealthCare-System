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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;
import com.cg.healthcare.exception.AppointmentNotFoundException;
import com.cg.healthcare.exception.PatientNotFoundException;
import com.cg.healthcare.exception.TestResultNotFoundException;
import com.cg.healthcare.service.IAppointmentService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/Appointment")
public class AppointmentController {
	
	@Autowired
	IAppointmentService appserv;


	/**
	 * @param appointment
	 * @param false
	 * @return Appointment
	 */
	@PostMapping(value = "/addappointment")
	public Appointment addAppointment(@RequestBody Appointment appointment,
			@RequestParam(required = true) String patientID, @RequestParam(required = true) String diagnosticCenterID,
			@RequestParam(required = true) List<Integer> testIds) throws Exception {
		return appserv.addAppointment(appointment, patientID, diagnosticCenterID, testIds);
	}

	/**
	 * @param appointment
	 * @return Appointment
	 * @throws Exception
	 */
	@DeleteMapping("/removeappointment")
	public Appointment removeAppointment(@RequestBody Appointment appointment) throws Exception {
		return appserv.removeAppointment(appointment);
	}

	/**
	 * @param patientName
	 * @return List<Appointment>
	 * @throws Exception
	 */
	@GetMapping("/viewappointments/{patientId}")
	public List<Appointment> viewAppointments(@PathVariable int patientId) throws Exception {
		return appserv.viewAppointments(patientId);
	}

	/**
	 * @param appointmentId
	 * @return Appointment
	 * @throws Exception
	 */
	@GetMapping("/viewappointment/{appointmentId}")
	public Appointment viewAppointment(@PathVariable int appointmentId) throws Exception {
		return appserv.viewAppointment(appointmentId);
	}

	/**
	 * @param updateAppointment(
	 * @return Appointment
	 */
	@PutMapping("/updateappointment")
	public Appointment updateAppointment(@RequestBody Appointment appointment,
			@RequestParam(required = false) List<Integer> testResultId,
			@RequestParam(required = false) String patientID, @RequestParam(required = false) String diagnosticCenterID,
			@RequestParam(required = false) List<Integer> testIds) throws Exception {
		return appserv.updateAppointment(appointment, testResultId, patientID, diagnosticCenterID, testIds);
	}

	/**
	 * @param getApppointmentList(
	 * @return List<Appointment>
	 * @throws Exception
	 */
	@GetMapping("/getappointmentlist")
	public List<Appointment> getApppointmentList(@RequestParam String diagnosticCenterid, @RequestParam String testName,
			@RequestParam String appointmentStatus) throws Exception {
		return appserv.getApppointmentList(Integer.parseInt(diagnosticCenterid), testName, appointmentStatus);
	}
	
	@PutMapping("/verify")
	public Appointment verify(@RequestBody Appointment appointment) throws AppointmentNotFoundException {
		
		return appserv.verify(appointment.getAppointmentid(), true);
	}
	
	@PutMapping("/reject")
	public Appointment reject(@RequestBody Appointment appointment) throws AppointmentNotFoundException {
		return appserv.verify(appointment.getAppointmentid() , false);
	}
	
	@GetMapping("/getVerifiable")
	public List<Appointment> verifiable() {
		return appserv.verifiable();
		
	}
	
	@GetMapping("/getWithNoTestResults")
	public List<Appointment> noTestResults(){
		return appserv.noTestResults();
	}
	
	@GetMapping("/getPatient/{AppointmentId}")
	public Patient getPatient(@PathVariable int appID) throws PatientNotFoundException {
		return appserv.getPatient(appID);
	}
	
	@PutMapping("/addTestRes/{AppointmentId}/{testResId}")
	public TestResult addTestRes(@PathVariable int AppointmentId,@PathVariable int testResId) throws AppointmentNotFoundException, TestResultNotFoundException {
		return appserv.setTestResult(AppointmentId,testResId);
	}
	
	@GetMapping("/getAll")
	public List<Appointment> getAll(){
		return appserv.getAll();
	}
	
	
}
