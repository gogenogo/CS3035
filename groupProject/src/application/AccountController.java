package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class AccountController {
	private AccountView accView;
	private AccountModel accModel;
	private User user;

	public AccountController(AccountView viewIn, AccountModel modelIn){
		accView = viewIn;
		accModel = modelIn;
		
		accView.backButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				accModel.decrementCounter();
				System.out.println("Counter is " + accModel.getCounter());
				accView.label.setText(accModel.getQuestion());
				accView.textField.setText("");
				accView.errorLabel.setText("");
				if(accModel.getCounter() < 2){
					accView.backButton.setVisible(false);
				}
			}
			
		});
		
		accView.confirmButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Counter is " + accModel.getCounter());

				if(accModel.getCounter() == 0){
					if(accView.pass1.getText().equals(accView.pass2.getText())){
						user = new User();
						user.setPassword(accView.pass2.getText());
						accModel.incrementCounter();
						accView.label.setText(accModel.getQuestion());
						accView.pass1.setVisible(false);
						accView.pass2.setVisible(false);
						accView.textField.setVisible(true);
						accView.errorLabel.setText("");

					}
					else{
						accView.errorLabel.setText("Passwords do not match");
					}

				}
				else if(accModel.getCounter() == 1){	
					user.setName(accView.textField.getText());
					accModel.incrementCounter();
					accView.label.setText(accModel.getQuestion());
					accView.textField.setText("");
					accView.errorLabel.setText("");
					accView.backButton.setVisible(true);

				}
				else if(accModel.getCounter() == 2){			
					try{
						user.setWeeklyEarnings(Double.parseDouble(accView.textField.getText()));
						accModel.incrementCounter();
						accView.label.setText(accModel.getQuestion());
						accView.textField.setText("");
						accView.errorLabel.setText("");


					}
					catch(Exception e){
						accView.errorLabel.setText("Please input the correct format");
					}
				}
				
				else if(accModel.getCounter() == 3){			
					try{
						user.setGoal(Double.parseDouble(accView.textField.getText()));
						accModel.incrementCounter();
						accView.label.setText(accModel.getQuestion());
						accView.textField.setText("");
						accView.errorLabel.setText("");
					}
					catch(Exception e){
						accView.errorLabel.setText("Please input the correct format");
					}
				}
				else if(accModel.getCounter() == 4){			
					try{
						user.setRent(Double.parseDouble(accView.textField.getText()));
						accModel.incrementCounter();
						accView.label.setText(accModel.getQuestion());
						accView.textField.setText("");
						accView.errorLabel.setText("");
					}
					catch(Exception e){
						accView.errorLabel.setText("Please input the correct format");
					}
				}
				else if(accModel.getCounter() == 5){			
					try{
						user.setGroceries(Double.parseDouble(accView.textField.getText()));
						accModel.incrementCounter();
						accView.label.setText(accModel.getQuestion());
						accView.textField.setText("");
						accView.errorLabel.setText("");
					}
					catch(Exception e){
						accView.errorLabel.setText("Please input the correct format");
					}
				}
				else if(accModel.getCounter() == 6){			
					try{
						user.setGas(Double.parseDouble(accView.textField.getText()));
						accModel.incrementCounter();
						accView.label.setText(accModel.getQuestion());
						accView.textField.setText("");
						accView.errorLabel.setText("");
					}
					catch(Exception e){
						accView.errorLabel.setText("Please input the correct format");
					}
				}
				else if(accModel.getCounter() == 7){			
					try{
						user.setEntertainment(Double.parseDouble(accView.textField.getText()));
						accModel.incrementCounter();
						accView.label.setText(accModel.getQuestion());
						accView.textField.setText("");
						accView.errorLabel.setText("");
					}
					catch(Exception e){
						accView.errorLabel.setText("Please input the correct format");
					}
				}
				else if(accModel.getCounter() == 8){			
					try{
						user.setHome(Double.parseDouble(accView.textField.getText()));
						accModel.incrementCounter();
						accView.label.setText(accModel.getQuestion());
						accView.textField.setText("");
						accView.errorLabel.setText("");
					}
					catch(Exception e){
						accView.errorLabel.setText("Please input the correct format");
					}
				}
				else if(accModel.getCounter() == 9){			
					try{
						user.setHealth(Double.parseDouble(accView.textField.getText()));
						accModel.incrementCounter();
						accView.label.setText(accModel.getQuestion());
						accView.textField.setText("");
						accView.errorLabel.setText("");
					}
					catch(Exception e){
						accView.errorLabel.setText("Please input the correct format");
					}
				}
				else if(accModel.getCounter() == 10){			
					try{
						user.setPersonal(Double.parseDouble(accView.textField.getText()));
						accModel.incrementCounter();
						accView.label.setText(accModel.getQuestion());
						accView.textField.setText("");
						accView.errorLabel.setText("");
					}
					catch(Exception e){
						accView.errorLabel.setText("Please input the correct format");
					}
				}
				else if(accModel.getCounter() == 11){			
					try{
						user.setEducation(Double.parseDouble(accView.textField.getText()));
						accModel.incrementCounter();
						accView.label.setText(accModel.getQuestion());
						accView.textField.setText("");
						accView.errorLabel.setText("");
					}
					catch(Exception e){
						accView.errorLabel.setText("Please input the correct format");
					}
				}
				else if(accModel.getCounter() == 12){			
					try{
						user.setOther(Double.parseDouble(accView.textField.getText()));
						accModel.incrementCounter();
						accView.label.setText(accModel.getQuestion());
						accView.textField.setText("");
						accView.errorLabel.setText("");
					}
					catch(Exception e){
						accView.errorLabel.setText("Please input the correct format");
						//Here is where saving would go
						Stage s = (Stage)(accView.getScene().getWindow());
						s.close();
					}
				}

				
			}
		
			
		});
		
	}
}
