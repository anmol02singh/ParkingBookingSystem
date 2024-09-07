package userModule;

public class NonFacultyStaff extends Client {
	
	private Management managementTeam;
	private final int RATE = 10;
	
	
	
	public NonFacultyStaff(String name, String email, String password, String licensePlate) {
		super(name, email, password, licensePlate);
	}

	@Override
	public void register() {
		this.isRegistered = true;
		
	}
	
	public int getRate() {
		
		return RATE;
	}
	

}
