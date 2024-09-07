package userModule;

public class Visitor extends Client {
	
	private final int RATE = 15;

	
	public Visitor(String name, String email, String password, String licensePlate) {
		super(name, email, password, licensePlate);
	}

	@Override
	public void register() {
		this.isRegistered = true;
		// No verification needed for visitor
		this.isVerified = true;	
	}
	
	public int getRate() {
		return RATE;
	}
	
}
