package com.cg.healthcare;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.healthcare.entities.TestResult;


@SpringBootTest
public class TestResultTesting extends AbstractTest {
	
	TestResult tr = new TestResult(100, 120, "Normal",null);
	
	
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
	public void addresult() throws Exception{
		String uri = "/testresult/addresult";
		String inputJson = super.mapToJson(tr);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		
	}
	
	
	/** 
	 * @throws Exception
	 */
	@Test
	@Order(2)
	public void removeresult() throws Exception{
		String uri = "/testresult/removeresult/46";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.delete(uri))
				.andReturn();
		assertEquals(404, mvcResult.getResponse().getStatus());
	}

}
