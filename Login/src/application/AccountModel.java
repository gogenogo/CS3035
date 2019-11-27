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
		questions[3] = "What is the GOAL amount of money you're saving?";
		questions[4] = "How much do you spend a MONTH on rent and utilities?";
		questions[5] = "groceries?";
		questions[6] = "gas/other transportation?";
		questions[7] = "entertainment/dining out?";
		questions[8] = "your home?";
		questions[9] = "health expenses?";
		questions[10] = "personal shopping?";
		questions[11] = "education?";
		questions[12] = "other expenses not listed?";
		
		
	}
	
	public String[] getQuestion(){
		return questions;
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
