package com.cg.healthcare.service;

import java.util.List;


import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.exception.AppointmentNotFoundException;


@Service
public interface IAppointmentService {
	
	Appointment addAppointment(Appointment appointment)	throws Exception;
	Appointment removeAppointment(Appointment appointment)	throws Exception;
	List<Appointment> viewAppointments(String patientName) throws AppointmentNotFoundException;
	Appointment viewAppointment(int appointmentId) throws AppointmentNotFoundException;
	Appointment updateAppointment(Appointment appointment) throws AppointmentNotFoundException;
	List<Appointment> getApppointmentList(int centreId, String test, String status) throws Exception;


}
