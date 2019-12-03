package application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import application.Purchase.Category;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class User {
	private String name;
	private String password;
	private Image icon; 
	private ImageView iconView;
	private Budget budget;
	private ArrayList<Purchase> purchases = new ArrayList<Purchase>(); //Load this from DB
	private int ID;
	private double carryOver;
	private double v1 = Math.random() * 2 - 1;
	private double v2 = 1;
	private double v3 = 0.2;
	private double v4 = 0;
	public ColorAdjust change = new ColorAdjust(v1, v2, v3, v4);

	
	public User(int idIn, String nameIn, String passwordIn, Image iconIn){
		setID(idIn);
		name = nameIn;
		password = passwordIn;
		icon = iconIn;
		iconView = new ImageView(icon);
		carryOver = 0;		
		iconView.setEffect(change);
	}
	
	public User(String nameIn){
		name = nameIn;
		icon = new Image("blank.png");
		iconView = new ImageView(icon);
		iconView.setEffect(change);

	}
	
	public User(){
		icon = new Image("blank.png");
		iconView = new ImageView(icon);
		iconView.setEffect(change);

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
		//DB Saving
	}
	
	public double getSpent(){
		return this.getSpentOnEducation() + this.getSpentOnEntertainment() + this.getSpentOnGroceries() + this.getSpentOnHealth() + this.getSpentOnHome() + this.getSpentOnOther() + this.getSpentOnPersonal() + this.getSpentOnTransportation();
	}
	
	public double getSpentOnGroceries(){
		double amount = 0;
		ArrayList<Purchase> list = this.getGroceriesList(); 
		for(int i = 0; i < list.size(); i++){
			amount += list.get(i).getAmount();
		}
		return amount;
	}
	
	public double getSpentOnTransportation(){
		double amount = 0;
		ArrayList<Purchase> list = this.getTransportationList(); 
		for(int i = 0; i < list.size(); i++){
			amount += list.get(i).getAmount();
		}
		return amount;
	}
	public double getSpentOnEntertainment(){
		double amount = 0;
		ArrayList<Purchase> list = this.getEntertainmentList(); 
		for(int i = 0; i < list.size(); i++){
			amount += list.get(i).getAmount();
		}
		return amount;
	}
	
	public double getSpentOnHome(){
		double amount = 0;
		ArrayList<Purchase> list = this.getHomeList(); 
		for(int i = 0; i < list.size(); i++){
			amount += list.get(i).getAmount();
		}
		return amount;
	}
	
	public double getSpentOnHealth(){
		double amount = 0;
		ArrayList<Purchase> list = this.getHealthList(); 
		for(int i = 0; i < list.size(); i++){
			amount += list.get(i).getAmount();
		}
		return amount;
	}
	
	public double getSpentOnPersonal(){
		double amount = 0;
		ArrayList<Purchase> list = this.getPersonalList(); 
		for(int i = 0; i < list.size(); i++){
			amount += list.get(i).getAmount();
		}
		return amount;
	}
	public double getSpentOnEducation(){
		double amount = 0;
		ArrayList<Purchase> list = this.getEducationList(); 
		for(int i = 0; i < list.size(); i++){
			amount += list.get(i).getAmount();
		}
		return amount;
	}
	
	public double getSpentOnOther(){
		double amount = 0;
		ArrayList<Purchase> list = this.getOtherList(); 
		for(int i = 0; i < list.size(); i++){
			amount += list.get(i).getAmount();
		}
		return amount;
	}

	public ArrayList<Purchase> getGroceriesList(){
		ArrayList<Purchase> list = new ArrayList<Purchase>();
		for(int i = 0; i < purchases.size(); i++){
			Date date = purchases.get(i).getDate();
			Date currentDate = new Date();
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    Calendar currentCalendar = Calendar.getInstance();
		    currentCalendar.setTime(currentDate);
			if(purchases.get(i).getCategory() == Category.GROCERIES && calendar.get(Calendar.WEEK_OF_YEAR) == currentCalendar.get(Calendar.WEEK_OF_YEAR) && calendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR)){
				list.add(purchases.get(i));
			}
		}
		return list;
	}
	
	public ArrayList<Purchase> getTransportationList(){
		ArrayList<Purchase> list = new ArrayList<Purchase>();
		for(int i = 0; i < purchases.size(); i++){
			Date date = purchases.get(i).getDate();
			Date currentDate = new Date();
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    Calendar currentCalendar = Calendar.getInstance();
		    currentCalendar.setTime(currentDate);
			if(purchases.get(i).getCategory() == Category.GAS && calendar.get(Calendar.WEEK_OF_YEAR) == currentCalendar.get(Calendar.WEEK_OF_YEAR) && calendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR)){
				list.add(purchases.get(i));
			}
		}
		return list;
	}
	public ArrayList<Purchase> getEntertainmentList(){
		ArrayList<Purchase> list = new ArrayList<Purchase>();
		for(int i = 0; i < purchases.size(); i++){
			Date date = purchases.get(i).getDate();
			Date currentDate = new Date();
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    Calendar currentCalendar = Calendar.getInstance();
		    currentCalendar.setTime(currentDate);
			if(purchases.get(i).getCategory() == Category.ENTERTAINMENT && calendar.get(Calendar.WEEK_OF_YEAR) == currentCalendar.get(Calendar.WEEK_OF_YEAR) && calendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR)){
				list.add(purchases.get(i));
			}
		}
		return list;
	}
	
	public ArrayList<Purchase> getHomeList(){
		ArrayList<Purchase> list = new ArrayList<Purchase>();
		for(int i = 0; i < purchases.size(); i++){
			Date date = purchases.get(i).getDate();
			Date currentDate = new Date();
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    Calendar currentCalendar = Calendar.getInstance();
		    currentCalendar.setTime(currentDate);
			if(purchases.get(i).getCategory() == Category.HOME && calendar.get(Calendar.WEEK_OF_YEAR) == currentCalendar.get(Calendar.WEEK_OF_YEAR) && calendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR)){
				list.add(purchases.get(i));
			}
		}
		return list;
	}
	
	public ArrayList<Purchase> getHealthList(){
		ArrayList<Purchase> list = new ArrayList<Purchase>();
		for(int i = 0; i < purchases.size(); i++){
			Date date = purchases.get(i).getDate();
			Date currentDate = new Date();
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    Calendar currentCalendar = Calendar.getInstance();
		    currentCalendar.setTime(currentDate);
			if(purchases.get(i).getCategory() == Category.HEALTH && calendar.get(Calendar.WEEK_OF_YEAR) == currentCalendar.get(Calendar.WEEK_OF_YEAR) && calendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR)){
				list.add(purchases.get(i));
			}
		}
		return list;
	}
	
	public ArrayList<Purchase> getPersonalList(){
		ArrayList<Purchase> list = new ArrayList<Purchase>();
		for(int i = 0; i < purchases.size(); i++){
			Date date = purchases.get(i).getDate();
			Date currentDate = new Date();
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    Calendar currentCalendar = Calendar.getInstance();
		    currentCalendar.setTime(currentDate);
			if(purchases.get(i).getCategory() == Category.PERSONAL && calendar.get(Calendar.WEEK_OF_YEAR) == currentCalendar.get(Calendar.WEEK_OF_YEAR) && calendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR)){
				list.add(purchases.get(i));
			}
		}
		return list;
	}
	public ArrayList<Purchase> getEducationList(){
		ArrayList<Purchase> list = new ArrayList<Purchase>();
		for(int i = 0; i < purchases.size(); i++){
			Date date = purchases.get(i).getDate();
			Date currentDate = new Date();
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    Calendar currentCalendar = Calendar.getInstance();
		    currentCalendar.setTime(currentDate);
			if(purchases.get(i).getCategory() == Category.EDUCATION && calendar.get(Calendar.WEEK_OF_YEAR) == currentCalendar.get(Calendar.WEEK_OF_YEAR) && calendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR)){
				list.add(purchases.get(i));
			}
		}
		return list;
	}
	
	public ArrayList<Purchase> getOtherList(){
		ArrayList<Purchase> list = new ArrayList<Purchase>();
		for(int i = 0; i < purchases.size(); i++){
			Date date = purchases.get(i).getDate();
			Date currentDate = new Date();
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    Calendar currentCalendar = Calendar.getInstance();
		    currentCalendar.setTime(currentDate);
			if(purchases.get(i).getCategory() == Category.OTHER && calendar.get(Calendar.WEEK_OF_YEAR) == currentCalendar.get(Calendar.WEEK_OF_YEAR) && calendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR)){
				list.add(purchases.get(i));
			}
		}
		return list;
	}
	
	public ArrayList<Purchase> getWeekList(){
		ArrayList<Purchase> list = new ArrayList<Purchase>();
		for(int i = 0; i < purchases.size(); i++){
			Date date = purchases.get(i).getDate();
			Date currentDate = new Date();
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    Calendar currentCalendar = Calendar.getInstance();
		    currentCalendar.setTime(currentDate);
			if(calendar.get(Calendar.WEEK_OF_YEAR) == currentCalendar.get(Calendar.WEEK_OF_YEAR) && calendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR)){
				list.add(purchases.get(i));
			}
		}
		return list;
	}
	
	public double getCarryOver() {
		return carryOver;
	}

	public void addCarryOver(double carryOver) {
		this.carryOver += carryOver;
	}
	
	public double[] getDailySpent(ArrayList<Purchase> allPurchases){
		double[] array = new double[7];
		if(allPurchases.size() <= 0){

			return array;
		}
		for(int i = 0; i < allPurchases.size(); i++){
			Date date = allPurchases.get(i).getDate();
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    if(calendar.get(Calendar.DAY_OF_WEEK) == 7){
			    array[0] += allPurchases.get(i).getAmount();
		    }
		    else{
			    array[calendar.get(Calendar.DAY_OF_WEEK)] += allPurchases.get(i).getAmount();
		    }
		}
		return array;
		
	}
	
	public void loadPurchases(){
		purchases = Main.model.db.loadPurchases(this);
	}
	
	public void resetColor(){
		change = new ColorAdjust(v1,v2,v3,v4);
		iconView.setEffect(change);
	}

	public void deleteFromList(Date toDelete) {
		for(int i = 0; i < purchases.size(); i++){
			if(purchases.get(i).getDate().equals(toDelete)){
				purchases.remove(i);
			}
		}
		
	}

	public boolean newWeek() {
		boolean newWeek = true;
		Date currentDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		for(int i = 0; i < purchases.size(); i++){
			Date date = purchases.get(i).getDate();
			Calendar pCalendar = Calendar.getInstance();
			pCalendar.setTime(date);
			if(calendar.get(Calendar.WEEK_OF_YEAR) == pCalendar.get(Calendar.WEEK_OF_YEAR) && calendar.get(Calendar.YEAR) == pCalendar.get(Calendar.YEAR)){
				newWeek = false;
			}
		}
		
		if(purchases.size() == 0){
			newWeek = false;
		}
		
		return newWeek;
	}

	public void setCarryOver(int i) {
		carryOver = 0;
	}
}
