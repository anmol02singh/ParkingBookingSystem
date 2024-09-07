package paymentModule;

import parkingBookingModule.Booking;
import userModule.Client;

public class Mobile implements PaymentStrategy{

	@Override
	public String pay(Client client, int cost) {
		
		return "Payment with mobile of " + cost  ;
	}



}
