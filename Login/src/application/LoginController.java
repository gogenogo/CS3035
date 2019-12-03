package application;

import java.util.Optional;

import application.InteractionModel.Displayed;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController {
	private LoginView loginView;
	
	public LoginController(LoginView lv){
		loginView = lv;
		
		loginView.enter.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				if(loginView.password.getText().equals(loginView.user.getPassword())){
					Stage stage = (Stage) loginView.getScene().getWindow();
					Main.model.setWorkingWith(loginView.user);
					Main.model.getWorkingWith().loadPurchases();
					Main.dashview = new DashboardView();
					Main.expenseview = new NewExpenseView();
					Main.dashcontroller = new DashboardController();
				    Main.iModel.setDisplayed(Displayed.DASHBOARD);
					stage.close();	
					stage = (Stage) Main.view.getScene().getWindow();
					stage.close();
				   if(Main.model.getWorkingWith().newWeek()){
					   double increment = Main.model.getWorkingWith().getBudget().weeklyEarnings() - Main.model.getWorkingWith().getSpent();
					   Main.model.getWorkingWith().addCarryOver(increment);
					   if(Main.model.getWorkingWith().getCarryOver() >= Main.model.getWorkingWith().getBudget().getGoal().getGoal()){
						   Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Congrats!");
							alert.setHeaderText("You've met your goal!");
							alert.setContentText("Please go into your settings to create a new goal. The old goal will be reset!");
							Main.model.getWorkingWith().setCarryOver(0);
							alert.showAndWait();
					   }
					   Main.model.db.updateUserInfo();
					   Main.model.db.updateBudgetInfo();
					   Main.model.db.updateCarryOver();

				   }
					
				    Main.dashcontroller.showView();
				}
				else{
					loginView.error.setText("Incorrect Password");
				}
			}
		});
		
		loginView.exit.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				Stage stage = (Stage) loginView.getScene().getWindow();
			    stage.close();	
			    Stage s = (Stage)(loginView.getScene().getWindow());
				s.close();
				Stage oldStage = (Stage)Main.view.getScene().getWindow();
				oldStage.show();
				Main.iModel.setDisplayed(Displayed.OPEN);

			}
		});
	}
}
