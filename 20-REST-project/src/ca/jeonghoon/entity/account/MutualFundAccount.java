package ca.jeonghoon.entity.account;

public class MutualFundAccount extends Account {

	public MutualFundAccount(double balance) {
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
		return "Mutual Fund Account";
	}

}
