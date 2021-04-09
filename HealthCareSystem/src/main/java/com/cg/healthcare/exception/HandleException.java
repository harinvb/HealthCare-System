package com.cg.healthcare.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class HandleException {
	
	
	/** 
	 * @param ex
	 * @param req
	 * @return ErrorMapper
	 */
	@ResponseBody
	@ResponseStatus(value=HttpStatus.FORBIDDEN)
	@ExceptionHandler({ForBiddenException.class,DataAlreadyExists.class})
	public ErrorMapper handleInvalidConflict(Exception ex, HttpServletRequest req) {
		String msg=ex.getMessage();
		String uri=req.getRequestURL().toString();
		return new ErrorMapper(uri, msg, new Date(),ex.getClass().getName());
	}
	
	
	/** 
	 * @param ex
	 * @param req
	 * @return ErrorMapper
	 */
	@ResponseBody
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler({UserCreationError.class,ConflictException.class})
	public ErrorMapper userCreationConflict(Exception ex, HttpServletRequest req) {
		String msg=ex.getLocalizedMessage();
		String uri=req.getRequestURL().toString();
		return new ErrorMapper(uri, msg, new Date(),ex.getClass().getName());
	}
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler({InvalidFormatException.class})
	public ErrorMapper inputDataConflict(Exception ex, HttpServletRequest req) {
		String msg="Please Check Input Json Format ex : Date(YYYY-MM-DD), or else check if json is properly parsed";
		String uri=req.getRequestURL().toString();
		return new ErrorMapper(uri, msg, new Date(),ex.getClass().getName());
	}
	
	/** 
	 * @return ErrorMapper
	 */
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler({
		DiagnosticCenterNotFoundException.class,
		PatientNotFoundException.class,
		UserNotFoundException.class,
		TestResultNotFoundException.class,
		DataNotFoundInDataBase.class,
		AppointmentNotFoundException.class,
		InvalidAppointmentStatusException.class
	})
	public ErrorMapper handleConflict(Exception ex, HttpServletRequest req) {
		String msg=ex.getMessage();
		String uri=req.getRequestURL().toString();
		return new ErrorMapper(uri, msg, new Date(),ex.getClass().getName());
	}
	
	

}