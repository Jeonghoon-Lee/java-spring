package ca.jeonghoon.entity.account;

public interface AccountTransaction {
	public void deposit(double amount);
	public boolean withdraw(double amount);
}
