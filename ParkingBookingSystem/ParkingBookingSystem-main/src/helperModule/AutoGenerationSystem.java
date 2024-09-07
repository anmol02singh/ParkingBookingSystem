package helperModule;

import userModule.*;


public class AutoGenerationSystem {
	
	
	
	public Manager generateManagementAccount(String email, String name, String password) {
		
		
		return new Manager(email, name, password);
	}
	

}
