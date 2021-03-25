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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.exception.AppointmentNotFoundException;
import com.cg.healthcare.service.IAppointmentService;


@RestController
@RequestMapping("/Appointment")
public class AppointmentController {
	@Autowired
	IAppointmentService appserv;
	
	
	@PostMapping(value = "/addappointment")
	public Appointment addAppointment(@RequestBody Appointment appointment,@RequestParam(required = false) String patientID ,
			@RequestParam(required = false) String diagnosticCenterID,@RequestParam(required = false) List<Integer> testIds) throws Exception {
		return appserv.addAppointment(appointment,patientID,diagnosticCenterID,testIds);
	}
	
	
	@DeleteMapping("/removeappointment")
	public Appointment removeAppointment(@RequestBody Appointment appointment) throws Exception{
		return appserv.removeAppointment(appointment);
	}
	@GetMapping("/viewappointments/{patientName}")
	public List<Appointment> viewAppointments(@PathVariable String patientName) throws AppointmentNotFoundException{
		try {
			appserv.viewAppointments(patientName);
		}
		catch(Exception e) {
			throw new AppointmentNotFoundException("Appointment with given patient name doesn't exist");
		}
		return appserv.viewAppointments(patientName);
	}
	
	
	@GetMapping("/viewappointment/{appointmentId}")
	public Appointment viewAppointment(@PathVariable int appointmentId) throws AppointmentNotFoundException{
		try {
			appserv.viewAppointment(appointmentId);
		}
		catch(Exception e) {
			throw new AppointmentNotFoundException("Appointment with given appointment id doesn't exist");
		}
		return appserv.viewAppointment(appointmentId);
	}
	
	
	@PutMapping("/updateappointment")
	public Appointment updateAppointment(@RequestBody Appointment appointment) throws AppointmentNotFoundException{
		return appserv.updateAppointment(appointment);
	}
	
	
	@GetMapping("/getappointmentlist/{diagnosticCenterid}/{testName}/{appointmentStatus}")
	public List<Appointment> getApppointmentList(@PathVariable String diagnosticCenterid,@PathVariable String testName,@PathVariable String appointmentStatus) throws Exception{
		return appserv.getApppointmentList(Integer.parseInt(diagnosticCenterid), testName, appointmentStatus);
	}
}
