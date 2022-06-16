package com.api.spring.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResidentExceptionHandler {

	@ExceptionHandler(value= {ResidentExceptionClass.class})
	public ResponseEntity<Object> handleResidentException(ResidentExceptionClass exception){
		
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		
		ResidentException residentException = new ResidentException(
				exception.getMessage(),
				exception,
				HttpStatus.BAD_REQUEST,
				ZonedDateTime.now(ZoneId.of("UTC"))
				);
		
		return new ResponseEntity<>(residentException, badRequest);
	}
	
}
