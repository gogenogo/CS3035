package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LoginView extends Pane{
	public User user;
	public Button enter;
	public Button exit;
	public PasswordField password; 
	public Text error;
	
	public LoginView(User userIn){
		user = userIn;
		error = new Text();
		error.setFont(Font.font("Open Sans"));
		error.setFill(Color.RED);
		HBox line1 = new HBox(5); 
		line1.setAlignment(Pos.TOP_RIGHT);
		line1.setPadding(new Insets(5));
		VBox container = new VBox(5);
		container.setPadding(new Insets(10));
		enter = new Button("Log In");
		//enter.setTextFill(Main.forText);
		exit = new Button("Cancel");
		//exit.setTextFill(Main.forText);
		
		password = new PasswordField();
		//password.setPrefWidth(100);
		line1.getChildren().addAll(enter, exit);
		VBox vbox = new VBox(10);
		Text name = new Text(userIn.getName());
		name.setFont(Font.font("Open Sans", 16));
		name.setStroke(Main.forText);
		vbox.getChildren().addAll(name, password);
		vbox.setAlignment(Pos.CENTER);
		container.getChildren().addAll(vbox, line1, error);
		container.setBackground(new Background(new BackgroundFill(Color.rgb(217, 228, 255), CornerRadii.EMPTY, null)));
		this.getChildren().add(container);
		
	}
}
