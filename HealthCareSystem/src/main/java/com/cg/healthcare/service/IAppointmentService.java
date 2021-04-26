package com.cg.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;
import com.cg.healthcare.exception.AppointmentNotFoundException;
import com.cg.healthcare.exception.DataAlreadyExists;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.exception.DiagnosticCenterNotFoundException;
import com.cg.healthcare.exception.InvalidAppointmentStatusException;
import com.cg.healthcare.exception.PatientNotFoundException;
import com.cg.healthcare.exception.TestResultNotFoundException;

/************************************************************************************
 *@author          	Nalluri Hari Babu
 *@apiNote      	It is a service Interface that provides services for
 *					Appointments.
 *@version			1.0
 *@since    		30-MAR-2021
 ************************************************************************************/
@Service
public interface IAppointmentService {
	/** 
	 * Returns The Appointment After Saving.
	 * @param appointment
	 * @param patientid
	 * @param diagnosticCenterID
	 * @param testsId
	 * @return Appointment
	 * @throws DataAlreadyExists
	 * @throws DataNotFoundInDataBase 
	 */
	Appointment addAppointment(Appointment appointment, String patientID, String diagnosticCenterID,List<Integer> testsId)	throws DataAlreadyExists, DataNotFoundInDataBase;
	
	
	/** 
	 * Returns the same Appointment after Deleting it.
	 * @param {@link Appointment}
	 * @return Appointment
	 * @throws Exception
	 * @return {@link Appointment}
	 * @throws AppointmentNotFoundException 
	 */
	Appointment removeAppointment(Appointment appointment) throws AppointmentNotFoundException;
	
	/** 
	 * Returns The list of Appointments Taken by userName.
	 * @param patientId
	 * @return List<{@link Appointment}>
	 * @throws AppointmentNotFoundException
	 * @throws PatientNotFoundException 
	 */
	List<Appointment> viewAppointments(int patientId) throws AppointmentNotFoundException, PatientNotFoundException;
	
	/** 
	 * Returns Appointment Based on Appointment ID.
	 * @param appointmentId
	 * @return {@link Appointment}
	 */
	Appointment viewAppointment(int appointmentId) throws AppointmentNotFoundException;
	
	/** 
	 * Updates The Existing Appointment with new Details.
	 * @param appointment
	 * @param testResultId
	 * @param patientID
	 * @param diagnosticCenterID
	 * @param testIds
	 * @return {@link Appointment}
	 * @throws AppointmentNotFoundException
	 * @throws PatientNotFoundException
	 * @throws DiagnosticCenterNotFoundException
	 * @throws TestResultNotFoundException
	 * @throws DataNotFoundInDataBase 
	 */
	Appointment updateAppointment(Appointment appointment, List<Integer> testResultId,String patientID , 
			String diagnosticCenterID, List<Integer> testIds) throws AppointmentNotFoundException, PatientNotFoundException, DiagnosticCenterNotFoundException, TestResultNotFoundException, DataNotFoundInDataBase ;
	
	/** 
	 * Get List Of Appointmetns Based on The parameters.
	 * @param centreId
	 * @param test
	 * @param status
	 * @return List<{@link Appointment}>
	 * @throws AppointmentNotFoundException 
	 * @throws InvalidAppointmentStatusException
	 */
	List<Appointment> getApppointmentList(int centreId, String test, String status) throws InvalidAppointmentStatusException, AppointmentNotFoundException;
	
	 Appointment verify( int appointmentID , boolean approved) throws AppointmentNotFoundException;


	List<Appointment> verifiable();


	List<Appointment> noTestResults();


	Patient getPatient(int appID) throws PatientNotFoundException;


	TestResult setTestResult(int appointmentId, int testResId) throws AppointmentNotFoundException, TestResultNotFoundException;


	List<Appointment> getAll();
	



}
