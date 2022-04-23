package payroll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Payroll application that calculates the weekly pay of several different types of employees using each employee's obtainWeeklyEarnings method.
 * BasePlusCommissionEmployee -> CommissionEmployee -> AbstractEmployee
 * SalariedEmployee, HourlyEmployee -> AbstractEmployee
 * @author Brian Perel
 */
public class PayrollMain {
	public static void main(String[] args) {
		PayrollMain payrollSystem = new PayrollMain();
		List<AbstractEmployee> employees = payrollSystem.displayAllEmployees(payrollSystem);
		payrollSystem.performSalaryRaise(employees);
		payrollSystem.getEmployeeTypes(employees);			
	}

	public void performSalaryRaise(List<AbstractEmployee> employees) {
		// generically process each element in the array of elements
		for(AbstractEmployee currentEmployee : employees) {			
			// determine whether the element is of BasePlusCommissionEmployee type
			if(currentEmployee instanceof BasePlusCommissionEmployee) {
				// downcast Employee reference to BasePlusCommissionEmployee reference
				BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
				
				// add a salary increase of 10%
				employee.setBaseSalary((0.10 * employee.getBaseSalary()) + employee.getBaseSalary());
				
				System.out.printf("Employee %d is a base plus commissioned employee and their new salary is $%,.2f%n", 
						employee.getEmployeeId(), employee.getBaseSalary());
			}
		}
	}

	public List<AbstractEmployee> displayAllEmployees(PayrollMain payrollSystem) {
		AbstractEmployee salariedEmployee1 = new SalariedEmployee(1, "Raymond", "Benson", "23 New way, Miami, FL", "(508)-324-3453", "454-23-2342", 1500.00), 
				hourlyEmployee1 = new HourlyEmployee(2, "Micheal", "Richards", "67 Overview Drive, Big City, FL", "(456)-123-5464", "878-42-1233", 30, 40),
				hourlyEmployee2 = new HourlyEmployee(3, "David", "Micheals", "67 Lake View, Dripping Springs, TX", "(789)-345-5674", "234-54-5683", 10, 60),
				commissionEmployee1 = new CommissionEmployee(4, "Mathew", "Costello", "45 Big Circle, Little Town, ID", "(567)-435-4564", "677-45-2342", 10000, 0.10),
				basePlusCommissionEmployee1 = new BasePlusCommissionEmployee(5, "Eric", "Nylund", "87 Beverly Hills, Los Angeles, CA", "(546)-234-4564", "932-34-5673", 10000, 0.20, 300),
				emptyEmployee = payrollSystem.createEmptyEmployee(6);
		
		ArrayList<AbstractEmployee> employees = new ArrayList<>(Arrays.asList(salariedEmployee1, hourlyEmployee2,
				hourlyEmployee1, commissionEmployee1, basePlusCommissionEmployee1, emptyEmployee)); // Create an ArrayList of objects object
				
		// iterate through an ArrayList of objects using iterator(), then assign this set to your variable of the Iterator interface class 
		Iterator<AbstractEmployee> iterator = employees.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next() + "\n");
		}
		
		return employees;
	}

	public void getEmployeeTypes(List<AbstractEmployee> employees) {
		// Iterate through an ArrayList of objects using Stream API. Create a stream of elements from the list with the method stream.foreach() and get elements one by one
		employees.forEach(emp -> System.out.printf("%nEmployee %d is a %s", emp.getEmployeeId(), emp.getClass().getSimpleName()));
	}
	
	public AbstractEmployee createEmptyEmployee(int employeeId) {
		return new BasePlusCommissionEmployee(employeeId);
	}
}
