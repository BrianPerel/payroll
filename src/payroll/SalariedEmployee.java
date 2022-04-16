package payroll;

public class SalariedEmployee extends AbstractEmployee {
	
	private double weeklySalary;

	protected SalariedEmployee(String fName, String lName, String socialSecNumber) {
		super(fName, lName, socialSecNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double earnings() {
		// TODO Auto-generated method stub
		return 0;
	}

}
