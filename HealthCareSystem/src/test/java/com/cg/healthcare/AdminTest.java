package com.cg.healthcare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.healthcare.entities.User;


@SpringBootTest
public class AdminTest extends AbstractTest{
	
	
	/** 
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		super.setUp();
	}
	
	/** 
	 * @throws Exception
	 */
	
	@Test
	public void regAdmin() throws Exception {
		String uri = "/admin/registeradmin";
		User user = new User("anony","anony","");
		String inputJson = super.mapToJson(user);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		assertEquals(201, mvcResult.getResponse().getStatus());
	}
}
