package com.cg.healthcare.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
/************************************************************************************
 *@author          	Sai Pavan Gajjela
 *Description      	It is a Data Access Object Implementation Class implementing Diagnostic Center repository 
 					which is used for writing manual queries.  
 *Version          	1.0
 *Created Date    	30-MAR-2021
 ************************************************************************************/
@Repository
public class IDiagnosticCenterRepositoryIntImpl implements IDiagnosticCenterRepository{
	@PersistenceContext
	EntityManager em;
	/************************************************************************************
	 * Method: 						getDiagnosticCenter
     * Description: 				To get diagnostic Center by center name.
	 * @param centername        	Diagnostic Center Name
	 * @returns						Object of Diagnostic Center
     * Created By                  	Sai Pavan Gajjela
     * Created Date                  30-MAR-2021                           
	 
	 ************************************************************************************/
	@Override
	public DiagnosticCenter getDiagnosticCenter(String centername) {
		TypedQuery<DiagnosticCenter> q=em.createQuery("select s from DiagnosticCenter s where s.name = :name",DiagnosticCenter.class);
		q.setParameter("name", centername);
		return q.getResultList().get(0);	
		}
	/************************************************************************************
	 * Method: 						viewTestDetails
     * Description: 				To get test details based on diagnostic center id and test name.
	 * @param centername        	Diagnostic Center Name
	 * @returns						Object of Diagnostic Center
     * Created By                  	Sai Pavan Gajjela
     * Created Date                  30-MAR-2021                           
	 
	 ************************************************************************************/
	@Override
	public DiagnosticTest viewTestDetails(int diagnosticCenterId, String testName) {
		TypedQuery<DiagnosticTest> q=em.createQuery("select a from DiagnosticTest a join a.diagnosticCenter d "
				+ " where d.diagonasticCenterid = :id and a.testName like :test ",DiagnosticTest.class);
		q.setParameter("id", diagnosticCenterId);
		q.setParameter("test", testName);
		return q.getResultList().get(0);
	}

}
