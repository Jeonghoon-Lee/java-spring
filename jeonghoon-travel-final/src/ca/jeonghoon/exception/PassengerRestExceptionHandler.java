package ca.jeonghoon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PassengerRestExceptionHandler {

	@ExceptionHandler({PassengerNotFoundException.class})
	public ResponseEntity<PassengerErrorResponse> handleException(PassengerNotFoundException exception) {
		return new ResponseEntity<PassengerErrorResponse>(new PassengerErrorResponse(HttpStatus.NOT_FOUND.value(),
				exception.getMessage(), System.currentTimeMillis()), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({Exception.class})
	public ResponseEntity<PassengerErrorResponse> handleException(Exception exception) {
		// Return ResponseEntity
		return new ResponseEntity<PassengerErrorResponse>(new PassengerErrorResponse(HttpStatus.BAD_REQUEST.value(),
				exception.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
	}
}
