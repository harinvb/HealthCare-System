package com.cg.healthcare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.AppointmentStatus;
import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer>{

	List<Appointment> findBypatient(Patient patient);

	List<Appointment> findAllByapprovalStatus(AppointmentStatus statusnotapproved);

	List<Appointment> findAllBytestResult(TestResult testResult);
	
	
}
