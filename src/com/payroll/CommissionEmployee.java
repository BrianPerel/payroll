package com.payroll;

import java.util.Objects;

public class CommissionEmployee extends AbstractEmployee {
	
	private double grossSales;
	private double commissionRate;

	public CommissionEmployee(int employeeId, String firstName, String lastName, String address, String phoneNumber, String socialSecurityNumber, double grossSales, double commssionRate) {
		super(employeeId, firstName, lastName, address, phoneNumber, socialSecurityNumber);
		
		if(commssionRate <= 0.0 || commssionRate >= 1.0) {
			throw new IllegalArgumentException("Commission rate must be greater than 0.0 and less than 1.0");
		}
		
		if(grossSales < 0.0) {
			throw new IllegalArgumentException("Gross sales must be greater than or equal to 0.0");
		}
		
		this.grossSales = grossSales;
		this.commissionRate = commssionRate;
	}
	
	public double getGrossSales() {
		return grossSales;
	}
	
	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	@Override
	public double calculateWeeklyEarnings() {
		return getCommissionRate() * getGrossSales();
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s%n%s: $%,.2f %n%s: %s%n%s: $%,.2f",
				"Commission employee", super.toString(),
				"gross sales", getGrossSales(),
				"commission rate", String.valueOf((int) (getCommissionRate() * 100)).concat("%"),
				"weekly pay", calculateWeeklyEarnings());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(commissionRate, grossSales);
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
		CommissionEmployee other = (CommissionEmployee) obj;
		return Double.doubleToLongBits(commissionRate) == Double.doubleToLongBits(other.commissionRate)
				&& Double.doubleToLongBits(grossSales) == Double.doubleToLongBits(other.grossSales);
	}
}
