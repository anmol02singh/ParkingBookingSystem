package userModule;

import java.util.ArrayList;

import parkingBookingModule.BookingSystem;
import parkingBookingModule.ParkingLot;
import parkingBookingModule.ParkingSpace;

public class Management extends Account {
	
	// team is static because it belongs to the class rather than a specific instance (will be shared by all objects)
	private static ArrayList<Management> team = new ArrayList<Management>();
	private BookingSystem bookingSystem = BookingSystem.getInstance();
	
	public Management(String email, String name, String password) {
		super(email, name, password);
	}
	
	public void validateAccount(Client client) {
		// Checks if user is a student or faculty or non Faculty staff and entered valid info
		if(client.isRegistered) {
			
			if(!client.getName().equals("") && !client.getLicensePlate().equals("") && !client.getEmail().equals("")) {
				 client.verify();
				}
		}
	}
	
	public void addTeamMember(Manager m) {
		team.add(m);
	}
	
	public ArrayList<Management> getTeam(){
		return team;
	}
	
	public ParkingLot addParkingLot() {
		return bookingSystem.addParkingLot(new ParkingLot());
	}
	
	public void enableParkingLot(ParkingLot parkingLot) {
		if (parkingLot != null) {
			parkingLot.enableLot();
		}
	}
	
	public void disableParkingLot(ParkingLot parkingLot) {
		if (parkingLot != null) {
			parkingLot.disableLot();
		}
	}
	
	public void enableParkingSpace(ParkingSpace parkingSpace) {
		if (parkingSpace != null) {
			parkingSpace.enableSpace();
		}
	}
	
	public void disableParkingSpace(ParkingSpace parkingSpace) {
		if (parkingSpace != null) {
			parkingSpace.disableSpace();
		}
	}
	
}

