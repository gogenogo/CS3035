package application;

public class Budget {
	private double weeklyEarnings = 0;
	private double rentPerMonth = 0;
	private double rentPerWeek = 0;
	private Goal goal;
	private double groceries = 0;
	private double gas = 0;
	private double entertainment = 0;
	private double home = 0;
	private double health = 0;
	private double personal = 0;
	private double education = 0;
	private double other = 0;
	private double carry = 0;

	
	
	public double budgetSpent(){
		double spent = 0;
		spent += rentPerWeek + groceries + gas + entertainment + home + health + personal + education + other;
		return spent;
	}
	
	public double weeklyEarnings(){
		return weeklyEarnings;
	}
	
	
	
	public void setWeeklyEarnings(double value) {
		weeklyEarnings = value;
	}
	
	public void setGoal(double value, String s) {
		goal = new Goal(value, s);
	}
	
	public void setRent(double value) {
		rentPerMonth = value;
		rentPerWeek = value/4;
	}
	
	public void setGroceries(double value) {
		groceries = value;
	}
	
	public void setGas(double value) {
		gas = value;
	}
	
	public void setEntertainment(double value) {
		entertainment = value;
	}
	
	
	public void setHome(double value) {
		home = value;
	}
	
	public void setHealth(double value) {
		health = value;
	}
	
	public void setPersonal(double value) {
		personal = value;
	}
	
	public void setEducation(double value) {
		education = value;
	}
	
	public void setOther(double value) {
		other = value;
	}
	
	
	
	public double getWeeklyEarnings() {
		return weeklyEarnings;
	}
	
	public Goal getGoal() {
		return goal;
	}
	
	public double getRent() {
		return rentPerWeek;
	}
	
	public double getGroceries() {
		return groceries;
	}
	
	public double getGas() {
		return gas;
	}
	
	public double getEntertainment() {
		return entertainment;
	}
	
	public double getHome() {
		return home;
	}
	
	public double getHealth() {
		return health;
	}
	
	public double getPersonal() {
		return personal;
	}
	
	public double getEducation() {
		return education;
	}
	
	public double getOther() {
		return other;
	}

	public double getCarry() {
		return carry;
	}

	public void setCarry(double carry) {
		this.carry = carry;
	}

	public double getDiningOut() {
		return 0;
	}
	
	public void setDiningOut(double value){
		
	}
}
