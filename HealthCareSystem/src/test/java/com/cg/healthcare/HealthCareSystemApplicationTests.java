package com.cg.healthcare;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
@SpringBootTest
class HealthCareSystemApplicationTests extends AbstractTest {


	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}
	@Test
	public void addDiagnosticCenter() throws Exception {
		String uri = "/DiagnosticCenter/addCenter";
		Set<DiagnosticTest> tests = new HashSet<>();
		DiagnosticCenter d = new DiagnosticCenter("hyd", "267276", "1-2-4","example@123.com",tests);
		
		String inputJson = super.mapToJson(d);
		System.out.println("======================="+inputJson+"======================");
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		DiagnosticCenter d1 = super.mapFromJson(content, DiagnosticCenter.class);
		assertEquals("hyd", d1.getName());
		
	}
	@Test
	public void getDiagnosticCenter() throws Exception {
		
		String uri = "/DiagnosticCenter/getDiagnosticCenter/8";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		DiagnosticCenter dc = super.mapFromJson(content, DiagnosticCenter.class);
		assertEquals("vja", dc.getName());
	}
	
	
}
