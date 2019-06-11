package ca.jeonghoon.entity;

import java.util.Date;

import ca.jeonghoon.entity.payment.PaymentTransaction;

public class Passenger {
	public enum Gender { F, M;	} 	
	
	private int id;
	private String name;
	private String family;

	private Date birthDate;
	private String email;
	private String phone;
	private Gender gender;
	
	private Address address;
	private PaymentTransaction payment;
	
	private Flight flight;
	
	public Passenger(int id, String name, String family, Date birthDate, String email, String phone, Gender gender,
			Address address, PaymentTransaction payment, Flight flight) {
		super();
		this.id = id;
		this.name = name;
		this.family = family;
		this.birthDate = birthDate;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.address = address;
		this.payment = payment;
		this.flight = flight;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFamily() {
		return family;
	}
	
	public void setFamily(String family) {
		this.family = family;
	}	
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public PaymentTransaction getPayment() {
		return payment;
	}
	
	public void setPayment(PaymentTransaction payment) {
		this.payment = payment;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
