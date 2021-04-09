package com.cg.healthcare.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.healthcare.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public boolean existsByusername(String username);
}
