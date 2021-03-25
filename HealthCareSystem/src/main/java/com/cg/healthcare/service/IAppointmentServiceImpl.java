package com.cg.healthcare.service;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthcare.dao.IAppointmentRepository;
import com.cg.healthcare.dao.ImplementationClasses.QueryClassPersisitContext;
import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.AppointmentStatus;
import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.entities.TestResult;
import com.cg.healthcare.exception.AppointmentNotFoundException;
import com.cg.healthcare.exception.InvalidAppointmentStatusException;


@Service
public class IAppointmentServiceImpl implements IAppointmentService {
	
	@Autowired
	private IAppointmentRepository iar;
	
	@Autowired
	QueryClassPersisitContext qcp;

	@Override
	public Appointment addAppointment(Appointment appointment) throws Exception {
		DiagnosticCenter dc = appointment.getDiagnosticCenter();
		Set<DiagnosticTest> dt  = appointment.getDiagnosticTests();
		dc.setTests(dt);
		for(DiagnosticTest d : dt) {
			d.setDiagnosticCenter(dc);
		}
		for(TestResult t : appointment.getTestResult()) {
			t.setAppointment(appointment);
		}
		iar.saveAndFlush(appointment);
		return appointment;
	}

	@Override
	public Appointment removeAppointment(Appointment appointment) throws Exception {
		iar.delete(appointment);
		return appointment;
	}

	@Override
	public List<Appointment> viewAppointments(String patientName) throws AppointmentNotFoundException {
		List<Appointment> app =qcp.viewAppointments(patientName);
		if(app.size()==0)throw new AppointmentNotFoundException("This Patient Doesn't have Any Exception / The Patient Might Not Exist");
		return app;
	}

	@Override
	public Appointment viewAppointment(int appointmentId){
		return iar.findById(appointmentId).get();
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) throws AppointmentNotFoundException {
		iar.saveAndFlush(appointment);
		return appointment;
	}

	@Override
	public List<Appointment> getApppointmentList(int centreId, String test, String status) throws InvalidAppointmentStatusException {
		AppointmentStatus stat;
		try {
			 stat = AppointmentStatus.valueOf(status);
		}
		catch(Exception e) {
			throw new InvalidAppointmentStatusException("Invaild AppointMent Status"+status);
		}
		
		return qcp.getAppointmentList(centreId, test,stat);
	}
	
	public List<Appointment> get() {
		return iar.findAll();
	}

}
