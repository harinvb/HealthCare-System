package com.cg.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.service.AppointmentService;

@RestController
@RequestMapping("/")
public class HealthCareController {
	
	@Autowired
	AppointmentService appserv;
	
	@PostMapping
	public Appointment getAppointments(@RequestBody Appointment appointment) throws Exception {
		
		return appserv.addAppointment(appointment);
	}
	
	@GetMapping
	public List<Appointment> get() {
		return appserv.get();
	}
}
