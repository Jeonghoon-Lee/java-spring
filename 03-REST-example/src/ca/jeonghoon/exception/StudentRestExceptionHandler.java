package ca.jeonghoon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	// Add an exception handler using @ExceptionHandler
	// It will return Exception message by using StudentErrorResponse class
	// which is a wrapper for http response object
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
		return new ResponseEntity<StudentErrorResponse>(new StudentErrorResponse(HttpStatus.NOT_FOUND.value(),
				exception.getMessage(), System.currentTimeMillis()), HttpStatus.NOT_FOUND);
	}

	// Add a generic exception handler
	// Add a general Exception method to response to response to
	// all other type of exceptions like entering a String for student Id
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {
		// Return ResponseEntity
		return new ResponseEntity<StudentErrorResponse>(new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(),
				exception.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
	}
}
