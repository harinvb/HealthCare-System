package com.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.healthcare.entities.DiagnosticCenter;

@SpringBootTest
class HealthCareSystemApplicationTests extends AbstractTest {
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	
	/** 
	 * @throws Exception
	 */
	@Test
	public void getDiagnosticCenter() throws Exception {
		String uri = "/DiagnosticCenter/getDiagnosticCenter/2";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		DiagnosticCenter dc = super.mapFromJson(content, DiagnosticCenter.class);
		assertEquals(2, dc.getDiagonasticCenterid());
	}

}
