package helperModule;

import parkingBookingModule.ParkingSpace;

public interface Subject {
	
	// Subject (publisher) for the Observer design pattern
	
	public void attach();
	
	
	public void detach();
	
	
	public void notifyObservers();
	

}
