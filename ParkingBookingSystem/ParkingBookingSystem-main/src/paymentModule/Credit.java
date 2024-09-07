package paymentModule;

import parkingBookingModule.Booking;
import userModule.Client;

public class Credit implements PaymentStrategy{

	@Override
	public String pay(Client client, int cost) {
	
		return "Payment with Credit Card of " + cost;
	}


}
