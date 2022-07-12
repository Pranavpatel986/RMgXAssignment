package com.rgmx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rgmx.entity.Asset;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourseNotFoundExceptionHandler(ResourceNotFoundException exception) {
		String message=exception.getMessage();
		ApiResponse apiResponse=new ApiResponse(message ,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
}
