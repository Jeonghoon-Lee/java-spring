package ca.jeonghoon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exception) {
		return new ResponseEntity<CustomerErrorResponse>(new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),
				exception.getMessage(), System.currentTimeMillis()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exception) {
		// Return ResponseEntity
		return new ResponseEntity<CustomerErrorResponse>(new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),
				exception.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
	}
}
