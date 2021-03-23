package com.cg.healthcare.dao;

//import java.util.List;
//import java.util.Set;


import org.springframework.stereotype.Repository;


//import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
//import com.cg.healthcare.entities.DiagnosticTest;
//import com.cg.healthcare.exception.DiagnosticCenterNotFoundException;
@Repository
public interface IDiagnosticCenterRepository{
	DiagnosticTest viewTestDetails(int diagnosticCenterId,String testName);
	DiagnosticCenter getDiagnosticCenter(String centername);
}
