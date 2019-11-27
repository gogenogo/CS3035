package application;

import application.InteractionModel.Displayed;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
				    stage.close();	
				    DashboardView dv = new DashboardView();
				    VBox newBox = new VBox();
				    newBox.getChildren().addAll(Main.tbView, dv);
				    Scene scene = new Scene(newBox, 400, 600);
				    Stage newStage = new Stage();
				    newStage.setScene(scene);
				    newStage.show();
					Main.model.setWorkingWith(loginView.user);
				    Main.iModel.setDisplayed(Displayed.DASHBOARD);
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
