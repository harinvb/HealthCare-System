package com.cg.healthcare.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.healthcare.dao.IAppointmentRepository;
import com.cg.healthcare.dao.IDiagnosticCenterRepositoryInt;
import com.cg.healthcare.dao.IDiagnosticTestRepository;
import com.cg.healthcare.dao.IPatientRepository;
import com.cg.healthcare.dao.ITestResultRepository;
import com.cg.healthcare.dao.ManualQueries.QueryClassPersisitContext;
import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.AppointmentStatus;
import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;
import com.cg.healthcare.exception.AppointmentNotFoundException;
import com.cg.healthcare.exception.DataAlreadyExists;
import com.cg.healthcare.exception.DiagnosticCenterNotFoundException;
import com.cg.healthcare.exception.InvalidAppointmentStatusException;
import com.cg.healthcare.exception.PatientNotFoundException;
import com.cg.healthcare.exception.TestResultNotFoundException;


@Service
public class IAppointmentServiceImpl implements IAppointmentService {
	
	@Autowired
	private IAppointmentRepository iar;
	
	@Autowired
	IPatientRepository patRepo;
	
	@Autowired
	IDiagnosticCenterRepositoryInt centerRepo;
	
	@Autowired
	IDiagnosticTestRepository testRepo;
	
	@Autowired
	ITestResultRepository testResRepo;
	
	@Autowired
	QueryClassPersisitContext qcp;

	@Override
	public Appointment addAppointment(Appointment appointment,String patientid,String diagnosticCenterID,List<Integer> testsId) throws DataAlreadyExists {
		
		if(iar.existsById(appointment.getAppointmentid()))throw new DataAlreadyExists("Appointment Already Exists Use Update To Change");
		
		DiagnosticCenter preDC = new DiagnosticCenter();
		
		Patient prePatient = new Patient();
		
		if(patientid != null) {
			prePatient= patRepo.getOne(Integer.parseInt(patientid));
			appointment.setPatient(prePatient);
		}
		
		if(diagnosticCenterID != null) {
			preDC = centerRepo.getOne(Integer.parseInt(diagnosticCenterID));
			appointment.setDiagnosticCenter(preDC);
		}
		
		Set<DiagnosticTest> preDTs = new HashSet<>();
		if(testsId!=null) {
		for(int id : testsId) {
			DiagnosticTest pretest = testRepo.getOne(id);
			preDTs.add(pretest);
			pretest.setDiagnosticCenter(preDC);
			testRepo.saveAndFlush(pretest);
		}
		
		}
		
		appointment.setDiagnosticTests(preDTs);
		
		preDC.getTests().addAll(preDTs);
		
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
		if(app.size()==0)throw new AppointmentNotFoundException("This Patient Doesn't have Any Appointment / The Patient Might Not Exist");
		return app;
	}

	@Override
	public Appointment viewAppointment(int appointmentId){
		return iar.findById(appointmentId).get();
	}

	@Override
	public Appointment updateAppointment(Appointment appointment,
			List<Integer> testResultId,
			String patientID ,
			String diagnosticCenterID,
			List<Integer> testIds) throws 
	AppointmentNotFoundException,
	PatientNotFoundException, 
	DiagnosticCenterNotFoundException, TestResultNotFoundException {
		
		if(testResultId!= null) {
			
			Set<TestResult> tr= appointment.getTestResult();
			
			for(int i : testIds) {
				if(testResRepo.existsById(i))tr.add(testResRepo.findById(i).get());
				else throw new TestResultNotFoundException("Test Result Does Not Exist with id : "+i);
			}
			
				tr.addAll(testResRepo.findAllById(testResultId));
				
		}
		DiagnosticCenter preDC = new DiagnosticCenter();
		
		Patient prePatient = new Patient();
		
		if(patientID != null) {
			if(!patRepo.existsById(Integer.parseInt(patientID))) throw new PatientNotFoundException("Patient Does Not Exist with id :"+patientID);
			prePatient= patRepo.getOne(Integer.parseInt(patientID));
			appointment.setPatient(prePatient);
		}
		
		if(diagnosticCenterID != null) {
			if(!centerRepo.existsById(Integer.parseInt(diagnosticCenterID))) throw new DiagnosticCenterNotFoundException("Diagnostic Center Does Not Exist with id :"+diagnosticCenterID);
			preDC = centerRepo.getOne(Integer.parseInt(diagnosticCenterID));
			appointment.setDiagnosticCenter(preDC);
		}
		
		Set<DiagnosticTest> preDTs = new HashSet<>();
		if(testIds!=null) {
		for(int id : testIds) {
			DiagnosticTest pretest = testRepo.getOne(id);
			preDTs.add(pretest);
			pretest.setDiagnosticCenter(preDC);
			testRepo.saveAndFlush(pretest);
		}
		
		}
		
		appointment.setDiagnosticTests(preDTs);
		
		preDC.getTests().addAll(preDTs);
		
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
