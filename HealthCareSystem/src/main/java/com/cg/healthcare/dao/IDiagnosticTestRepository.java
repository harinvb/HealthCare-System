package com.cg.healthcare.dao;



import org.springframework.data.jpa.repository.JpaRepository;
/************************************************************************************
 *@author          	K S S Karthik
 *Description      	It is a Data Access Object Interface that provides methods for Implementation class.  
 *Version          	1.0
 *Created Date    	30-MAR-2021
 ************************************************************************************/
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.healthcare.entities.DiagnosticTest;


@Repository
public interface IDiagnosticTestRepository extends JpaRepository<DiagnosticTest, Integer> {
	
}
