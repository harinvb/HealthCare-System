package com.cg.healthcare.loginmodule;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthcare.entities.User;

@RestController
@RequestMapping("/")
public class Login {
	
	private boolean loginStatus;
	
	private User user;
	
}
