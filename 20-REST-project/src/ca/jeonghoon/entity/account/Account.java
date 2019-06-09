package ca.jeonghoon.entity.account;

public abstract class Account implements AccountTransaction {

	private double balance;

	public Account(double balance) {
		super();
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public abstract String getAccountType();
}
