package com.cg.healthcare.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.healthcare.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
//	User validateUser(String username, String password) throws Exception;
//	public User addUser(User user);
//	public User removeUser(User user);
}
