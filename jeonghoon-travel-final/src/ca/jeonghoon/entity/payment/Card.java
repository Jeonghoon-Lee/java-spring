package ca.jeonghoon.entity.payment;

public abstract class Card implements PaymentTransaction {
	
	private String cardHolder;
	private String cardNumber;
	private double balance;
	private double creditLimit;

	public Card(String cardHolder, String cardNumber, double balance, double creditLimit) {
		super();
		this.cardHolder = cardHolder;
		this.cardNumber = cardNumber;
		this.balance = balance;
		this.creditLimit = creditLimit;
	}

	@Override
	public boolean pay(double amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public abstract String getCardType();

}
