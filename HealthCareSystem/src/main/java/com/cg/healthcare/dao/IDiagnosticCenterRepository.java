package com.cg.healthcare.dao;


import java.util.List;

import org.springframework.stereotype.Repository;


//import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
/************************************************************************************
 *@author          	Sai Pavan Gajjela
 *Description      	It is a Data Access Object Interface that provides methods for Implementation class.  
 *Version          	1.0
 *Created Date    	30-MAR-2021
 ************************************************************************************/
@Repository
public interface IDiagnosticCenterRepository{
	List<DiagnosticTest> viewTestDetails(int diagnosticCenterId);
	DiagnosticCenter getDiagnosticCenter(String centername);
}
