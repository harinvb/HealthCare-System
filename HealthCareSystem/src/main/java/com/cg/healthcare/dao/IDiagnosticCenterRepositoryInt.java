package com.cg.healthcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.healthcare.entities.DiagnosticCenter;
/************************************************************************************
 *@author          	Sai Pavan Gajjela
 *Description      	It is a Data Access Object Interface extending both Jpa repository 
 					and diagnostic center repository for using CRUD operations.  
 *Version          	1.0
 *Created Date    	30-MAR-2021
 ************************************************************************************/
public interface IDiagnosticCenterRepositoryInt extends IDiagnosticCenterRepository,JpaRepository<DiagnosticCenter, Integer>{

	
}
