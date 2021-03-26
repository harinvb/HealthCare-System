package com.cg.healthcare;

import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.DiagnosticCenter;

@SpringBootTest
class HealthCareSystemApplicationTests extends AbstractTest {
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	/*
	 * @Test public void addDiagnosticCenter() throws Exception { String uri =
	 * "/DiagnosticCenter/addCenter"; Set<DiagnosticTest> tests = new HashSet<>();
	 * DiagnosticCenter d = new DiagnosticCenter("hyd", "267276", "1-2-4",
	 * "example@123.com", tests);
	 * 
	 * String inputJson = super.mapToJson(d);
	 * System.out.println("=======================" + inputJson +
	 * "======================"); MvcResult mvcResult = mvc.perform(
	 * MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE
	 * ).content(inputJson)) .andReturn();
	 * 
	 * int status = mvcResult.getResponse().getStatus(); assertEquals(200, status);
	 * String content = mvcResult.getResponse().getContentAsString();
	 * DiagnosticCenter d1 = super.mapFromJson(content, DiagnosticCenter.class);
	 * assertEquals("hyd", d1.getName());
	 * 
	 * }
	 */

	@Test
	public void getDiagnosticCenterById() throws Exception {

		String uri = "/DiagnosticCenter/getDiagnosticCenter/8";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		DiagnosticCenter dc = super.mapFromJson(content, DiagnosticCenter.class);
		assertEquals("vja", dc.getName());
	}

	@Test
	public void getDiagnosticCenters() throws Exception {
		String uri = "/DiagnosticCenter/getDiagnosticCenters";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		DiagnosticCenter dc[] = super.mapFromJson(content, DiagnosticCenter[].class);
		assertEquals("vja", dc[1].getName());
	}

	
	/*
	 * @Test public void removeDiagnosticCenter() throws Exception { String uri =
	 * "/DiagnosticCenter/removeDiagnosticCenter/18"; MvcResult mvcResult =
	 * mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn(); int status =
	 * mvcResult.getResponse().getStatus(); assertEquals(200, status); String
	 * content = mvcResult.getResponse().getContentAsString(); DiagnosticCenter dc =
	 * super.mapFromJson(content, DiagnosticCenter.class); assertEquals("hyd",
	 * dc.getName()); }
	 */

	@Test
	public void getDiagnosticCenter() throws Exception {
		String uri = "/DiagnosticCenter/getDiagnosticCenterbyname/hyd";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		DiagnosticCenter dc = super.mapFromJson(content, DiagnosticCenter.class);
		assertEquals("hyd", dc.getName());
	}

	@Test
	public void getListOfAppointments() throws Exception {
		String uri = "/DiagnosticCenter/appointments/hyd";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Appointment ap[] = super.mapFromJson(content, Appointment[].class);
		assertEquals("approved", ap[0].getApprovalStatus().getStatus());
	}

}
