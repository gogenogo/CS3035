package application;

import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class LoginController {
	private LoginView loginView;
	public Model model = new Model();

	public LoginController(LoginView lv){
		loginView = lv;



		loginView.enter.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				try {
					if (model.isLogin(loginView.getUser().getUserId(),loginView.password.getText())){
						System.out.println("Login Successful");
					}
					else{
						System.out.println("Error Logging In");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		loginView.exit.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				Stage stage = (Stage) loginView.getScene().getWindow();
			    stage.close();
			}
		});
	}




}
