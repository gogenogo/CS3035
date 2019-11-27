package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class User {
	private int userId;
	private String name;
	private String password;
	private Image icon;
	private ImageView iconView;
	private double weeklyEarnings = 0;
	private double rentPerMonth = 0;
	private double rentPerWeek = 0;
	private double goal = 0;
	private double groceries = 0;
	private double gas = 0;
	private double entertainment = 0;
	private double diningOut = 0;
	private double home = 0;
	private double health = 0;
	private double personal = 0;
	private double education = 0;
	private double other = 0;


	public User(int id, String nameIn, String passwordIn, Image iconIn){
		setUserId(id);
		name = nameIn;
		password = passwordIn;
		icon = iconIn;
		iconView = new ImageView(icon);
	}

	public User(String nameIn){
		name = nameIn;
		icon = new Image("blank.png");
		iconView = new ImageView(icon);
	}

	public User(){
		icon = new Image("blank.png");
		iconView = new ImageView(icon);
	}

	public double budgetSpent(){
		double spent = 0;
		spent += rentPerWeek + groceries + gas + entertainment + diningOut + home + health + personal + education + other;
		return spent;
	}

	public double weeklyEarnings(){
		return weeklyEarnings;
	}

	public String getName(){
		return name;
	}

	public ImageView getIcon(){
		return iconView;
	}

	public void setName(String nameIn){
		name = nameIn;
	}

	public void setIcon(Image iconIn){
		icon = iconIn;
		iconView = new ImageView(icon);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setWeeklyEarnings(double value) {
		weeklyEarnings = value;
	}

	public void setGoal(double value) {
		goal = value;
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

	public void setDiningOut(double value) {
		diningOut = value;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
