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
import com.cg.healthcare.entities.Appointment;
import com.cg.healthcare.entities.DiagnosticCenter;
import com.cg.healthcare.entities.DiagnosticTest;
import com.cg.healthcare.exception.DataNotFoundInDataBase;
import com.cg.healthcare.exception.DiagnosticCenterNotFoundException;
import com.cg.healthcare.exception.ForBiddenException;
import com.cg.healthcare.service.IDiagnosticCenterService;

/****************************
 * @author Sai Pavan Gajjela Description It is a controller class that controls
 *         the data flow into model object and updates the view whenever data
 *         changes Version - 1.0 Created Date -30-MAR-2021
 ****************************/
@RestController
@RequestMapping("/DiagnosticCenter")
public class DiagnosticCenterController {

	@Autowired
	IDiagnosticCenterService centerService;

	@Autowired
	LoginController logCon;

	/**
	 * @return List<DiagnosticCenter>
	 * @throws ForBiddenException
	 */
	@GetMapping("/getDiagnosticCenters")
	public List<DiagnosticCenter> getDiagnosticCenters() throws ForBiddenException {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		if (!logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException("Not An Admin");
		return centerService.getAllDiagnosticCenters();
	}

	/***************************************************************************************************
	 * Method: addDiagnosticCenter Description: It is used to ADD Diagnostic Center
	 * into the DiagnosticCenter Entity table.
	 * 
	 * @param object of Diagnostic Center.
	 * @returns Returns Diagnostic Center with details
	 * @PostMapping: It is used to handle POST type of request method
	 * @RequestBody: It maps the HttpRequest body to a transfer or domain object
	 *               Created By Sai Pavan Gajjela Created Date 30-MAR-2021
	 * 
	 ***************************************************************************************************/
	@PostMapping("/addCenter")
	public DiagnosticCenter addDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter) throws Exception {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		if (!logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException("Not An Admin");
		return centerService.addDiagnosticCenter(diagnosticCenter);

	}

	/***************************************************************************************************
	 * Method: getDiagnosticCenterById Description: It is used to GET Diagnostic
	 * Center by using center Id.
	 * 
	 * @param Diagnostic Center Id.
	 * @returns Diagnostic Center with given center Id.
	 * @GetMapping: Used to handle GET type of request method.
	 * @PathVariable: Used for data passed in the URI and transfer its values to
	 *                parameter variables. Created By Sai Pavan Gajjela Created Date
	 *                30-MAR-2021
	 * 
	 ***************************************************************************************************/
	@GetMapping("/getDiagnosticCenter/{diagnosticCenterId}")

	public DiagnosticCenter getDiagnosticCenterById(@PathVariable int diagnosticCenterId)
			throws DiagnosticCenterNotFoundException, DataNotFoundInDataBase, ForBiddenException {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		if (!logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException("Not An Admin");

		return centerService.getDiagnosticCenterById(diagnosticCenterId);

	}

	/***************************************************************************************************
	 * Method: updateDiagnosticCenter Description: It is used UPDATE Diagnostic
	 * Center details.
	 * 
	 * @param Diagnostic Center object.
	 * @returns Diagnostic Center with with details.
	 * @PutMapping: Used to handle PUT type of request method
	 * @RequestBody: It maps the HttpRequest body to a transfer or domain object
	 *               Created By Sai Pavan Gajjela Created Date 30-MAR-2021
	 * 
	 ***************************************************************************************************/

	@PutMapping("/updateDiagnosticCenter")
	public DiagnosticCenter updateDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter)
			throws DataNotFoundInDataBase, ForBiddenException {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		if (!logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException("Not An Admin");
		return centerService.updateDiagnosticCenter(diagnosticCenter);
	}

	/***************************************************************************************************
	 * Method: viewTestDetails Description: It is used to GET test details by using
	 * center Id, test name.
	 * 
	 * @param Diagnostic center Id.
	 * @param Name       of the test.
	 * @returns Diagnostic Test with given center Id.
	 * @GetMapping: Used to handle GET type of request method.
	 * @PathVariable: Used for data passed in the URI and transfer its values to
	 *                parameter variables. Created By Sai Pavan Gajjela Created Date
	 *                30-MAR-2021
	 * 
	 ***************************************************************************************************/
	@GetMapping("/viewTestDetails/{diagnosticCenterId}/{testName}")
	public DiagnosticTest viewTestDetails(@PathVariable int diagnosticCenterId, @PathVariable String testName)
			throws ForBiddenException {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		if (!logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException("Not An Admin");
		return centerService.viewTestDetails(diagnosticCenterId, testName);
	}

	/***************************************************************************************************
	 * Method: addTest Description: It is used to ADD Test into the DiagnosticCenter
	 * Entity table.
	 * 
	 * @param Diagnostic Center Id.
	 * @param Diagnostic Test Id.
	 * @returns Returns Diagnostic Test with details
	 * @PostMapping: It is used to handle POST type of request method
	 * @PathVariable: Used for data passed in the URI and transfer its values to
	 *                parameter variables. Created By Sai Pavan Gajjela Created Date
	 *                30-MAR-2021
	 * 
	 ***************************************************************************************************/
	@PostMapping("/addTest/{diagnosticcenterId}/{testid}")
	public DiagnosticTest addTest(@PathVariable int diagnosticcenterId, @PathVariable int testid)
			throws DataNotFoundInDataBase, ForBiddenException {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		if (!logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException("Not An Admin");
		return centerService.addTest(diagnosticcenterId, testid);
	}

	/***************************************************************************************************
	 * Method: getDiagnosticCenter Description: It is used to GET Diagnostic Center
	 * by center Name.
	 * 
	 * @param Diagnostic center name.
	 * @returns Diagnostic Center with given center name.
	 * @GetMapping: Used to handle GET type of request method.
	 * @PathVariable: Used for data passed in the URI and transfer its values to
	 *                parameter variables. Created By Sai Pavan Gajjela Created Date
	 *                30-MAR-2021
	 * 
	 ***************************************************************************************************/
	@GetMapping("/getDiagnosticCenterbyname/{centername}")
	public DiagnosticCenter getDiagnosticCenter(@PathVariable String centername)
			throws DataNotFoundInDataBase, ForBiddenException {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		if (!logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException("Not An Admin");
		return centerService.getDiagnosticCenter(centername);
	}

	/***************************************************************************************************
	 * Method: removeDiagnosticCenter Description: It is used to DELETE Diagnostic
	 * Center by center ID.
	 * 
	 * @param Diagnostic center id.
	 * @returns Diagnostic Center with given center id.
	 * @DeleteMapping: Used to handle DELETE type of request method.
	 * @PathVariable: Used for data passed in the URI and transfer its values to
	 *                parameter variables. Created By Sai Pavan Gajjela Created Date
	 *                30-MAR-2021
	 * 
	 ***************************************************************************************************/
	@DeleteMapping("/removeDiagnosticCenter/{id}")
	public DiagnosticCenter removeDiagnosticCenter(@PathVariable int id)
			throws DiagnosticCenterNotFoundException, ForBiddenException {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		if (!logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException("Not An Admin");
		return centerService.removeDiagnosticCenter(id);
	}

	/***************************************************************************************************
	 * Method: getListOfAppointments Description: It is used to GET list of
	 * appointments by center Name.
	 * 
	 * @param Diagnostic center name.
	 * @returns List of Appointments with given center name.
	 * @GetMapping: Used to handle GET type of request method.
	 * @PathVariable: Used for data passed in the URI and transfer its values to
	 *                parameter variables. Created By Sai Pavan Gajjela Created Date
	 *                30-MAR-2021
	 * 
	 ***************************************************************************************************/
	@GetMapping("/appointments/{centerName}")
	public List<Appointment> getListOfAppointments(@PathVariable String centerName) throws ForBiddenException {
		if (!logCon.loginStatus())
			throw new ForBiddenException("Not Logged In");
		if (!logCon.getRole().equalsIgnoreCase("ADMIN"))
			throw new ForBiddenException("Not An Admin");
		return centerService.getListOfAppointments(centerName);
	}

}
