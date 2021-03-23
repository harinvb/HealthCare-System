package com.cg.healthcare.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.healthcare.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByusername(String username);
}
