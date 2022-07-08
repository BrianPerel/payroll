package com.payroll;

import java.util.Objects;

public class HourlyEmployee extends AbstractEmployee {

	private double wage; // wage per hour
	private double hours; // hours worked for week

	public HourlyEmployee(int employeeId, String firstName, String lastName, String address, String phoneNumber, String socialSecurityNumber, double wage, double hours) {
		super(employeeId, firstName, lastName, address, phoneNumber, socialSecurityNumber);

		if (wage < 0.0) {
			throw new IllegalArgumentException("Hourly wage must be greater than or equal to 0.0");
		}

		if (hours < 0.0 || hours > 168.0) {
			throw new IllegalArgumentException("Hours worked must be greater than or equal to 0.0 and less than 168 "
					+ "(which is the total number of hours in a week)");
		}
		
		this.wage = wage;
		this.hours = hours;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		if (wage < 0.0) {
			throw new IllegalArgumentException("Hourly wage must be greater than or equal to 0.0");
		}

		this.wage = wage;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		if (hours < 0.0 || hours > 168.0) {
			throw new IllegalArgumentException("Hours worked must be greater than or equal to 0.0 and less than 168 "
					+ "(which is the total number of hours in a week)");
		}

		this.hours = hours;
	}

	@Override
	public double calculateWeeklyEarnings() {
		return getHours() <= 40 ? (getWage() * getHours()) : (40 * getWage() + (getHours() - 40) * getWage() * 1.5);
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s%n%s: $%,.2f %n%s: %,.2f%n%s: $%,.2f",
				"Hourly employee", super.toString(),
				"hourly salary", getWage(),
				"hours worked", getHours(),
				"weekly pay", calculateWeeklyEarnings());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(hours, wage);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		HourlyEmployee other = (HourlyEmployee) obj;
		return Double.doubleToLongBits(hours) == Double.doubleToLongBits(other.hours)
				&& Double.doubleToLongBits(wage) == Double.doubleToLongBits(other.wage);
	}
}
