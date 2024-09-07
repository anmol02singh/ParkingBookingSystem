package userModule;

public class FacultyMember extends Client {
	
	private Management managementTeam;
	
	private final int RATE = 8;
	
	public FacultyMember(String name, String email, String password, String licensePlate) {
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
