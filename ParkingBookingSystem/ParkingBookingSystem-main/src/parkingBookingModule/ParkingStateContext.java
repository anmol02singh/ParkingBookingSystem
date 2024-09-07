package parkingBookingModule;

public class ParkingStateContext {
	
	// State design pattern for sensor
	
	private SensorParkingState currentState;
	
	
	public ParkingStateContext(){
		
		currentState = new EmptyParkingState();
		
	}
	
	public void setState(SensorParkingState state) {
		this.currentState = state;
	}
	
	public SensorParkingState getState() {
		
		return currentState;
	}
	
	public void alert() {
		
		currentState.alert(this);
		
	}
	
	 
	
	

}
