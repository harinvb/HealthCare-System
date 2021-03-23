package com.cg.healthcare.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;

public interface TestRepository extends JpaRepository<DiagnosticTest, Integer>{
//	public DiagnosticTest addTest(DiagnosticTest test);
//	public DiagnosticTest updateTest(DiagnosticTest test);
//	public DiagnosticTest removeTest(DiagnosticTest test);
//	public Set<DiagnosticTest> viewAllTest(DiagnosticTest test);
//	public DiagnosticTest addTestInCenter(DiagnosticCenter center);
}
