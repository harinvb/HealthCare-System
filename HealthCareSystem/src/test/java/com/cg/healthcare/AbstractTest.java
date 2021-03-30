package com.cg.healthcare;

import java.io.IOException;
import static org.springframework.test.web.servlet.setup.SharedHttpSessionConfigurer.sharedHttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cg.healthcare.controller.LoginController;
import com.cg.healthcare.entities.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
public abstract class AbstractTest {
	protected MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired
	LoginController logCon;
	
	protected void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(sharedHttpSession()).build();
		logCon.loginUser(new User("harih878","Hari@098","ADMIN"));
	}

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}
}
