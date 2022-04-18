package payroll;

public class SalariedEmployee extends AbstractEmployee {
	
	private double weeklySalary;
	
	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
		super(firstName, lastName, socialSecurityNumber);
		
		if(weeklySalary < 0.0) {
			throw new IllegalArgumentException(
					"Weekly salary must be greater than 0.0");
		}
		
		this.weeklySalary = weeklySalary;
	}

	public double getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}

	@Override
	public String obtainWeeklyEarnings() {
		return String.format("%s: $%,.2f", "Weekly pay", getWeeklySalary());
	}
	
	@Override
	public String toString() {
		return String.format("Salaried employee: %s%n%s: $%,.2f",
				super.toString(), "weekly salary", getWeeklySalary());
	}
}
