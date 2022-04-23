package payroll;

public class BasePlusCommissionEmployee extends CommissionEmployee {

	private double baseSalary;
	
	public BasePlusCommissionEmployee(int employeeId) {
		this(employeeId, "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", 0, 0.01, 0); // constructor calls below constructor passing in these values to allow the creation of an object without any attribute values
	}

	public BasePlusCommissionEmployee(int employeeId, String firstName, String lastName, String address, String phoneNumber, String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary) {

		super(employeeId, firstName, lastName, address, phoneNumber, socialSecurityNumber, grossSales, commissionRate);

		if (baseSalary < 0.0) {
			throw new IllegalArgumentException("Base salary must be greater than or equal to 0.0");
		}

		this.baseSalary = baseSalary;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0) {
			throw new IllegalArgumentException("Base salary must be greater than or equal to 0.0");
		}

		this.baseSalary = baseSalary;
	}

	@Override
	public double calculateWeeklyEarnings() {
		return getBaseSalary() + (getCommissionRate() * getGrossSales());
	}

	@Override
	public String toString() {
		return String.format("%s %s %n%s: $%,.2f%n%s: $%,.2f", 
				"Base-salaried", super.toString(),
				"base salary", getBaseSalary(), 
				"weekly pay", calculateWeeklyEarnings());
	}
}
