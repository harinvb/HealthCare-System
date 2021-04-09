package com.cg.healthcare.dao;

//import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;
/************************************************************************************
 *@author          	K S S Karthik
 *Description      	It is a Data Access Object Interface that provides methods for Implementation class.  
 *Version          	1.0
 *Created Date    	30-MAR-2021
 ************************************************************************************/
public interface ITestResultRepository extends JpaRepository<TestResult, Integer>{

}
