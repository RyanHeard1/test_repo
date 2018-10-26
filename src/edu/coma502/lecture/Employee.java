package edu.coma502.lecture;

public class Employee {
	static int numberOfEmployees = 0;
	private String firstName;
	private String lastName;
	private int startDate;
	private double salary;
	private String departmentName;
	private int daysOfPaidTimeOff;
	private boolean married;
	private int numberOfChildren;
	private int performance;

	public Employee(String _firstName, String _lastName, int _startDate,
			double _salary, String _departmentName, boolean _married, int _numberOfChildren) {
		firstName = _firstName;
		lastName = _lastName;
		startDate = _startDate;
		salary = _salary;
		departmentName = _departmentName;
		daysOfPaidTimeOff = 0;
		married = _married;
		numberOfChildren = _numberOfChildren;
		numberOfEmployees++;
	}
	
	public String getFullName() {
		return String.format("%s %s", firstName, lastName);
	}
	
	public String getDepartment() {
		return departmentName;
	}
	
	boolean getMaritalStatus() {
		return married;
	}
	
	public void setMaritalStatus(boolean newStatus) {
		married = newStatus;
	}
	
	int getNumberOfChildren() {
		return numberOfChildren;
	}
	
	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}
	
	int getPaidTimeOff() {
		return daysOfPaidTimeOff;
	}
	
	public void addPaidTimeOff(int daysToAdd) {
		daysOfPaidTimeOff += daysToAdd;
	}
	
	public int getYearsOfServiceAsOf(int asOf) {
		return (asOf - startDate)/10000;
	}
	
	public boolean scheduleTimeOff(int days) {
		boolean result = false;
		if (daysOfPaidTimeOff >= days) {
			daysOfPaidTimeOff -= days;
			result = true;
		}
		return result;
	}
	
	public void terminate() {
		numberOfEmployees--;
	}
	
	public void performance(int grade) {
		this.performance = grade;
	}
	
	public int getPerformance() {
		return this.performance;
	}
	
	public String review() {
		String result;
		if(this.performance == 0) {
			result = "N/A";
		} else if(this.performance > 7) {
			result = "Good";
		} else if (this.performance > 3) {
			result = "Average";
		} else {
			result = "Poor";
		}
		return result;
	}
	
	public static int TotalNumberOfEmployees() {
		return numberOfEmployees;
	}
	
	
	@Override
	public String toString() {
		return this.getFullName();
	}

}
