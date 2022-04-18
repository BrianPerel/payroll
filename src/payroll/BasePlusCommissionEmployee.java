package payroll;

public class BasePlusCommissionEmployee extends CommissionEmployee {

	private double baseSalary;

	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary) {

		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

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
	public String obtainWeeklyEarnings() {
		return String.format("%s: $%,.2f", "Weekly pay", getBaseSalary() + super.obtainWeeklyEarnings());
	}

	@Override
	public String toString() {
		return String.format("%s %s %n%s: $%,.2f", "Base-salaried", super.toString(), "base salary", getBaseSalary());
	}
}
