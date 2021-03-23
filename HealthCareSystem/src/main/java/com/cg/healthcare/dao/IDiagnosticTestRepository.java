package com.cg.healthcare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.healthcare.entities.DiagnosticTest;

public interface IDiagnosticTestRepository extends JpaRepository<DiagnosticTest, Integer> {
}
