package com.cg.healthcare.loginmodule;

import org.springframework.stereotype.Component;

import com.cg.healthcare.entities.User;

@Component
public class Login {
	
	private boolean loginStatus;
	
	private User user;
	
	Login(){
		
	}
	
	

	public Login(boolean loginStatus, User user) {
		super();
		this.loginStatus = loginStatus;
		this.user = user;
	}



	public boolean isLoginStatus() {
		return loginStatus;
	}



	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}

	
	public String getRole() {
		return user.getRole();
	}
	
	
}
