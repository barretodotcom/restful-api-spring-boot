package com.api.spring.exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ResidentException {
	
	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpstatus;
	private final ZonedDateTime zonedDateTime;
	
}