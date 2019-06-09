package ca.jeonghoon.entity.account;

public class CheckingAccount extends Account {

	public CheckingAccount(double balance) {
		super(balance);
	}

	@Override
	public void deposit(double amount) {
		setBalance(getBalance() + amount);
	}

	@Override
	public boolean withdraw(double amount) {
		if (getBalance() >= amount) {
			setBalance(getBalance() - amount);
			return true;
		}
		return false;
	}

	@Override
	public String getAccountType() {
		// TODO Auto-generated method stub
		return "Checking Account";
	}

}
