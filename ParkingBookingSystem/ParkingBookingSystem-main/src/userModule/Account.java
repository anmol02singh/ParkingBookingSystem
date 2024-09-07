package userModule;

public class Account {
	protected String email;
	protected String password;
	protected String name;
	protected boolean loggedIn = false;

	
	public Account (String email, String name, String password) {
		this.email = email;
		this.password = password;
		this.name = name;
		
	}
	
	public void login(String name, String password) {
		
		if(this.name  == name && this.password == password) {
			loggedIn = true;
		}
		
	}
	
	public boolean isLoggedIn() {
		
		return this.loggedIn;
	}
}
