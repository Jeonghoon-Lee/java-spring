package ca.jeonghoon.exception;

public class PassengerNotFoundException extends RuntimeException {

	public PassengerNotFoundException() {
	}

	public PassengerNotFoundException(String message) {
		super(message);
	}

	public PassengerNotFoundException(Throwable cause) {
		super(cause);
	}

	public PassengerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PassengerNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
