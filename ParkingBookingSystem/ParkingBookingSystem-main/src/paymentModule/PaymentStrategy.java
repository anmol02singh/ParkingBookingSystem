package paymentModule;


import userModule.Client;

public interface PaymentStrategy{
	
	// Apart of strategy design pattern


	public String pay(Client client, int cost);

	
	
	
	
}
