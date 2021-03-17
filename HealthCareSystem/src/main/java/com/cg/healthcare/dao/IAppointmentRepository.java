package com.cg.healthcare.dao;

import java.util.Set;

import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.exception.AppointmentNotFoundException;

public interface IAppointmentRepository{
	
	Appointment addAppointment(Appointment appointment)	throws Exception;
	Set<Appointment> viewAppointments(String patientName) throws AppointmentNotFoundException;
	Appointment viewAppointment(int appointmentId) throws AppointmentNotFoundException;
	Appointment updateAppointment(Appointment appointment) throws AppointmentNotFoundException;
	Appointment removeAppointment(int id);
}
