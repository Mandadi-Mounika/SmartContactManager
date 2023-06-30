package com.cg.contact.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.contact.exception.ImageNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ImageNotFoundException.class)
	public String handleImageNotFoundException(ImageNotFoundException infe) {
		return infe.getMessage();
	}
}
