package payroll;

public class HourlyEmployee extends AbstractEmployee {

	private double wage; // wage per hour
	private double hours; // hours worked for week

	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber);

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
	public String obtainWeeklyEarnings() {
		return String.format("%s: $%,.2f", "Weekly pay", (getHours() <= 40) ? (getWage() * getHours()) : (40 * getWage() + (getHours() - 40) * getWage() * 1.5));
	}
	
	@Override
	public String toString() {
		return String.format("Hourly employee: %s%n%s: $%,.2f %n%s: %,.2f",
				super.toString(), "hourly salary", getWage(),
				"hours worked", getHours());
	}
}
