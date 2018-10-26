package edu.coma502.lecture;

public class Manager {
	private String firstName;
	private String lastName;
	private int startDate;
	private double salary;
	private String departmentName;
	private int daysOfPaidTimeOff;
	private boolean married;
	private int numberOfChildren;
	private int performance;
	private Employee[] team;

	public Manager(String _firstName, String _lastName, int _startDate,
			double _salary, String _departmentName, boolean _married, int _numberOfChildren, Employee[] _team) {
		firstName = _firstName;
		lastName = _lastName;
		startDate = _startDate;
		salary = _salary;
		departmentName = _departmentName;
		daysOfPaidTimeOff = 0;
		married = _married;
		numberOfChildren = _numberOfChildren;
		team = _team;
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
	}
	
	public void performance(int grade) {
		this.performance = grade;
	}
	
	public String review() {
		int teamTotalScore = this.performance;
		for(int i = 0; i < this.team.length; i++) {
			int individualScore = this.team[i].getPerformance();
			teamTotalScore += individualScore;
		}
		int teamAverageScore = teamTotalScore/(team.length +1);
		
		String result;
		if(teamAverageScore == 0) {
			result = "N/A";
		} else if(teamAverageScore > 7) {
			result = "Good";
		} else if (teamAverageScore > 3) {
			result = "Average";
		} else {
			result = "Poor";
		}
		return result;
	}
	
}
