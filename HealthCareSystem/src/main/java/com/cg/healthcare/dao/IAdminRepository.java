package com.cg.healthcare.dao;

//import java.util.List;
//import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthcare.entities.User;
@Repository
public interface IAdminRepository extends JpaRepository<User, Integer>{
	
	
	public boolean existsByusername(String username);
	
}