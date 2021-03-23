package com.cg.healthcare.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.AppointmentStatus;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer>{
	
	@Query("select a from Appointment a where a.patient.name like :pname")
	Set<Appointment> viewAppointments(@Param("pname") String patientName);
	
	Appointment getAppointmentByappointmentid(int appointmentId);
	
	@Query("select a from Appointment a join a.diagnosticTests d"
			+ " where a.diagnosticCenter.diagonasticCenterid = :id and d.testName like :test and a.approvalStatus like :status")
	List<Appointment> getAppointmentList(@Param("id") int centreId,@Param("test") String test,@Param("status") AppointmentStatus status);
}
