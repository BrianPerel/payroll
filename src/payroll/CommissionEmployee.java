package payroll;

public class CommissionEmployee extends AbstractEmployee {
	
	private double grossSales;
	private double commissionRate;

	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commssionRate) {
		super(firstName, lastName, socialSecurityNumber);
		
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
	public String obtainWeeklyEarnings() {
		return String.format("%s: $%,.2f", "Weekly pay", (getCommissionRate() * getGrossSales()));
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s%n%s: $%,.2f %n%s: %.2f",
				"Commission employee", super.toString(),
				"gross sales", getGrossSales(),
				"commission rate", getCommissionRate());
	}
}
