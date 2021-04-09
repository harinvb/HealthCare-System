package com.cg.healthcare.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.healthcare.entities.DiagnosticTest;

@Repository
public interface TestRepository extends JpaRepository<DiagnosticTest, Integer>{

}
