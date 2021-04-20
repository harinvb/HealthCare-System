package com.cg.healthcare.loginmodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthcare.dao.UserRepository;
import com.cg.healthcare.dao.ManualQueries.QueryClassPersisitContext;
import com.cg.healthcare.entities.User;
import com.cg.healthcare.exception.UserNotFoundException;

@Service
public class LoginService {
	@Autowired
	private QueryClassPersisitContext qcp;
	
	@Autowired
	private UserRepository uRepo;

	/** 
	 * @param username
	 * @param password
	 * @return Login
	 * @throws UserNotFoundException 
	 * @throws Exception
	 */
	public User loginWithData(String username,String password) throws UserNotFoundException {
		User user;
		user = qcp.findByUserName(username);
		if(user.isLoggedIn())throw new UserNotFoundException("User Already Logged In ");
		if(!user.getPassword().equals(password))throw new UserNotFoundException("Invalid Password");
		user.setLoggedIn(true);
		uRepo.saveAndFlush(user);
		return user;
	}
	
	
	/** 
	 * @return Login
	 * @throws UserNotFoundException 
	 */
	public User logoutPresentUser(String userName) throws UserNotFoundException {
		User user = qcp.findByUserName(userName);
//		if(user.isLoggedIn()) {
			user.setLoggedIn(false);
//		}
//		else {
//			throw new UserNotFoundException("User Not Logged In");
//		}
		
		return uRepo.saveAndFlush(user);
	}
	
	
	/** 
	 * @return boolean
	 */
//	public boolean loginStatus() {
//		return logData.isLoginStatus();
//	}
//	
//	
//	/** 
//	 * @return String
//	 */
//	public String getRole() {
//		return logData.getRole();
//	}
//	
	
}
