package com.cg.healthcare.service;

import java.util.List;
import java.util.Set;

import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.exception.AppointmentNotFoundException;

public interface IAppointmentService {
	
	Appointment addAppointment(Appointment appointment)	throws Exception;
	Appointment removeAppointment(Appointment appointment)	throws Exception;
	
	Set<Appointment> viewAppointments(String patientName) throws AppointmentNotFoundException;
	Appointment viewAppointment(int appointmentId) throws AppointmentNotFoundException;
	Appointment updateAppointment(Appointment appointment) throws AppointmentNotFoundException;
	List<Appointment> getApppointmentList(int centreId, String test, int status) throws Exception;


}
