package com.cg.healthcare.loginmodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthcare.dao.ManualQueries.QueryClassPersisitContext;
import com.cg.healthcare.entities.User;

@Service
public class LoginService {
	@Autowired
	private QueryClassPersisitContext qcp;
	
	private Login logData = new Login();
	
	
	/** 
	 * @param username
	 * @param password
	 * @return Login
	 * @throws Exception
	 */
	public Login loginWithData(String username,String password) throws Exception {
		User user = qcp.findByUserName(username);
		if(!user.getPassword().equals(password))throw new Exception("Login Data Invalid");
		logData.setLoginStatus(true);
		logData.setUser(user);
		return logData;
	}
	
	
	/** 
	 * @return Login
	 */
	public Login logoutPresentUser() {
		if(logData.isLoginStatus()) {
			logData.setLoginStatus(false);
		}
		return logData;
	}
	
	
	/** 
	 * @return boolean
	 */
	public boolean loginStatus() {
		return logData.isLoginStatus();
	}
	
	
	/** 
	 * @return String
	 */
	public String getRole() {
		return logData.getRole();
	}
	
	
}
