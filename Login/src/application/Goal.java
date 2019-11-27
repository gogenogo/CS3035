package application;

public class Goal {
	private double goal;
	private String goalName;
	
	public Goal(double goalIn, String goalNameIn){
		setGoal(goalIn);
		setGoalName(goalNameIn);
	}

	public double getGoal() {
		return goal;
	}

	public void setGoal(double goal) {
		this.goal = goal;
	}

	public String getGoalName() {
		return goalName;
	}

	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}
}
