package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class NewExpenseView extends VBox {
	
	public final Label errorLabel = new Label("");
	public final TextField textLocation = new TextField();
	public final ComboBox<String> dropdown = new ComboBox<String>();
	public final TextField textAmount = new TextField();
	public final Button doneButton = new Button ("Done");
	public final Button addMore = new Button("Add a new expense");
	
	public NewExpenseView() {
		this.setPrefSize(400, 570);
		 errorLabel.setTextFill(Color.web("#FF3B77"));
		this.setStyle("-fx-background-color: #EDF8FF;"
				+ " -fx-font-family: \"Roboto\"; "
				+ "-fx-font-size: 15px;-fx-font-weight: bold;");
		this.setSpacing(24.0);
		HBox hbox = new HBox();
		Label image = new Label();
		image.setGraphic(new ImageView("BuyG.png"));
		hbox.setAlignment(Pos.BASELINE_RIGHT);
		hbox.getChildren().add(image);
		Text t2 = new Text("Select the category it belongs to.");
		t2.setTextAlignment(TextAlignment.LEFT);
		t2.maxWidth(200);
		dropdown.getItems().add("Groceries");
		dropdown.getItems().add("Transportation");
		dropdown.getItems().add("Entertainment");
		dropdown.getItems().add("Home");
		dropdown.getItems().add("Health");
		dropdown.getItems().add("Personal Shopping");
		dropdown.getItems().add("Education");
		dropdown.getItems().add("Other");
		dropdown.getSelectionModel().selectFirst();
		dropdown.setMaxWidth(280);
		dropdown.setStyle("-fx-background-color: transparent;");
		this.setAlignment(Pos.CENTER);
		Text t3 = new Text("Where does it come from ?");
		Text t4 = new Text("How much did you spend ?");
		t3.setTextAlignment(TextAlignment.LEFT);
		t4.setTextAlignment(TextAlignment.LEFT);
        this.getChildren().addAll(hbox, errorLabel, t3, textLocation, t4, textAmount, t2, dropdown, addMore, doneButton);
        
        // Where
        textLocation.setMaxWidth(280);
        textLocation.setMinHeight(40);
		// Amount
        textAmount.setMaxWidth(280);
        textAmount.setMinHeight(40);
        
        // Add more expense
        addMore.setPrefHeight(40);
        addMore.setMaxWidth(280);
        addMore.setStyle("-fx-background-color: #0000ff;"
        		+ " -fx-text-fill: #ffffff;"
        		+ "-fx-background-radius: 6.4, 4, 5, 3;");
		// Done Button
        doneButton.setPrefHeight(40);
        doneButton.setMaxWidth(280);
        doneButton.setStyle("-fx-background-color: #0000ff;"
        		+ " -fx-text-fill: #ffffff;"
        		+ "-fx-background-radius: 6.4, 4, 5, 3;");
	}
	
	
}
