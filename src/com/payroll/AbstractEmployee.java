package com.payroll;

public abstract class AbstractEmployee {
	
	private final int employeeId;
	private final String firstName;
	private final String lastName;	
	private final String address;
	private final String phoneNumber;
	private final String socialSecurityNumber;
	
	// Constructors of abstract classes can only be called in constructors of their subclasses. So there is no point in making them public. The protected modifier should be enough.
	protected AbstractEmployee(int employeeId, String firstName, String lastName, String address, String phoneNumber, String socialSecurityNumber) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
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
		return String.format("%s %s%nsocial security number: %s%nphone number: %s%naddress: %s%nemployee ID: %d", getFirstName(), getLastName(), getSocialSecurityNumber(), getPhoneNumber(), getAddress(), getEmployeeId());
	}
	
	@Override
	public boolean equals(Object o) {
		return !(o instanceof AbstractEmployee) || o != this;
	}

	@Override
	public int hashCode() {
		return (employeeId + 17) * 12;
	}
	
	// gets weekly earnings for an employee
	public abstract double calculateWeeklyEarnings(); // abstract method must be overridden by concrete subclass. No implementation here
}
