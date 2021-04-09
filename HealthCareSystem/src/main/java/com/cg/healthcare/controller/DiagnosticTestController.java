package com.cg.healthcare.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.exception.ForBiddenException;
import com.cg.healthcare.service.IDiagnosticTestService;
/****************************
 * @author			K S S Karthik
 * Description     	It is a controller class that controls the data flow into model object 
                   	and updates the view whenever data changes
 * Version          - 1.0
 * Created Date     -30-MAR-2021
 ****************************/

@RestController
@RequestMapping("/DiagnosticTest")
public class DiagnosticTestController {
	@Autowired
	IDiagnosticTestService dtestService;
	
	@Autowired
	LoginController logCon;
	
	
	/** 
	 * @return List<DiagnosticTest>
	 * @throws Exception
	 */
	@GetMapping("/getAllTests")
	public List<DiagnosticTest> getAllTest() throws Exception{
		if(!logCon.loginStatus()) throw new ForBiddenException("Not Logged In");
		return dtestService.getAllTest();
	}
	
	/** 
	 * @param test
	 * @return DiagnosticTest
	 * @throws Exception
	 */
	@PostMapping("/addNewTest")
	public DiagnosticTest addNewTest(@RequestBody DiagnosticTest test) throws Exception {
		if(!logCon.loginStatus()) throw new ForBiddenException("Not Logged In");
		if(!logCon.getRole().equalsIgnoreCase("ADMIN")) throw new ForBiddenException("Not An Admin");
		return dtestService.addNewTest(test);
	}
	
	/** 
	 * @param centerId
	 * @return List<DiagnosticTest>
	 * @throws Exception
	 */
	@GetMapping("/getTestofDiagnosticCenter/{centerId}")
	public List<DiagnosticTest> getTestsOfDiagnosticCenter(@PathVariable int centerId) throws Exception{
		if(!logCon.loginStatus()) throw new ForBiddenException("Not Logged In");
		try {
			dtestService.getTestsOfDiagnosticCenter(centerId);
		}
		catch(Exception e){
			throw new DataNotFoundInDataBase("Diagnostic center with given id not found");
		}
		return dtestService.getTestsOfDiagnosticCenter(centerId);
	}
	
	/** 
	 * @param test
	 * @return DiagnosticTest
	 * @throws DataNotFoundInDataBase
	 * @throws ForBiddenException
	 */
	@PutMapping("/updateTestDetail")
	public DiagnosticTest updateTestDetail(@RequestBody DiagnosticTest test) throws DataNotFoundInDataBase, ForBiddenException {
		if(!logCon.loginStatus()) throw new ForBiddenException("Not Logged In");
		if(!logCon.getRole().equalsIgnoreCase("ADMIN")) throw new ForBiddenException("Not An Admin");
		return dtestService.updateTestDetail(test);
		
	}
	
	/** 
	 * @param centerId
	 * @param test
	 * @return DiagnosticTest
	 * @throws Exception
	 */
	@DeleteMapping("/removeTest/{centerId}/{test}")
	public DiagnosticTest removeTestFromDiagnosticCenter(@PathVariable int centerId,@PathVariable int test) throws Exception{
		if(!logCon.loginStatus()) throw new ForBiddenException("Not Logged In");
		if(!logCon.getRole().equalsIgnoreCase("ADMIN")) throw new ForBiddenException("Not An Admin");
		return dtestService.removeTestFromDiagnosticCenter(centerId, test);
	}
}
