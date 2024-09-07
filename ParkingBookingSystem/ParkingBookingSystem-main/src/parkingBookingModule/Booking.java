package parkingBookingModule;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Booking {
	
	private int id;
	private String startDate;
	private LocalDateTime endDate;
	private ParkingSpace parkingSpace;
	private String licensePlate;
	private int bookedHours;

	
	
	public Booking(ParkingSpace parkingSpace, String licensePlate, int bookedHours) {
		this.parkingSpace = parkingSpace;
		this.licensePlate = licensePlate;
		this.bookedHours = bookedHours;
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		startDate = dtf.format(now);
	}

//	public String bookingInfo() {
//		return ;
//	}
	
	public String getLicensePlate() {
		return licensePlate;
	}


	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}


	public LocalDateTime getEndDate() {
		return endDate;
	}
	
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}


	public String getStartDate() {
		return startDate;
	}

	public int getId() {
		return id;
	}
	
	public int getBookedHours() {
		return bookedHours;
	}


	
	public void setBookedHours(int bookedHours) {
		this.bookedHours = bookedHours;
	}
	public void extendBooking(int extendHours) {	
		bookedHours = bookedHours + extendHours;
	}

	
	public void cancelBooking() {
		bookedHours = 1;
	}



}
