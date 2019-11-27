package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class LoginView extends Pane{
	public User user;
	public Button enter;
	public Button exit;
	public PasswordField password;

	public LoginView(User userIn){
		user = userIn;
		HBox line1 = new HBox(5);
		line1.setAlignment(Pos.TOP_RIGHT);
		line1.setPadding(new Insets(5));
		VBox container = new VBox();
		container.setPadding(new Insets(10));
		enter = new Button("Log In");
		exit = new Button("Cancel");

		password = new PasswordField();
		//password.setPrefWidth(100);
		line1.getChildren().addAll(enter, exit);
		container.getChildren().addAll(password, line1);
		this.getChildren().add(container);

	}

	public User getUser(){
		return user;
	}
}
