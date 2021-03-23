package com.cg.healthcare.dao;

//import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.cg.healthcare.entities.Patient;
import com.cg.healthcare.entities.TestResult;

public interface ITestResultRepository extends JpaRepository<TestResult, Integer>{

}
