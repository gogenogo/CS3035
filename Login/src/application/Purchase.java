package application;

import java.util.Date;

public class Purchase {
	public enum Category {GROCERIES, GAS, ENTERTAINMENT, HOME, HEALTH, PERSONAL, EDUCATION, OTHER};	
	private Category thisCategory;
	private double amount;
	private String location;
	private Date date;
	
	public Purchase(Category newCat, double newAmount, String newLocation){
		setCategory(newCat);
		setAmount(newAmount);
		setLocation(newLocation);
		setDate(new Date());
	}

	public Category getCategory() {
		return thisCategory;
	}

	public void setCategory(Category thisCategory) {
		this.thisCategory = thisCategory;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
