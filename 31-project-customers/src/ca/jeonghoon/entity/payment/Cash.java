package ca.jeonghoon.entity.payment;

public class Cash implements PaymentTransaction {

	@Override
	public boolean pay(double amount) {	
		return true;
	}

}
