package payroll;

public class SalariedEmployee extends AbstractEmployee {
	
	private double weeklySalary;
	
	public SalariedEmployee(int employeeId, String firstName, String lastName, String address, String phoneNumber, String socialSecurityNumber, double weeklySalary) {
		super(employeeId, firstName, lastName, address, phoneNumber, socialSecurityNumber);
		
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
	public double calculateWeeklyEarnings() {
		return getWeeklySalary();
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s%n%s: $%,.2f%n%s: $%,.2f",
				"Salaried employee", super.toString(),
				"weekly salary", getWeeklySalary(),
				"weekly pay", calculateWeeklyEarnings());
	}
}
