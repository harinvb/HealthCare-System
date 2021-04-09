package com.cg.healthcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.healthcare.entities.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer>{

	
	
	
}
