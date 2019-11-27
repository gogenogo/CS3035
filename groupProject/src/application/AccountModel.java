package application;

public class AccountModel {
	private int counter;
	private String[] questions;
	public AccountModel(){
		counter = 0;
		questions = new String[13];
		questions[0] = "Choose a password and confirm they match";
		questions[1] = "Please enter your name";
		questions[2] = "Please enter your WEEKLY salary (ex: 600.00)";
		questions[3] = "How much money would you like to save?";
		questions[4] = "How much do you spend a MONTH on rent and utilities?";
		questions[5] = "How much do you spend a WEEK on groceries?";
		questions[6] = "How much do you spend a WEEK on gas/other transportation?";
		questions[7] = "How much do you spend a WEEK on entertainment/dining out?";
		questions[8] = "How much do you spend a WEEK on your home?";
		questions[9] = "How much do you spend a WEEK on health expenses?";
		questions[10] = "How much do you spend a WEEK on personal shopping?";
		questions[11] = "How much do you spend a WEEK on education?";
		questions[12] = "How much do you spend a WEEK on other expenses not listed?";
		
		
	}
	
	public String getQuestion(){
		return questions[counter];
	}
	
	public void incrementCounter(){
		counter++;
	}
	
	public int numQuestions(){
		return questions.length;
	}
	
	public int getCounter(){
		return counter;
	}

	public void decrementCounter() {
		counter--;
		
	}
	
}
