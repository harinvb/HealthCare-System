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
import com.cg.healthcare.exception.DiagnosticCenterNotFoundException;

/************************************************************************************
 *@author          	Sai Pavan Gajjela
 *Description      	It is a service Implementation class that provides services for adding a diagnostic center, 
					removing a diagnostic center, view diagnostic center by name and Id, update diagnostic center details,
					add a test to the diagnostic center, view appointments in a diagnostic center by center name.
 *Version          	1.0
 *Created Date    	30-MAR-2021
 ************************************************************************************/

@Service
public class IDiagnosticCenterServiceImpl implements IDiagnosticCenterService{
	
	
	@Autowired
	IDiagnosticCenterRepositoryInt centerDao;
	
	@Autowired
	IAppointmentRepository appointmentDao;
	
	@Autowired
	TestRepository test;
	
	/************************************************************************************
	 * Method: 						getAllDiagnosticCenters
     * Description: 				To get all diagnostic centers from Data Base.
     * @param						void.
	 * @returns						list of diagonasticCenters.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                 30-MAR-2021                            
	 ************************************************************************************/
	@Override
	public List<DiagnosticCenter> getAllDiagnosticCenters() {
		
		return centerDao.findAll();
	}
	/************************************************************************************
	 * Method: 						addDiagnosticCenter
     * Description: 				To add diagnostic center to the Data Base.
     * @param						object of DiagnosticCenter.
	 * @returns						Diagnostic Center.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                 30-MAR-2021                            
	 ************************************************************************************/
	@Override
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws Exception {
		if(centerDao.existsById(diagnosticCenter.getDiagonasticCenterid())){
			throw new Exception("Diagnostic Center with given Id already exists.");
		}
		else
		centerDao.saveAndFlush(diagnosticCenter);
		return diagnosticCenter;
	}
	/************************************************************************************
	 * Method: 						getDiagnosticCenterById
     * Description: 				To get diagnostic center by center Id from the Data Base.
     * @param						diagnostic center Id.
	 * @returns						Diagnostic Center.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                 30-MAR-2021                            
	 ************************************************************************************/

	@Override
	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId) throws DataNotFoundInDataBase{
		if(!centerDao.existsById(diagnosticCenterId))throw new DataNotFoundInDataBase("Diagnostic Center Not Found");
		return centerDao.findById(diagnosticCenterId).get();
	}
	
	/************************************************************************************
	 * Method: 						updateDiagnosticCenter
     * Description: 				To update diagnostic center details into the Data Base.
     * @param						object of DiagnosticCenter.
	 * @returns						Diagnostic Center.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                 30-MAR-2021                            
	 ************************************************************************************/
	@Override
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws DataNotFoundInDataBase {
		if(!centerDao.existsById(diagnosticCenter.getDiagonasticCenterid())) throw new DataNotFoundInDataBase("Diagnostic Center Not Found");
		centerDao.saveAndFlush(diagnosticCenter);
		return diagnosticCenter;
	}
	/************************************************************************************
	 * Method: 						viewTestDetails
     * Description: 				To view test details by center id and test name from the Data Base 
      								present in that diagnostic center.
     * @param						diagnostic center Id
     * @param						Test name.
	 * @returns						Diagnostic Test.
     * Created By                   Sai Pavan Gajjela
     * Created Date                 30-MAR-2021                            
	 ************************************************************************************/
	
	@Override
	public List<DiagnosticTest> viewTestDetails(int diagnosticCenterId) {
		return centerDao.viewTestDetails(diagnosticCenterId);
	}
	/************************************************************************************
	 * Method: 						addTest
     * Description: 				To add test into a diagnostic center in the Data Base.
     * @param						diagnostic center id.
     * @param						test id.
	 * @returns						Diagnostic Test.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                 30-MAR-2021                            
	 ************************************************************************************/
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
	/************************************************************************************
	 * Method: 						getDiagnosticCenter
     * Description: 				To get diagnostic center details by center name from the Data Base.
     * @param						diagnostic center name.
	 * @returns						Diagnostic Center.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                 30-MAR-2021                            
	 ************************************************************************************/

	@Override
	public DiagnosticCenter getDiagnosticCenter(String centername) throws DataNotFoundInDataBase {
		DiagnosticCenter dc = centerDao.getDiagnosticCenter(centername);
		if(dc==null) throw new DataNotFoundInDataBase("Diagnostic Center Not Found");
		return dc;
	}
	/************************************************************************************
	 * Method: 						removeDiagnosticCenter
     * Description: 				To remove diagnostic center by center Id from the Data Base.
     * @param 						diagnostic center Id.
	 * @returns						Diagnostic Center.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                 30-MAR-2021                            
	 ************************************************************************************/

	@Override
	public DiagnosticCenter removeDiagnosticCenter(int id) throws DiagnosticCenterNotFoundException{
		Optional<DiagnosticCenter> op=centerDao.findById(id);
		if(op.isPresent()) {
			centerDao.deleteById(id);
			return op.get();
		}
		else throw new DiagnosticCenterNotFoundException("Diagnostic Center with given Id doesn't exist.");
		
	}
	/************************************************************************************
	 * Method: 						getListOfAppointments
     * Description: 				To get list of appointments by diagnostic center name from the Data Base.
     * @param						Diagnostic center name.
	 * @returns						List of appointments.
     * Created By                  	Sai Pavan Gajjela
     * Created Date                 30-MAR-2021                            
	 ************************************************************************************/

	@Override
	public List<Appointment> getListOfAppointments(String centerName) {
		return appointmentDao.findAll();
	}

}
