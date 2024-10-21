package org.jsp.assign.exceptionHandler;

import org.jsp.assign.exceptionClasses.InvalidEmployeeIdException;
import org.jsp.assign.exceptionClasses.NoEmployeeFoundException;
import org.jsp.assign.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler 
{
	@ExceptionHandler(InvalidEmployeeIdException.class)
	public ResponseEntity<?> invalidEventIdExceptionHandler(InvalidEmployeeIdException e)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).message("Invalid Employee Id").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(NoEmployeeFoundException.class)
	public ResponseEntity<?> noEmployeeFoundExceptionHandler(NoEmployeeFoundException e)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("No Employees Found").body(e.getMessage()).build());
	}
}
