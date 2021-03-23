package com.cg.healthcare.dao;

//import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;

public interface TestRepository extends JpaRepository<DiagnosticTest, Integer>{

}
