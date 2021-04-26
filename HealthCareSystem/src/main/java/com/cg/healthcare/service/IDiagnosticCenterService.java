package com.cg.healthcare.service;

import java.util.List;


import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.exception.DiagnosticCenterNotFoundException;
/************************************************************************************
 *@author          	Sai Pavan Gajjela
 *Description      	It is a service Interface that provides methods for Implementation class.  
 *Version          	1.0
 *Created Date    	30-MAR-2021
 ************************************************************************************/

public interface IDiagnosticCenterService {

	public List<DiagnosticCenter> getAllDiagnosticCenters();
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws Exception;
	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId) throws DataNotFoundInDataBase;
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws DataNotFoundInDataBase;
	List<DiagnosticTest> viewTestDetails(int diagnosticCenterId);
	DiagnosticTest addTest(int diagnosticcenterId, int testid) throws DataNotFoundInDataBase;
	DiagnosticCenter getDiagnosticCenter(String centername) throws DataNotFoundInDataBase;
	DiagnosticCenter removeDiagnosticCenter(int id) throws DiagnosticCenterNotFoundException;
	List<Appointment> getListOfAppointments(String centerName);

}