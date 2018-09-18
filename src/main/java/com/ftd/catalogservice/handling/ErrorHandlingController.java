/**
 * 
 */
package com.ftd.catalogservice.handling;

import java.lang.reflect.InvocationTargetException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * <p>
 * A unified exception handler.
 * </p>
 * 
 * @author Abhishek Mallick
 *
 */

@ControllerAdvice
public class ErrorHandlingController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handleThrowable(Exception ex) {

		ExceptionResponse response = new ExceptionResponse();
		response.setStatusCode(HttpStatus.BAD_REQUEST.value()); 
		response.setMessage("The request could not be understood by the server due to malformed syntax.");

		return new ResponseEntity<ExceptionResponse>(response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
/*
	@ExceptionHandler(value = { AccessDeniedException.class })
	public ResponseEntity<ExceptionResponse> handleAccessDeniedException(AccessDeniedException e) throws Exception {
		
		ExceptionResponse response = new ExceptionResponse();
		response.setStatusCode(HttpStatus.UNAUTHORIZED.value());
		response.setMessage(e.getMessage());
		logger.error(e.getMessage());

		return new ResponseEntity<ExceptionResponse>(response, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
	}*/
	
	@ExceptionHandler(value = { IllegalAccessException.class, InvocationTargetException.class })
	public ResponseEntity<ExceptionResponse> handleIllegalAccessException(IllegalAccessException e, InvocationTargetException e1) {

		ExceptionResponse response = new ExceptionResponse();
		response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage(e.getMessage());
		response.setMessage("Your Request could not fulfilled at this moment.");

		return new ResponseEntity<ExceptionResponse>(response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { NoRecordsFoundException.class })
	public ResponseEntity<ExceptionResponse> handleNoRecordsFoundException(NoRecordsFoundException e) throws Exception {
		
		ExceptionResponse response = new ExceptionResponse();
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setMessage(e.getMessage());
		logger.error(e.getMessage());

		return new ResponseEntity<ExceptionResponse>(response, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}
