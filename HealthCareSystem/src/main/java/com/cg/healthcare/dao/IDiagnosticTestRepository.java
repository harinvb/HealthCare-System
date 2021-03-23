package com.cg.healthcare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.healthcare.entities.DiagnosticTest;

public interface IDiagnosticTestRepository extends JpaRepository<DiagnosticTest, Integer> {
//	public List<DiagnosticTest> getAllTest();
//	DiagnosticTest addNewTest(DiagnosticTest test);
//	List<DiagnosticTest> getTestsOfDiagnosticCenter(int centerId) throws Exception;
//	DiagnosticTest updateTestDetail(DiagnosticTest test);
//	DiagnosticTest removeTestFromDiagnosticCenter(int centerId, DiagnosticTest test) throws Exception;

}
