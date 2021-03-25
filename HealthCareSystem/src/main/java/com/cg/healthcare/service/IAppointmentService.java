package com.cg.healthcare.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.exception.AppointmentNotFoundException;


@Service
public interface IAppointmentService {
	
	Appointment addAppointment(Appointment appointment, String patientID, String diagnosticCenterID,List<Integer> testsId)	throws Exception;
	Appointment removeAppointment(Appointment appointment)	throws Exception;
	List<Appointment> viewAppointments(String patientName) throws AppointmentNotFoundException;
	Appointment viewAppointment(int appointmentId) throws AppointmentNotFoundException;
	Appointment updateAppointment(Appointment appointment, List<Integer> testResultId,String patientID , String diagnosticCenterID, List<Integer> testIds) throws AppointmentNotFoundException;
	List<Appointment> getApppointmentList(int centreId, String test, String status) throws Exception;


}
