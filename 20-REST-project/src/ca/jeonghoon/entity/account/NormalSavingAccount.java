package ca.jeonghoon.entity.account;

public class NormalSavingAccount extends Account {

	public NormalSavingAccount(double balance) {
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
		return "Normal Saving Account";
	}

}
