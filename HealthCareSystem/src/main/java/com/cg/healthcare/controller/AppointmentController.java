package com.cg.healthcare.controller;

import java.util.List;
import java.util.Set;

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
import com.cg.healthcare.exception.AppointmentNotFoundException;
import com.cg.healthcare.service.IAppointmentServiceImpl;

@RestController
@RequestMapping("/Appointment")
public class AppointmentController {
	@Autowired
	IAppointmentServiceImpl appserv;
	@PostMapping("/addappointment")
	public Appointment addAppointment(@RequestBody Appointment appointment) throws Exception {
		return appserv.addAppointment(appointment);
	}
	@DeleteMapping("/removeappointment")
	public Appointment removeAppointment(@RequestBody Appointment appointment) throws Exception{
		return appserv.removeAppointment(appointment);
	}
	@GetMapping("/viewappointments/{patientName}")
	public Set<Appointment> viewAppointments(@PathVariable String patientName) throws AppointmentNotFoundException{
		return appserv.viewAppointments(patientName);
	}
	@GetMapping("/viewappointment/{appointmentId}")
	public Appointment viewAppointment(@PathVariable int appointmentId) throws AppointmentNotFoundException{
		return appserv.viewAppointment(appointmentId);
	}
	@PutMapping("/updateappointment")
	public Appointment updateAppointment(@RequestBody Appointment appointment) throws AppointmentNotFoundException{
		return appserv.updateAppointment(appointment);
	}
	@GetMapping("/getappointmentlist/{centerId}/{test}/{status}")
	public List<Appointment> getApppointmentList(@PathVariable int centreId,@PathVariable String test,@PathVariable String status) throws Exception{
		return appserv.getApppointmentList(centreId, test, status);
	}
}
