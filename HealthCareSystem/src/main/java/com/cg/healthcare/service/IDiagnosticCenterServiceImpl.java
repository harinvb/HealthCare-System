package com.cg.healthcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthcare.dao.IDiagnosticCenterRepository;
import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.exception.DiagnosticCenterNotFoundException;
@Service("centerService")
public class IDiagnosticCenterServiceImpl implements IDiagnosticCenterService{
	@Autowired
	IDiagnosticCenterRepository centerDao;
	@Override
	public List<DiagnosticCenter> getAllDiagnosticCenters() {
		
		return centerDao.findAll();
	}

	@Override
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws Exception {
		return centerDao.saveAndFlush(diagnosticCenter);
	}

	@Override
	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId) {
		Optional<DiagnosticCenter> op=centerDao.findById(diagnosticCenterId);
		return op.get();
	}

	@Override
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		return centerDao.saveAndFlush(diagnosticCenter);
	}

	@Override
	public DiagnosticTest viewTestDetails(int diagnosticCenterId, String testName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiagnosticTest addTest(int diagnosticcenterId, int testid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiagnosticCenter getDiagnosticCenter(String centername) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiagnosticCenter removeDiagnosticCenter(int id) throws DiagnosticCenterNotFoundException {
		centerDao.deleteById(id);
		return null;
	}

	@Override
	public List<Appointment> getListOfAppointments(String centerName) {
		// TODO Auto-generated method stub
		return null;
	}

}
