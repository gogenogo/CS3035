package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AccountView extends Pane{
	private AccountModel aModel;
	public Button confirmButton;
	
	public Label label1;
	public TextField textField1;
	public Label label2;
	public TextField textField2;
	public Label label3;
	public TextField textField3;
	public Label label4;
	public TextField textField4;
	public Label label5;
	public TextField textField5;
	public Label label6;
	public TextField textField6;
	public Label label7;
	public TextField textField7;
	public Label label8;
	public TextField textField8;
	public Label label9;
	public TextField textField9;
	public Label label10;
	public TextField textField10;
	public Label label11;
	public TextField textField11;
	public Label label12;
	public TextField textField12;
	public Label label13;
	
	
	public Label goalNameLabel;
	public TextField goalNameField;
	
	public PasswordField pass1;
	public PasswordField pass2;
	public Label errorLabel;
	public Button backButton;
	private VBox vbox;
	private HBox hbox;
	
	public AccountView(AccountModel modelIn){
		this.setBackground(new Background(new BackgroundFill(Color.rgb(217, 228, 255), CornerRadii.EMPTY, null)));
		aModel = modelIn;
		confirmButton = new Button("Confirm");
		backButton = new Button("Back");
		String[] questions = aModel.getQuestion();
		goalNameLabel = new Label("What are you saving the money for?");
		goalNameField = new TextField();
		goalNameLabel.setFont(Font.font("Open Sans", 14));
		goalNameLabel.setTextFill(Main.forText);
		label1 = new Label(questions[0]);
		label1.setFont(Font.font("Open Sans", 14));
		label1.setTextFill(Main.forText);
		textField1 = new TextField();
		label2 = new Label();
		label2.setFont(Font.font("Open Sans", 14));
		label2.setTextFill(Main.forText);
		textField2 = new TextField();
		label3 = new Label();
		label3.setFont(Font.font("Open Sans", 14));
		label3.setTextFill(Main.forText);
		textField3 = new TextField();
		label4 = new Label();
		label4.setFont(Font.font("Open Sans", 14));
		label4.setTextFill(Main.forText);
		textField4 = new TextField();
		label5 = new Label();
		label5.setFont(Font.font("Open Sans", 14));
		label5.setTextFill(Main.forText);
		textField5 = new TextField();
		label6 = new Label();
		label6.setFont(Font.font("Open Sans", 14));
		label6.setTextFill(Main.forText);
		textField6 = new TextField();
		label7 = new Label();
		label7.setFont(Font.font("Open Sans", 14));
		label7.setTextFill(Main.forText);
		textField7 = new TextField();
		label8 = new Label();
		label8.setFont(Font.font("Open Sans", 14));
		label8.setTextFill(Main.forText);
		textField8 = new TextField();
		label9 = new Label();
		label9.setFont(Font.font("Open Sans", 14));
		label9.setTextFill(Main.forText);
		textField9 = new TextField();
		label10 = new Label();
		label10.setFont(Font.font("Open Sans", 14));
		label10.setTextFill(Main.forText);
		textField10 = new TextField();
		label11 = new Label();
		label11.setFont(Font.font("Open Sans", 14));
		label11.setTextFill(Main.forText);
		textField11 = new TextField();
		label12 = new Label();
		label12.setFont(Font.font("Open Sans", 14));
		label12.setTextFill(Main.forText);
		textField12 = new TextField();
		label13 = new Label();
		label13.setFont(Font.font("Open Sans", 14));
		label13.setTextFill(Main.forText);
		
		errorLabel = new Label("");
		errorLabel.setFont(Font.font("Open Sans", 14));
		errorLabel.setTextFill(Color.RED);
		pass1 = new PasswordField();
		pass2 = new PasswordField();

		redraw(0);
	}
	
	public void redraw(int count){
		if(count == 0){
			vbox = new VBox(5);
			hbox = new HBox(5);
			errorLabel.setText("");
			String[] questions = aModel.getQuestion();
			label1.setText(questions[0]);
			hbox.getChildren().clear();
			vbox.getChildren().clear();
			hbox.getChildren().addAll(errorLabel, backButton, confirmButton);
			hbox.setAlignment(Pos.CENTER_RIGHT);
			vbox.setAlignment(Pos.CENTER);
			vbox.getChildren().addAll(label1,pass1, pass2, hbox);
			vbox.setPrefSize(400, 570);
			vbox.setPadding(new Insets(15));
			this.getChildren().clear();
			this.getChildren().add(vbox);
		}
		else if(count == 1){
			String[] questions = aModel.getQuestion();
			errorLabel.setText("");
			label1.setText(questions[1]);
			label2.setText(questions[2]);
			label3.setText(questions[3]);
			label4.setText(questions[4]);
			hbox.getChildren().clear();
			vbox.getChildren().clear();
			backButton.setVisible(true);
			hbox.getChildren().addAll(errorLabel, backButton, confirmButton);
			hbox.setAlignment(Pos.CENTER_RIGHT);
			vbox.setAlignment(Pos.CENTER);
			vbox.getChildren().addAll(label1,textField1, label2,textField2, label3,textField3,goalNameLabel, goalNameField, label4,textField4, hbox);
			vbox.setPrefSize(400, 570);
			vbox.setPadding(new Insets(15));
			this.getChildren().clear();
			this.getChildren().add(vbox);
		}
		else if(count == 2){
			String[] questions = aModel.getQuestion();
			Label title = new Label("How much do you spend a week on...");
			title.setFont(Font.font("Open Sans", 18));
			title.setTextFill(Main.forText);
			errorLabel.setText("");
			label5.setText(questions[5]);
			label6.setText(questions[6]);
			label7.setText(questions[7]);
			label8.setText(questions[8]);
			label9.setText(questions[9]);
			label10.setText(questions[10]);
			label11.setText(questions[11]);
			label12.setText(questions[12]);
			hbox.getChildren().clear();
			vbox.getChildren().clear();
			backButton.setVisible(true);
			hbox.getChildren().addAll(errorLabel, backButton, confirmButton);
			hbox.setAlignment(Pos.CENTER_RIGHT);
			vbox.setAlignment(Pos.CENTER);
			
			VBox allQuestions = new VBox(15);
			
			VBox q5 = new VBox();
			q5.getChildren().addAll(label5, textField5);
			q5.setAlignment(Pos.CENTER);
			allQuestions.getChildren().add(q5);
			VBox q6 = new VBox();
			q6.getChildren().addAll(label6, textField6);
			q6.setAlignment(Pos.CENTER);
			allQuestions.getChildren().add(q6);
			VBox q7 = new VBox();
			q7.getChildren().addAll(label7, textField7);
			q7.setAlignment(Pos.CENTER);
			allQuestions.getChildren().add(q7);
			
			VBox q8 = new VBox();
			q8.getChildren().addAll(label8, textField8);
			q8.setAlignment(Pos.CENTER);
			allQuestions.getChildren().add(q8);
			VBox q9 = new VBox();
			q9.getChildren().addAll(label9, textField9);
			q9.setAlignment(Pos.CENTER);
			allQuestions.getChildren().add(q9);
			VBox q10 = new VBox();
			q10.getChildren().addAll(label10, textField10);
			q10.setAlignment(Pos.CENTER);
			allQuestions.getChildren().add(q10);
			
			VBox q11 = new VBox();
			q11.getChildren().addAll(label11, textField11);
			q11.setAlignment(Pos.CENTER);
			allQuestions.getChildren().add(q11);
			VBox q12 = new VBox();
			q12.getChildren().addAll(label12, textField12);
			q12.setAlignment(Pos.CENTER);
			allQuestions.getChildren().add(q12);
			
			vbox.getChildren().addAll(title, allQuestions, hbox);
			vbox.setPrefSize(400, 570);
			vbox.setPadding(new Insets(15));
			this.getChildren().clear();
			this.getChildren().add(vbox);
		}
		else if(count == 3){
			String[] questions = aModel.getQuestion();
			errorLabel.setText("");
			
			label13.setText(questions[0]);
			label1.setText(questions[1]);
			label2.setText(questions[2]);
			label3.setText(questions[3]);
			label4.setText(questions[4]);
			pass1.setText(Main.model.getWorkingWith().getPassword());
			pass2.setText(Main.model.getWorkingWith().getPassword());
			textField1.setText(Main.model.getWorkingWith().getName());
			textField2.setText(Main.model.getWorkingWith().getBudget().getWeeklyEarnings() + "");
			textField3.setText(Main.model.getWorkingWith().getBudget().getGoal().getGoal() + "");
			textField4.setText(Main.model.getWorkingWith().getBudget().getRent() + "");
			goalNameField.setText(Main.model.getWorkingWith().getBudget().getGoal().getGoalName() + "");

			hbox.getChildren().clear();
			vbox.getChildren().clear();
			backButton.setVisible(false);
			hbox.getChildren().addAll(errorLabel, confirmButton);
			hbox.setAlignment(Pos.CENTER_RIGHT);
			vbox.setAlignment(Pos.CENTER);
			vbox.getChildren().addAll(label13, pass1, pass2, label1,textField1, label2,textField2, label3,textField3, goalNameLabel, goalNameField, label4,textField4, hbox);
			vbox.setPrefSize(400, 570);
			vbox.setPadding(new Insets(15));
			this.getChildren().clear();
			this.getChildren().add(vbox);
		}
		else if(count == 4){
			String[] questions = aModel.getQuestion();
			Label title = new Label("How much do you spend a week on...");
			title.setFont(Font.font("Open Sans", 18));
			title.setTextFill(Main.forText);
			errorLabel.setText("");
			label5.setText(questions[5]);
			label6.setText(questions[6]);
			label7.setText(questions[7]);
			label8.setText(questions[8]);
			label9.setText(questions[9]);
			label10.setText(questions[10]);
			label11.setText(questions[11]);
			label12.setText(questions[12]);
			textField5.setText(Main.model.getWorkingWith().getBudget().getGroceries() + "");
			textField6.setText(Main.model.getWorkingWith().getBudget().getGas() + "");
			textField7.setText(Main.model.getWorkingWith().getBudget().getEntertainment() + "");
			textField8.setText(Main.model.getWorkingWith().getBudget().getHome() + "");
			textField9.setText(Main.model.getWorkingWith().getBudget().getHealth() + "");
			textField10.setText(Main.model.getWorkingWith().getBudget().getPersonal() + "");
			textField11.setText(Main.model.getWorkingWith().getBudget().getEducation() + "");
			textField12.setText(Main.model.getWorkingWith().getBudget().getOther() + "");

			
			hbox.getChildren().clear();
			vbox.getChildren().clear();
			backButton.setVisible(false);
			hbox.getChildren().addAll(errorLabel, backButton, confirmButton);
			hbox.setAlignment(Pos.CENTER_RIGHT);
			vbox.setAlignment(Pos.CENTER);
			
			VBox allQuestions = new VBox(15);
			
			VBox q5 = new VBox();
			q5.getChildren().addAll(label5, textField5);
			q5.setAlignment(Pos.CENTER);
			allQuestions.getChildren().add(q5);
			VBox q6 = new VBox();
			q6.getChildren().addAll(label6, textField6);
			q6.setAlignment(Pos.CENTER);
			allQuestions.getChildren().add(q6);
			VBox q7 = new VBox();
			q7.getChildren().addAll(label7, textField7);
			q7.setAlignment(Pos.CENTER);
			allQuestions.getChildren().add(q7);
			
			VBox q8 = new VBox();
			q8.getChildren().addAll(label8, textField8);
			q8.setAlignment(Pos.CENTER);
			allQuestions.getChildren().add(q8);
			VBox q9 = new VBox();
			q9.getChildren().addAll(label9, textField9);
			q9.setAlignment(Pos.CENTER);
			allQuestions.getChildren().add(q9);
			VBox q10 = new VBox();
			q10.getChildren().addAll(label10, textField10);
			q10.setAlignment(Pos.CENTER);
			allQuestions.getChildren().add(q10);
			
			VBox q11 = new VBox();
			q11.getChildren().addAll(label11, textField11);
			q11.setAlignment(Pos.CENTER);
			allQuestions.getChildren().add(q11);
			VBox q12 = new VBox();
			q12.getChildren().addAll(label12, textField12);
			q12.setAlignment(Pos.CENTER);
			allQuestions.getChildren().add(q12);
			
			vbox.getChildren().addAll(title, allQuestions, hbox);
			vbox.setPrefSize(400, 570);
			vbox.setPadding(new Insets(15));
			this.getChildren().clear();
			this.getChildren().add(vbox);
		}	
	}
}
