package com.cg.healthcare.service;

import java.util.List;


import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.exception.DiagnosticCenterNotFoundException;

public interface IDiagnosticCenterService {

	public List<DiagnosticCenter> getAllDiagnosticCenters();
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws Exception;
	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId);
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter);
	DiagnosticTest viewTestDetails(int diagnosticCenterId,String testName);
	DiagnosticTest addTest(int diagnosticcenterId, int testid);
	DiagnosticCenter getDiagnosticCenter(String centername);
	DiagnosticCenter removeDiagnosticCenter(int id) throws DiagnosticCenterNotFoundException;
	List<Appointment> getListOfAppointments(String centerName);

}