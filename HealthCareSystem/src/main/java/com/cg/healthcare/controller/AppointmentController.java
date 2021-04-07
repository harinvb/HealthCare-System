package com.cg.healthcare.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.exception.ForBiddenException;
import com.cg.healthcare.service.IAppointmentService;

@RestController
@RequestMapping("/Appointment")
public class AppointmentController {
	@Autowired
	IAppointmentService appserv;

	@Autowired
	LoginController logCon;

	/**
	 * @param appointment
	 * @param false
	 * @return Appointment
	 */
	@PostMapping(value = "/addappointment")
	public Appointment addAppointment(@RequestBody Appointment appointment,
			@RequestParam(required = false) String patientID, @RequestParam(required = false) String diagnosticCenterID,
			@RequestParam(required = false) List<Integer> testIds) throws Exception {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		return appserv.addAppointment(appointment, patientID, diagnosticCenterID, testIds);
	}

	/**
	 * @param appointment
	 * @return Appointment
	 * @throws Exception
	 */
	@DeleteMapping("/removeappointment")
	public Appointment removeAppointment(@RequestBody Appointment appointment) throws Exception {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		return appserv.removeAppointment(appointment);
	}

	/**
	 * @param patientName
	 * @return List<Appointment>
	 * @throws Exception
	 */
	@GetMapping("/viewappointments/{patientName}")
	public List<Appointment> viewAppointments(@PathVariable String patientName) throws Exception {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		return appserv.viewAppointments(patientName);
	}

	/**
	 * @param appointmentId
	 * @return Appointment
	 * @throws Exception
	 */
	@GetMapping("/viewappointment/{appointmentId}")
	public Appointment viewAppointment(@PathVariable int appointmentId) throws Exception {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		return appserv.viewAppointment(appointmentId);
	}

	/**
	 * @param updateAppointment(
	 * @return Appointment
	 */
	@PutMapping("/updateappointment")
	public Appointment updateAppointment(@RequestBody Appointment appointment,
			@RequestParam(required = false) List<Integer> testResultId,
			@RequestParam(required = false) String patientID, @RequestParam(required = false) String diagnosticCenterID,
			@RequestParam(required = false) List<Integer> testIds) throws Exception {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		return appserv.updateAppointment(appointment, testResultId, patientID, diagnosticCenterID, testIds);
	}

	/**
	 * @param getApppointmentList(
	 * @return List<Appointment>
	 * @throws Exception
	 */
	@GetMapping("/getappointmentlist")
	public List<Appointment> getApppointmentList(@RequestParam String diagnosticCenterid, @RequestParam String testName,
			@RequestParam String appointmentStatus) throws Exception {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		return appserv.getApppointmentList(Integer.parseInt(diagnosticCenterid), testName, appointmentStatus);
	}
}
