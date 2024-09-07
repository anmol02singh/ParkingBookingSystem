package parkingBookingModule;

import java.util.ArrayList;

import helperModule.Observer;
import paymentModule.*;
import userModule.*;

public class BookingSystem implements Observer {
	private static ArrayList<ParkingLot> parkinglots = new ArrayList<ParkingLot>();
	private ArrayList<ParkingSpace> availableSpaces = new ArrayList<ParkingSpace>();
	private EmptyParkingState emptyState;
	private static final BookingSystem bookingSystem = new BookingSystem();
	

	public static BookingSystem getInstance() {
		return bookingSystem;
	}
	
	private BookingSystem() {
		
	}
	
	public ArrayList<ParkingSpace> getAvailableSpaces(){

		return availableSpaces;
	}
	
	

	
	
	public ParkingLot addParkingLot(ParkingLot parkingLot) {
		ParkingSpace[] parkingSpaces = parkingLot.getParkingSpaces();
		for(int i = 0; i< parkingSpaces.length-1; i++) {
			if(parkingSpaces[i].isAvailable()) {
				availableSpaces.add(parkingSpaces[i]);
				
			}
		}
		this.parkinglots.add(parkingLot);
		return parkingLot;
	}
	
	public ArrayList<ParkingLot> getParkingLots(){
		return this.parkinglots;
	}
	
	public Booking bookParkingSpace(Client user, ParkingSpace parkingSpace, int hoursRequested)throws IllegalArgumentException {
			//to book a parking space:
			//client must be registered after logging in
			//space must not be occupied
			//space must not be booked by another client (user)
			//requires the cost of an hour (of the type of a client) as the deposit
			//client must provide valid licence plate number
		
		if (user.isLoggedIn() && user.isRegistered() && parkingSpace.isAvailable()) {
			parkingSpace.book(user, hoursRequested);
		
			return new Booking(parkingSpace, user.getLicensePlate(), hoursRequested);
		}

		
		throw new IllegalArgumentException();
		
	}
	
	public String payForBooking(Client user, Booking bookingInfo, String paymentMethod) {
		int rate = 0;
		int price;
		if(user instanceof Student) {
			rate = ((Student)user).getRate();
			}
		else if(user instanceof FacultyMember) {
			rate = ((FacultyMember)user).getRate();
		}
		else if(user instanceof NonFacultyStaff) {
			rate = ((NonFacultyStaff)user).getRate();
		}
		else if(user instanceof Visitor) {
			rate = ((Visitor)user).getRate();
		}
		price = rate * bookingInfo.getBookedHours();
		
		
		if(paymentMethod == "Mobile") {
			PaymentContext pc = new PaymentContext(new Mobile(), user);
			bookingInfo.getParkingSpace().getSensor().setVacancy(emptyState);
			return pc.pay(price);
		
		}
		else if(paymentMethod == "Credit") {
			PaymentContext pc = new PaymentContext(new Credit(), user);
			bookingInfo.getParkingSpace().getSensor().setVacancy(emptyState);
			return pc.pay(price);
		}
		else if(paymentMethod == "Debit") {
			PaymentContext pc = new PaymentContext(new Debit(), user);
			bookingInfo.getParkingSpace().getSensor().setVacancy(emptyState);
			return pc.pay(price);
		}
		
		return "Unable to Process transcation, please try again.";
	
	}
	

	
	public Booking getCarInfo() {
		
		return null;
	}

	@Override
	public void updateAvailableSpaces(ParkingSpace parkingSpace) {
		
		if(parkingSpace.getSensor().getVacancy() instanceof OccupiedParkingState || parkingSpace.getSensor().getVacancy() instanceof MaintenanceParkingState) {
			availableSpaces.remove(parkingSpace);
		}
		else {
			if(!availableSpaces.contains(parkingSpace)) {
				availableSpaces.add(parkingSpace);
			}
		}
		
	}

}
