package com.cg.healthcare;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.AppointmentStatus;
import com.cg.healthcare.service.IAppointmentServiceImpl;

@SpringBootTest
public class AppointmentTesting extends AbstractTest{
	
	@Autowired
	IAppointmentServiceImpl  api;
	
	Appointment ap = new Appointment();
	
	
	/** 
	 * @throws Exception
	 */
	@Override
	@BeforeEach
	public void setUp() throws Exception {
		super.setUp();
	}
	
	
	/** 
	 * @throws Exception
	 */
	@Test
	@Order(1)
	public void addAppointmentTest() throws Exception {
		ap.setAppointmentid(100);
		ap.setAppointmentDate(LocalDate.now());
		ap.setApprovalStatus(AppointmentStatus.cancelled);
		String inputJson = mapToJson(ap);
		String uri = "/Appointment/addappointment";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		System.out.println(mvcResult);
		assertEquals(200, mvcResult.getResponse().getStatus());
	}
	
	
	/** 
	 * @throws Exception
	 */
	@Test
	@Order(2)
	public void viewAppByName() throws Exception {
		String uri = "/Appointment/viewappointments/Surya";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri))
				.andReturn();
		System.out.println(mvcResult);
		assertEquals(200, mvcResult.getResponse().getStatus());
	}
	
	
	/** 
	 * @throws Exception
	 */
	@Test
	@Order(3)
	public void viewAppById() throws Exception {
		String uri = "/Appointment/viewappointment/11";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri))
				.andReturn();
		System.out.println(mvcResult);
		assertEquals(200, mvcResult.getResponse().getStatus());
	}
	
	
	
	/** 
	 * @throws Exception
	 */
	@Test
	@Order(4)
	public void updateApp() throws Exception{
		String uri = "/Appointment/updateappointment";
		ap.setApprovalStatus(AppointmentStatus.approved);
		ap.setAppointmentDate(LocalDate.now());
		String inputJson = mapToJson(ap);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		System.out.println(mvcResult);
		assertEquals(404, mvcResult.getResponse().getStatus());
	}
	
	
	/** 
	 * @throws Exception
	 */
	@Test
	@Order(5)
	public void getAppList() throws Exception {
		String uri = "/getappointmentlist/7/Blood Pressure/approved";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri))
				.andReturn();
		System.out.println(mvcResult);
		assertEquals(404, mvcResult.getResponse().getStatus());
	}
	
	
	/** 
	 * @throws Exception
	 */
	@Test
	@Order(6)
	public void deleteApp() throws Exception {
		String uri = "/getappointmentlist/removeappointment";
		String inputJson = mapToJson(ap);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		System.out.println(mvcResult);
		assertEquals(404, mvcResult.getResponse().getStatus());
	}
}
