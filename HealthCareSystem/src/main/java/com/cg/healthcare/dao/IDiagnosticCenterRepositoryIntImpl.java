package com.cg.healthcare.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;

public class IDiagnosticCenterRepositoryIntImpl implements IDiagnosticCenterRepository{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public DiagnosticCenter getDiagnosticCenter(String centername) {
		TypedQuery<DiagnosticCenter> q=em.createQuery("select s from DiagnosticCenter s where s.name like :name",DiagnosticCenter.class);
		q.setParameter("name", centername);
		return q.getResultList().get(0);	
		}
	@Override
	public DiagnosticTest viewTestDetails(int diagnosticCenterId, String testName) {
		TypedQuery<DiagnosticTest> q=em.createQuery("select a from DiagnosticTest a join a.diagnosticCenter d join d.tests t "
				+ " where d.diagonasticCenterid = :id and t.testName like :test ",DiagnosticTest.class);
		q.setParameter("id", diagnosticCenterId);
		q.setParameter("test", testName);
		return q.getResultList().get(0);
	}

}
