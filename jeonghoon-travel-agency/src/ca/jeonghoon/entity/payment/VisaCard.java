package ca.jeonghoon.entity.payment;

public class VisaCard extends Card {

	public VisaCard(String cardHolder, String cardNumber, double balance, double creditLimit) {
		super(cardHolder, cardNumber, balance, creditLimit);
	}

	@Override
	public String getCardType() {
		return "Visa Card";
	}

}
