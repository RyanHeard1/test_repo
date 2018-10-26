package edu.coma502.lecture;

public class BetterManager extends Employee {
	private Employee[] team;

	public BetterManager(String _firstName, String _lastName, int _startDate,
			double _salary, String _departmentName, boolean _married,
			int _numberOfChildren, Employee[] _team) {
		super(_firstName, _lastName, _startDate, _salary, _departmentName, _married,
				_numberOfChildren);
		this.team = _team;
	}

	@Override
	public String review() {
		int teamTotalScore = getPerformance();
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
	
	public int getSizeOfTeam() {
		return team.length + 1;
	}
}
