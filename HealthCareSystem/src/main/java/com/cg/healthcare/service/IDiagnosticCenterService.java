package com.cg.healthcare.service;

import java.util.List;


import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.exception.DataNotFoundInDataBase;

public interface IDiagnosticCenterService {

	public List<DiagnosticCenter> getAllDiagnosticCenters();
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws Exception;
	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId) throws DataNotFoundInDataBase;
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws DataNotFoundInDataBase;
	DiagnosticTest viewTestDetails(int diagnosticCenterId,String testName);
	DiagnosticTest addTest(int diagnosticcenterId, int testid) throws DataNotFoundInDataBase;
	DiagnosticCenter getDiagnosticCenter(String centername) throws DataNotFoundInDataBase;
	DiagnosticCenter removeDiagnosticCenter(int id);
	List<Appointment> getListOfAppointments(String centerName);

}