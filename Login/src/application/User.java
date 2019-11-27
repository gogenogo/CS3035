package application;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class User {
	private String name;
	private String password;
	private Image icon; 
	private ImageView iconView;
	private Budget budget;
	private ArrayList<Purchase> purchases = new ArrayList<Purchase>();
	private int ID;

	
	public User(int idIn, String nameIn, String passwordIn, Image iconIn){
		setID(idIn);
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
	
	
	
	public void setBudget(Budget budgetIn){
		budget = budgetIn;
	}
	
	public Budget getBudget(){
		return budget;
	}

	public void setPassword(String text) {
		password = text;
		
	}

	public void setName(String text) {
		name = text;
		
	}

	public String getPassword() {
		
		return password;
	}

	public ImageView getIcon() {
		return iconView;
	}

	public String getName() {
		return name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public ArrayList<Purchase> getPurchases() {
		return purchases;
	}

	public void addPurchases(Purchase purchase) {
		purchases.add(purchase);
	}
}
