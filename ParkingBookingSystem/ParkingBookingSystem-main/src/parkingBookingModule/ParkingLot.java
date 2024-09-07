package parkingBookingModule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ParkingLot {
	
	private String lotID = UUID.randomUUID().toString();
	private ParkingSpace[] spaces = new ParkingSpace[100];
	private boolean isOpen;
	
	
	public ParkingLot() {
		for(int i=0; i<99; i++) {
			spaces[i] = new ParkingSpace(this, new Sensor());
		}
		
	}
	
	public ParkingSpace[] getParkingSpaces(){
		
		return spaces;
	}
	
	
	public void enableLot() {
		
		this.isOpen = true;
	
		for(int i =0; i<spaces.length-1; i++) {
			
			spaces[i].enableSpace();
			
		}
	}
	
	public String getLotId() {
		
		return lotID;
	}
	
	public void disableLot() {
		this.isOpen = false;
		for(int i =0; i<spaces.length-1; i++) {
			
			spaces[i].disableSpace();
			
		}
	}
	
	public boolean getStatus() {
		
		return this.isOpen;
	}

}
