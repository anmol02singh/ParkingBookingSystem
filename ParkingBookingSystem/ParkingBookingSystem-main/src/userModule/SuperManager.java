package userModule;

import helperModule.AutoGenerationSystem;

public class SuperManager extends Management {
	
	// Only 1 super manager in the management team (ie: Singleton)
	
	private static final SuperManager superManager = new SuperManager("super@gmail.com", "manager", "smit");
	AutoGenerationSystem autoGenerator;
	
	private SuperManager(String email, String name, String password) {
		super(email, password, name);
	}
	
	

	public static SuperManager getInstance() {
		
		return superManager;
	}
	
	public Manager createManagementAccount(String email, String name, String password) {
		
		if(autoGenerator == null) {
			autoGenerator = new AutoGenerationSystem();
		}
		
		Manager newMember = autoGenerator.generateManagementAccount(email, name, password);
		this.addTeamMember(newMember);
		return newMember;
		
	}

}
