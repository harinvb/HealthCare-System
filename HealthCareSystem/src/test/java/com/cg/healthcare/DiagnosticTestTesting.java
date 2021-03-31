package com.cg.healthcare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.healthcare.entities.DiagnosticTest;

@SpringBootTest
public class DiagnosticTestTesting extends AbstractTest{
	
	DiagnosticTest test = new DiagnosticTest("Cell Count", 1220.0,"100","CPM",null);
	
	@Override
	@BeforeEach
	public void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void getalltests() throws Exception {
		String uri = "/DiagnosticTest/getAllTests";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri))
				.andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
	}
	
	@Test
	public void addtest() throws Exception{
		String uri = "/DiagnosticTest/addNewTest";
		String inputJson = super.mapToJson(test);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
	}
	
	
}
