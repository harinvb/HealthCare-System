package com.cg.healthcare.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HandleException {
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler({Exception.class,
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
		return new ErrorMapper(uri, msg, new Date());
	}
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.FORBIDDEN)
	@ExceptionHandler({ForBiddenException.class,DataAlreadyExists.class})
	public ErrorMapper handleInvalidConflict(Exception ex, HttpServletRequest req) {
		String msg=ex.getMessage();
		String uri=req.getRequestURL().toString();
		return new ErrorMapper(uri, msg, new Date());
	}
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.EXPECTATION_FAILED)
	@ExceptionHandler({UserCreationError.class})
	public ErrorMapper userCreationConflict(Exception ex, HttpServletRequest req) {
		String msg=ex.getMessage();
		String uri=req.getRequestURL().toString();
		return new ErrorMapper(uri, msg, new Date());
	}
}