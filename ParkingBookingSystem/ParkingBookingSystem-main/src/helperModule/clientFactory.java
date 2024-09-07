package helperModule;

import userModule.Client;
import userModule.FacultyMember;
import userModule.NonFacultyStaff;
import userModule.Student;
import userModule.Visitor;

public class clientFactory {
	public static Client createClient(String clientType, String email, String name, String password, String licensePlate) {
		if (clientType.equalsIgnoreCase("student")) {
			return new Student(email, name, password, licensePlate);
		}
		if (clientType.equalsIgnoreCase("faculty member")) {
			return new FacultyMember(email, name, password, licensePlate);
		}
		if (clientType.equalsIgnoreCase("non-faculty staff")) {
			return new NonFacultyStaff(email, name, password, licensePlate);
		}
		if (clientType.equalsIgnoreCase("visitor")) {
			return new Visitor(email, name, password, licensePlate);
		}
		else
			throw new IllegalArgumentException("Invalid user type" + clientType);
	}
}
