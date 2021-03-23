package com.cg.healthcare.dao;

//import java.util.List;
//import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.DiagnosticCenter;
//import com.cg.healthcare.entities.DiagnosticTest;
//import com.cg.healthcare.exception.DiagnosticCenterNotFoundException;
@Repository
public interface IDiagnosticCenterRepository extends JpaRepository<DiagnosticCenter, Integer>{



//	public List<DiagnosticCenter> getAllDiagnosticCenters();
//	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws Exception;
//	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId);
//	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter);
//	DiagnosticTest viewTestDetails(int diagnosticCenterId,String testName);
//	DiagnosticTest addTest(int diagnosticcenterId, int testid);
//	DiagnosticCenter getDiagnosticCenter(String centername);
//	DiagnosticCenter removeDiagnosticCenter(int id) throws DiagnosticCenterNotFoundException;
//	List<Appointment> getListOfAppointments(String centerName);
}
