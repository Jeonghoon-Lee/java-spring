package ca.jeonghoon.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Flight {
	private String from;
	private LocalDate departureDate;
	private LocalTime departureTime;
	
	private String to;
	private LocalDate destinationDate;
	private LocalTime destinationTime;

	public Flight(String from, LocalDateTime departureDateTime, String to, LocalDateTime destinationDateTime) {
		super();
		this.from = from;
		this.departureDate = departureDateTime.toLocalDate();
		this.departureTime = departureDateTime.toLocalTime();
		this.to = to;
		this.destinationDate = destinationDateTime.toLocalDate();
		this.destinationTime = destinationDateTime.toLocalTime();
	}	
	
	public Flight(String from, LocalDate departureDate, LocalTime departureTime, String to, LocalDate destinationDate,
			LocalTime destinationTime) {
		super();
		this.from = from;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.to = to;
		this.destinationDate = destinationDate;
		this.destinationTime = destinationTime;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public LocalDate getDestinationDate() {
		return destinationDate;
	}

	public void setDestinationDate(LocalDate destinationDate) {
		this.destinationDate = destinationDate;
	}

	public LocalTime getDestinationTime() {
		return destinationTime;
	}

	public void setDestinationTime(LocalTime destinationTime) {
		this.destinationTime = destinationTime;
	}	
	
}
