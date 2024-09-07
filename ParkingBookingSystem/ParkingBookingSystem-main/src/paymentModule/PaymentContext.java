package paymentModule;

import userModule.Client;

public class PaymentContext {
	
	// Apart of strategy design pattern
	private PaymentStrategy ps;
	private Client cardHolder;


	
	
	public PaymentContext(PaymentStrategy ps, Client client ) {
		this.ps = ps;
		this.cardHolder = client;
	
	}
	
	
	public String pay(int cost) {
		return ps.pay(this.cardHolder, cost);
	}




}
