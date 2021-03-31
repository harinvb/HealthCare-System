package com.cg.healthcare.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.healthcare.entities.User;
import com.cg.healthcare.loginmodule.LoginService;

@RestController
public class LoginController {

	
	@Autowired
	LoginService logServ;
	
	
	/** 
	 * @param user
	 * @return HttpStatus
	 */
	@PostMapping
	public HttpStatus loginUser(@RequestBody User user) {
		try {
		logServ.loginWithData(user.getUsername(), user.getPassword());
		}
		catch(Exception e) {
			return HttpStatus.FORBIDDEN;
		}
		return HttpStatus.ACCEPTED;
	}
	
	
	/** 
	 * @return HttpStatus
	 * @throws Exception
	 */
	@PostMapping("/Logout")
	public HttpStatus logOut() throws Exception {
		if(this.loginStatus()) {
			logServ.logoutPresentUser();
			return HttpStatus.ACCEPTED;
		}
		else {
			throw new Exception("User Not yet Logged In");
		}
	}
	
	/** 
	 * @return boolean
	 */
	public boolean loginStatus() {
		return logServ.loginStatus();
	}
	
	
	/** 
	 * @return String
	 */
	public String getRole() {
		return logServ.getRole();
	}
	
}
