package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class AccountView extends Pane{
	private AccountModel aModel;
	public Button confirmButton;
	public Label label;
	public TextField textField;
	public PasswordField pass1;
	public PasswordField pass2;
	public Label errorLabel;
	public Button backButton;
	
	public AccountView(AccountModel modelIn){
		aModel = modelIn;
		BorderPane bp = new BorderPane();
		VBox vbox = new VBox(5);
		HBox hbox = new HBox(5);
		confirmButton = new Button("Confirm");
		backButton = new Button("Back");
		backButton.setVisible(false);
		label = new Label(aModel.getQuestion());
		errorLabel = new Label("");
		textField = new TextField();
		textField.setVisible(false);
		pass1 = new PasswordField();
		pass2 = new PasswordField();
		hbox.getChildren().addAll(backButton, confirmButton);
		hbox.setAlignment(Pos.CENTER_RIGHT);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(label,textField, pass1, pass2, errorLabel, hbox);
		bp.setCenter(vbox);
		this.getChildren().add(bp);
		
		
	}
}
