package com.cg.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthcare.loginmodule.LoginService;

@RestController
public class LoginController {

	
	@Autowired
	LoginService logServ;
	
	@PostMapping
	public HttpStatus loginUser(String userName , String Password) {
		try {
		logServ.loginWithData(userName, Password);
		}
		catch(Exception e) {
			return HttpStatus.FORBIDDEN;
		}
		return HttpStatus.ACCEPTED;
	}
	
	public boolean loginStatus() {
		return logServ.loginStatus();
	}
	
}
