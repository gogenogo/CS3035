package application;

import application.InteractionModel.Displayed;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class AccountController {
	private AccountView accView;
	private AccountModel accModel;
	private User user;
	private int counter = 0;


	public AccountController(AccountView viewIn, AccountModel modelIn){
		accView = viewIn;
		accModel = modelIn;
		
		accView.backButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				counter--;
				if(counter < 0){
					Stage s = (Stage)(accView.getScene().getWindow());
					s.close();
					Stage oldStage = (Stage)Main.view.getScene().getWindow();
					oldStage.show();
					Main.iModel.setDisplayed(Displayed.OPEN);
				}
				accView.redraw(counter);
				
			}
			
		});
		
		accView.confirmButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Budget budget = new Budget();
				if(counter == 0){
					if(accView.pass1.getText().equals(accView.pass2.getText())){
						user = new User();
						user.setPassword(accView.pass2.getText());
						
						counter++;
						accView.redraw(counter);
					}
					else{
						accView.errorLabel.setText("Passwords do not match");
					}

				}
				else if(counter == 1){
					try{
						user.setName(accView.textField1.getText());
						budget.setWeeklyEarnings(Double.parseDouble(accView.textField2.getText()));
						budget.setGoal(Double.parseDouble(accView.textField3.getText()));
						budget.setRent(Double.parseDouble(accView.textField4.getText()));

						counter++;
						accView.redraw(counter);
					}
					catch(Exception e){
						accView.errorLabel.setText("Please put input in correct format");
					}
				}
				else if(counter == 2){
					try{
						budget.setGroceries(Double.parseDouble(accView.textField5.getText()));
						budget.setGas(Double.parseDouble(accView.textField6.getText()));
						budget.setEntertainment(Double.parseDouble(accView.textField7.getText()));
						budget.setHome(Double.parseDouble(accView.textField8.getText()));
						budget.setHealth(Double.parseDouble(accView.textField9.getText()));
						budget.setPersonal(Double.parseDouble(accView.textField10.getText()));
						budget.setEducation(Double.parseDouble(accView.textField11.getText()));
						budget.setOther(Double.parseDouble(accView.textField12.getText()));
						user.setBudget(budget);
						
						//Saving new user would go here
						Main.model.saveUser(user);
						Main.model.setWorkingWith(user);
					    Main.dashcontroller.showView();

						Stage s = (Stage)(accView.getScene().getWindow());
						s.close();
					}
					catch(Exception e){
						accView.errorLabel.setText("Please put input in correct format");
					}
				}
				
			}
		
			
		});
		
	}
	public AccountController(AccountView viewIn, AccountModel modelIn, int counterIn){
		accView = viewIn;
		accModel = modelIn;
		counter = counterIn; // either 3 for changing user stuff or 4 for changing budget stuff
		accView.redraw(counter);
		
		accView.confirmButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				if(counter == 3){
					try{
						if(accView.pass1.getText().equals(accView.pass2.getText())){
							Main.model.getWorkingWith().setName(accView.textField1.getText());
							Main.model.getWorkingWith().setName(accView.textField1.getText());
							Main.model.getWorkingWith().getBudget().setWeeklyEarnings(Double.parseDouble(accView.textField2.getText()));
							Main.model.getWorkingWith().getBudget().setGoal(Double.parseDouble(accView.textField3.getText()));
							Main.model.getWorkingWith().getBudget().setRent(Double.parseDouble(accView.textField4.getText()));
							
							accView.errorLabel.setText("Changes saved");
						}
						else{
							accView.errorLabel.setText("Passwords do not match");
						}
						
						
					}
					catch(Exception e){
						accView.errorLabel.setText("Please put input in correct format");
					}
				}
				else if(counter == 4){
					try{
						Main.model.getWorkingWith().getBudget().setGroceries(Double.parseDouble(accView.textField5.getText()));
						Main.model.getWorkingWith().getBudget().setGas(Double.parseDouble(accView.textField6.getText()));
						Main.model.getWorkingWith().getBudget().setEntertainment(Double.parseDouble(accView.textField7.getText()));
						Main.model.getWorkingWith().getBudget().setHome(Double.parseDouble(accView.textField8.getText()));
						Main.model.getWorkingWith().getBudget().setHealth(Double.parseDouble(accView.textField9.getText()));
						Main.model.getWorkingWith().getBudget().setPersonal(Double.parseDouble(accView.textField10.getText()));
						Main.model.getWorkingWith().getBudget().setEducation(Double.parseDouble(accView.textField11.getText()));
						Main.model.getWorkingWith().getBudget().setOther(Double.parseDouble(accView.textField12.getText()));
						
						accView.errorLabel.setText("Changes saved");
					}
					catch(Exception e){
						accView.errorLabel.setText("Please put input in correct format");
					}
				}
			}
			
		});
	}
}
