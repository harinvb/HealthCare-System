package com.cg.healthcare;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.healthcare.loginmodule.Login;
import com.cg.healthcare.loginmodule.LoginService;


@SpringBootTest
public class LoggingTest {
	
	@Autowired
	LoginService logserv;
	
	Login log;
	
	@BeforeEach
	public void setUp() throws Exception {
		log =logserv.loginWithData("harih878", "Hari@098");
	}
	
	@Test
	@Order(1)
	void LoginTest() throws Exception {
		assertEquals(logserv.loginStatus(), true);
	}
	
	@Test
	@Order(2)
	void logoutTest() throws Exception{
		logserv.logoutPresentUser();
		assertEquals(log.isLoginStatus(), false);
	}
}
