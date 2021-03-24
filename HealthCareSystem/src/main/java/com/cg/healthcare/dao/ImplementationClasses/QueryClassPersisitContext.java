package com.cg.healthcare.dao.ImplementationClasses;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;

@Repository
public class QueryClassPersisitContext {
	
	@PersistenceContext
	EntityManager eManager;
	
	
	public List<DiagnosticTest> getTestsOfDiagnosticCenter(int centerId){
		
		TypedQuery<DiagnosticTest> exe = eManager.createQuery("select d from DiagnosticTest d join d.diagnosticCenter dc where dc.diagonasticCenterid like :id", DiagnosticTest.class);
		exe.setParameter("id", centerId);
		List<DiagnosticTest> resultList = exe.getResultList();
		return resultList;
	}
	
	public DiagnosticTest removeTestFromDiagnosticCenter(int centerId, DiagnosticTest test) {
		Query qry = eManager.createQuery("select c from DiagnosticCenter c where c.diagonasticCenterid = :id");
		qry.setParameter("id", centerId);
		DiagnosticCenter c = (DiagnosticCenter) qry.getSingleResult();
		EntityTransaction tr = eManager.getTransaction();
		tr.begin();
		c.getTests().remove(test);
		eManager.persist(c);
		tr.commit();
		return test;
	}

	public List<TestResult> getAllTestResult(String patientUserName) {
		TypedQuery<TestResult> qry = eManager.createQuery("select t from TestResult t join t.appointment a where a.patient.name like :n",TestResult.class);
		qry.setParameter("n", patientUserName);
		List<TestResult> tr = qry.getResultList();
		return tr;
	}
	public List<TestResult> viewResultsByPatient(Patient patient){
		TypedQuery<TestResult> qry = eManager.createQuery("select t from TestResult t join t.appointment a where a.patient.id = :id",TestResult.class);
		qry.setParameter("id", patient.getPatientId());
		List<TestResult> tr = qry.getResultList();
		return tr;
	}
}
