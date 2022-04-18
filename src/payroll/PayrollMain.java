package payroll;

/**
 * Payroll application that calculates the weekly pay of several different types of employees using each employee's obtainWeeklyEarnings method.
 * BasePlusCommissionEmployee -> CommissionEmployee -> AbstractEmployee
 * SalariedEmployee, HourlyEmployee -> AbstractEmployee
 * @author Brian
 */
public class PayrollMain {
	
	public static void main(String[] args) {
		SalariedEmployee se1 = new SalariedEmployee("Raymond", "Benson", "454-23-2342", 1500.00);
		System.out.println(se1.toString());
		
		HourlyEmployee he1 = new HourlyEmployee("Micheal", "Richards", "878-42-1233", 30, 40);
		System.out.println("\n" + he1.toString() + "\n" + he1.obtainWeeklyEarnings());
		
		CommissionEmployee ce1 = new CommissionEmployee("Mathew", "Costello", "677-45-2342", 10000, 0.1);
		System.out.println("\n" + ce1.toString() + "\n" + ce1.obtainWeeklyEarnings());
		
		BasePlusCommissionEmployee bpce1 = new BasePlusCommissionEmployee("Eric", "Nylund", "932-34-5673", 10000, 0.2, 300);
		System.out.println("\n" + bpce1.toString() + "\n" + ce1.obtainWeeklyEarnings());
	}
	
}
