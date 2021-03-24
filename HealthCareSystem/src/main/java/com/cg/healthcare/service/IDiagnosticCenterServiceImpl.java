package com.cg.healthcare.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.healthcare.dao.IAppointmentRepository;
import com.cg.healthcare.dao.IDiagnosticCenterRepositoryInt;
import com.cg.healthcare.dao.TestRepository;
import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.exception.DataNotFoundInDataBase;


@Service
public class IDiagnosticCenterServiceImpl implements IDiagnosticCenterService{
	
	
	@Autowired
	IDiagnosticCenterRepositoryInt centerDao;
	
	@Autowired
	IAppointmentRepository appointmentDao;
	
	@Autowired
	TestRepository test;
	
	@Override
	public List<DiagnosticCenter> getAllDiagnosticCenters() {
		
		return centerDao.findAll();
	}

	@Override
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws Exception {
		centerDao.saveAndFlush(diagnosticCenter);
		return diagnosticCenter;
	}

	@Override
	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId) throws DataNotFoundInDataBase{
		if(!centerDao.existsById(diagnosticCenterId))throw new DataNotFoundInDataBase("Diagnostic Center Not Found");
		return centerDao.findById(diagnosticCenterId).get();
	}

	@Override
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws DataNotFoundInDataBase {
		if(!centerDao.existsById(diagnosticCenter.getDiagonasticCenterid())) throw new DataNotFoundInDataBase("Diagnostic Center Not Found");
		centerDao.saveAndFlush(diagnosticCenter);
		return diagnosticCenter;
	}
	
	@Override
	public DiagnosticTest viewTestDetails(int diagnosticCenterId, String testName) {
		return centerDao.viewTestDetails(diagnosticCenterId, testName);
	}

	@Override
	public DiagnosticTest addTest(int diagnosticcenterId, int testid) throws DataNotFoundInDataBase {
		DiagnosticTest t = test.getOne(testid);
		DiagnosticCenter c = centerDao.getOne(diagnosticcenterId);
		if(t==null || c==null) throw new DataNotFoundInDataBase("Center/test does Not Exist");
		c.getTests().add(t);
		t.setDiagnosticCenter(c);
		test.saveAndFlush(t);
		centerDao.saveAndFlush(c);
		return t;
	}

	@Override
	public DiagnosticCenter getDiagnosticCenter(String centername) throws DataNotFoundInDataBase {
		DiagnosticCenter dc = centerDao.getDiagnosticCenter(centername);
		if(dc==null) throw new DataNotFoundInDataBase("Diagnostic Center Not Found");
		return dc;
	}

	@Override
	public DiagnosticCenter removeDiagnosticCenter(int id) {
		Optional<DiagnosticCenter> op=centerDao.findById(id);
		if(op.isPresent()) {
			centerDao.deleteById(id);
		}
		
		return op.get();
	}

	@Override
	public List<Appointment> getListOfAppointments(String centerName) {
		return appointmentDao.findAll();
	}

}
