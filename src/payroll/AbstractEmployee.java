package payroll;

public abstract class AbstractEmployee {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;

	// Constructors of abstract classes can only be called in constructors of their subclasses. So there is no point in making them public. The protected modifier should be enough.
	protected AbstractEmployee(String fName, String lName, String socialSecNumber) {
		firstName = fName;
		lastName = lName;
		socialSecurityNumber = socialSecNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s%nsocial security number: %s", getFirstName(), getLastName(), getSocialSecurityNumber());
	}
	
	public abstract double earnings(); // abstract method must be overridden by concrete subclass. No implementation here
}
