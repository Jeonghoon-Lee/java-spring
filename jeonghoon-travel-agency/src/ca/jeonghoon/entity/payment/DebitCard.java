package ca.jeonghoon.entity.payment;

public class DebitCard extends Card {

	public DebitCard(String cardHolder, String cardNumber, double balance, double creditLimit) {
		super(cardHolder, cardNumber, balance, creditLimit);
	}

	@Override
	public String getCardType() {
		return "Debit Card";
	}

}
