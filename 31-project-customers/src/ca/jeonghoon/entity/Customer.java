package ca.jeonghoon.entity;

import java.util.ArrayList;
import java.util.Date;

import ca.jeonghoon.entity.payment.PaymentTransaction;

public class Customer {
	public enum Gender { M, F;	} 	
	
	private int id;
	private String name;
	private String family;

	private Date birthDate;
	private ArrayList<String> emailList;
	private String phone;
	private Gender gender;
	
	private Address address;
	private PaymentTransaction payment;
	
	public Customer(int id, String name, String family, Date birthDate, ArrayList<String> emailList, String phone, Gender gender,
			Address address, PaymentTransaction payment) {
		super();
		this.id = id;
		this.name = name;
		this.family = family;
		this.birthDate = birthDate;
		this.emailList = emailList;
		this.phone = phone;
		this.gender = gender;
		this.address = address;
		this.payment = payment;
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
	
	public void setfamily(String family) {
		this.family = family;
	}	
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public ArrayList<String> getEmailList() {
		return emailList;
	}
	
	public void setEmailList(ArrayList<String> emailList) {
		this.emailList = emailList;
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

}
