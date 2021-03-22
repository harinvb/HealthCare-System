package com.cg.healthcare.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cg.healthcare.entities.Appointment;

public interface IAppointmentRepository extends JpaRepository<Appointment, Integer>{
	
	@Query("select a from appointment a where a.patient.name like :pname")
	Set<Appointment> viewAppointments(@Param("pname") String patientName);
	
//	Appointment addAppointment(Appointment appointment)	throws Exception;
//	Set<Appointment> viewAppointments(String patientName) throws AppointmentNotFoundException;
//	Appointment viewAppointment(int appointmentId) throws AppointmentNotFoundException;
//	Appointment updateAppointment(Appointment appointment) throws AppointmentNotFoundException;
//	Appointment removeAppointment(int id);
}
