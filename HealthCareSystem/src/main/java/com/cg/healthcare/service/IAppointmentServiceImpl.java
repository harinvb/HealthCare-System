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
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.exception.DiagnosticCenterNotFoundException;
import com.cg.healthcare.exception.InvalidAppointmentStatusException;
import com.cg.healthcare.exception.PatientNotFoundException;
import com.cg.healthcare.exception.TestResultNotFoundException;

/************************************************************************************
 *@author          	Nalluri Hari Babu
 *@apiNote      	It is a service Implementation class that provides services for
 *					Appointments.
 *@version			1.0
 *@since    		30-MAR-2021
 ************************************************************************************/
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

	
	/** 
	 * Returns The Appointment After Saving.
	 * @param {@link Appointment}
	 * @param patientid
	 * @param diagnosticCenterID
	 * @param testsId
	 * @return {@link Appointment}
	 * @throws DataAlreadyExists
	 * @throws DataNotFoundInDataBase 
	 */
	@Override
	public Appointment addAppointment(Appointment appointment,String patientid,String diagnosticCenterID,List<Integer> testsId) throws DataAlreadyExists, DataNotFoundInDataBase {
		
		if(iar.existsById(appointment.getAppointmentid()))throw new DataAlreadyExists("Appointment Already Exists Use Update To Change");
		
		DiagnosticCenter preDC = new DiagnosticCenter();
		Set<DiagnosticTest> preDTs = new HashSet<>();
		Patient prePatient = new Patient();
		try {
		if(patientid != null) {
			prePatient= patRepo.findById(Integer.parseInt(patientid))
					.orElseThrow(()-> new DataNotFoundInDataBase("Patient Not Found With ID : "+patientid));
			appointment.setPatient(prePatient);
		}
		if(diagnosticCenterID != null) {
			preDC = centerRepo.findById(Integer.parseInt(diagnosticCenterID))
					.orElseThrow(()-> new DataNotFoundInDataBase("Diagnostic Center Not Found With ID : "+diagnosticCenterID));
			appointment.setDiagnosticCenter(preDC);
		}
		if(testsId!=null) {
		for(int id : testsId) {
			DiagnosticTest pretest = testRepo.findById(id)
					.orElseThrow(()-> new DataNotFoundInDataBase("Diagnostic Test Not Found With ID : "+id));
			preDTs.add(pretest);
			pretest.setDiagnosticCenter(preDC);
			testRepo.saveAndFlush(pretest);
		}
		}
		}
		catch(NumberFormatException e) {
			throw new DataNotFoundInDataBase("Please Check The ID's");
		}
		appointment.setDiagnosticTests(preDTs);
		
		preDC.getTests().addAll(preDTs);
		
		iar.saveAndFlush(appointment);
		
		return appointment;
	}

	
	/** 
	 * Returns the same Appointment after Deleting it.
	 * @param {@link Appointment}
	 * @return Appointment
	 * @throws Exception
	 * @return {@link Appointment}
	 * @throws AppointmentNotFoundException 
	 */
	@Override
	public Appointment removeAppointment(Appointment appointment) throws AppointmentNotFoundException{
		if(!iar.existsById(appointment.getAppointmentid())) throw new AppointmentNotFoundException("No Appointment found to remove");
		Appointment app = iar.findById(appointment.getAppointmentid()).get();
		iar.delete(app);
		return app;
	}

	
	
	/** 
	 * Returns The list of Appointments Taken by userName.
	 * @param patientName
	 * @return List<{@link Appointment}>
	 * @throws AppointmentNotFoundException
	 * @throws PatientNotFoundException 
	 */
	@Override
	public List<Appointment> viewAppointments(int patientId) throws AppointmentNotFoundException, PatientNotFoundException {
		List<Appointment> apps =iar.findBypatient(patRepo.findById(patientId)
				.orElseThrow(()->new PatientNotFoundException("No Such Patient")));
		if(apps.size()==0)throw new AppointmentNotFoundException("No Appointments For You Yet");
		return apps;
	}

	
	/** 
	 * Returns Appointment Based on Appointment ID.
	 * @param appointmentId
	 * @return {@link Appointment}
	 * @throws AppointmentNotFoundException 
	 */
	@Override
	public Appointment viewAppointment(int appointmentId) throws AppointmentNotFoundException{
		if(!iar.existsById(appointmentId)) throw new AppointmentNotFoundException("No appointments Found with ID : "+appointmentId );
		return iar.findById(appointmentId).get();
	}

	
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
	@Override
	public Appointment updateAppointment(Appointment appointment,
			List<Integer> testResultId,
			String patientID ,
			String diagnosticCenterID,
			List<Integer> testIds) throws 
	AppointmentNotFoundException,
	PatientNotFoundException, 
	DiagnosticCenterNotFoundException, TestResultNotFoundException, DataNotFoundInDataBase {
		
		if(!iar.existsById(appointment.getAppointmentid())) {
			throw new AppointmentNotFoundException("Appointment Does Not Exist To Update");
		}
		
		if(testResultId!= null) {
			Set<TestResult> tr= appointment.getTestResult();
			for(int i : testResultId) {
				if(testResRepo.existsById(i))tr.add(testResRepo.findById(i).get());
				else throw new TestResultNotFoundException("Test Result Does Not Exist with id : "+i);
			}
				
		}
		try {
			if(patientID != null) {
				Patient prePatient = new Patient();
				prePatient= patRepo.findById(Integer.parseInt(patientID))
						.orElseThrow(()-> new DataNotFoundInDataBase("Patient Not Found With ID : "+patientID));
				appointment.setPatient(prePatient);
			}
			if(diagnosticCenterID != null) {
				DiagnosticCenter preDC = new DiagnosticCenter();
				preDC = centerRepo.findById(Integer.parseInt(diagnosticCenterID))
						.orElseThrow(()-> new DataNotFoundInDataBase("Diagnostic Center Not Found With ID : "+diagnosticCenterID));
				appointment.setDiagnosticCenter(preDC);
			}
			if(testIds!=null) {
			for(int id : testIds) {
				DiagnosticTest pretest = testRepo.findById(id)
						.orElseThrow(()-> new DataNotFoundInDataBase("Diagnostic Test Not Found With ID : "+id));
				appointment.getDiagnosticTests().add(pretest);
			}
		}
		}
		catch(NumberFormatException e) {
			throw new DataNotFoundInDataBase("Please Check The ID's");
		}
		
		
		iar.saveAndFlush(appointment);
		return appointment;
	}

	
	/** 
	 * Get List Of Appointmetns Based on The parameters.
	 * @param centreId
	 * @param test
	 * @param status
	 * @return List<{@link Appointment}>
	 * @throws InvalidAppointmentStatusException
	 * @throws AppointmentNotFoundException 
	 */
	@Override
	public List<Appointment> getApppointmentList(int centreId, String test, String status) 
			throws InvalidAppointmentStatusException, AppointmentNotFoundException {
		AppointmentStatus stat;
		try {
			 stat = AppointmentStatus.valueOf(status);
		}
		catch(Exception e) {
			throw new InvalidAppointmentStatusException("Invaild AppointMent Status"+status);
		}
		List<Appointment> apps = qcp.getAppointmentList(centreId, test,stat);
		if(apps.size() ==0) throw new AppointmentNotFoundException("No Such Appointment Exists");
		return apps;
	}
	
	
	/** 
	 * Returns All Appointments.
	 * @return List<{@link Appointment}>
	 */
	public List<Appointment> get() {
		return iar.findAll();
	}


	@Override
	public Appointment verify(int appointmentID , boolean approved) throws AppointmentNotFoundException {
		Appointment app = iar.findById(appointmentID)
				.orElseThrow(()->new AppointmentNotFoundException("No Appointment with id "+appointmentID));
		if(approved)app.setApprovalStatus(AppointmentStatus.approved);
		else app.setApprovalStatus(AppointmentStatus.cancelled);
		return iar.saveAndFlush(app);
	}
	@Override
	public List<Appointment> verifiable(){
		List<Appointment> vapps =  iar.findAllByapprovalStatus(AppointmentStatus.statusnotapproved);
		return vapps;
	}


	@Override
	public List<Appointment> noTestResults() {
		return iar.findAllBytestResult(null);
	}


	@Override
	public Patient getPatient(int appID) throws PatientNotFoundException {
		return iar.findById(appID).orElseThrow(()->new PatientNotFoundException("No Appointment With Id "+appID)).getPatient();
	}


	@Override
	public TestResult setTestResult(int appointmentId, int testResId) throws AppointmentNotFoundException,TestResultNotFoundException {
		Appointment app = iar.findById(appointmentId)
				.orElseThrow(()->new AppointmentNotFoundException("No Appointment With Id "+appointmentId));
		TestResult tr = testResRepo.findById(testResId)
				.orElseThrow(() -> new TestResultNotFoundException("No TestResult With Id "+testResId));
		app.getTestResult().add(tr);
		tr.setAppointment(app);
		iar.saveAndFlush(app);
		testResRepo.saveAndFlush(tr);
		return tr;
	}


	@Override
	public List<Appointment> getAll() {
		return iar.findAll();
	}




}
