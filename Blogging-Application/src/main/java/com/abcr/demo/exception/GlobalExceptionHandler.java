package com.abcr.demo.exception;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.abcr.demo.pojo.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		
		String message = ex.getMessage();
		ApiResponse apiresponse = new ApiResponse(message,false);
		
		return new ResponseEntity<ApiResponse>(apiresponse , HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ApiResponse> ConstraintViolationExceptionhandler(ConstraintViolationException cv){
		String message = cv.getMessage();
		ApiResponse apiresponse = new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiresponse , HttpStatus.NOT_ACCEPTABLE);
	}
	
//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<Map<String, String>> ConstraintViolationExceptionhandler(ConstraintViolationException cv){
//		Map<String, String> resp = new HashMap<>();
//		cv.getConstraintViolations()
//	}
}
