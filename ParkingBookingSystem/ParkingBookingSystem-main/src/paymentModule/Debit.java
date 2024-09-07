package paymentModule;

import parkingBookingModule.Booking;
import userModule.Client;

public class Debit implements PaymentStrategy{

	@Override
	public String pay(Client client, int cost) {
		
		return "Payment with Debit Card of " + cost;
	}




	
}
