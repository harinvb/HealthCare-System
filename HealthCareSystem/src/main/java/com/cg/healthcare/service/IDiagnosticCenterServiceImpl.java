package com.cg.healthcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthcare.dao.IAppointmentRepository;
//import com.cg.healthcare.dao.IDiagnosticCenterRepository;
import com.cg.healthcare.dao.IDiagnosticCenterRepositoryInt;
//import com.cg.healthcare.dao.IDiagnosticCenterRepositoryIntImpl;
//import com.cg.healthcare.dao.IDiagnosticTestRepository;
import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.exception.DiagnosticCenterNotFoundException;

public class IDiagnosticCenterServiceImpl implements IDiagnosticCenterService{
	
	
	@Autowired
	IDiagnosticCenterRepositoryInt centerDao;
	@Autowired
	IAppointmentRepository appointmentDao;
	DiagnosticTest test;
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
	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId) {
		Optional<DiagnosticCenter> op=centerDao.findById(diagnosticCenterId);
		return op.get();
	}

	@Override
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		centerDao.saveAndFlush(diagnosticCenter);
		return diagnosticCenter;
	}
	
	@Override
	public DiagnosticTest viewTestDetails(int diagnosticCenterId, String testName) {
		return centerDao.viewTestDetails(diagnosticCenterId, testName);
	}

	@Override
	public DiagnosticTest addTest(int diagnosticcenterId, int testid) {
		test.setDiagonasticTestid(testid);
		test.getDiagnosticCenter().setDiagonasticCenterid(diagnosticcenterId);
		return null;
	}

	@Override
	public DiagnosticCenter getDiagnosticCenter(String centername) {
		return centerDao.getDiagnosticCenter(centername);
	}

	@Override
	public DiagnosticCenter removeDiagnosticCenter(int id) throws DiagnosticCenterNotFoundException {
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
