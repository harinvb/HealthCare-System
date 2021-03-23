package com.cg.healthcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.healthcare.entities.DiagnosticCenter;

public interface IDiagnosticCenterRepositoryInt extends IDiagnosticCenterRepository,JpaRepository<DiagnosticCenter, Integer>{

}
