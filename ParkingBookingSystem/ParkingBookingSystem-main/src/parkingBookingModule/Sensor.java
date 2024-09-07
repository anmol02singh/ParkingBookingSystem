package parkingBookingModule;

import helperModule.Subject;

public class Sensor {

	private String carLicensePlate;
	private ParkingStateContext sensorStateContext = new ParkingStateContext();

	
	public void setCarLicensePlate(String licensePlate) {
		
		this.carLicensePlate = licensePlate;
	}
	
	public String getCarInfo() {
		
		return this.carLicensePlate;
	}

	
	public SensorParkingState getVacancy() {
		return sensorStateContext.getState();
	}
	

	public void setVacancy(SensorParkingState vacancy) {
		sensorStateContext.setState(vacancy);
	
	}


}
