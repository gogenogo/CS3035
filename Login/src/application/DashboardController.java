package application;

import application.InteractionModel.Displayed;
import application.Purchase.Category;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashboardController {	
	public BorderPane b1 = new BorderPane();
	
	//Scene scene = new Scene(b1,400,750);
	//Scene expense = new Scene(Main.expenseview, 400, 720);
	public DashboardController() {
		b1.setStyle("-fx-background-color: #EDF8FF;"
				+ " -fx-font-family: \"Roboto\";"
				+ " -fx-font-size: 12px;"
				+ "-fx-font-weight: bold;");
		b1.setCenter(Main.dashview);
		Main.dashview.addExpenses.setOnAction(e -> {
			Stage oldStage = (Stage) Main.tbView.getScene().getWindow();
			oldStage.close();
			VBox v = new VBox();
			v.getChildren().addAll(Main.tbView, Main.expenseview);
			Main.iModel.setDisplayed(Displayed.PURCHASE);
			Scene expense = new Scene(v, 400, 600);
			Stage newStage = new Stage();
			newStage.setScene(expense);
			newStage.show();
		});
		
		expensePage();
	}
	
	public void expensePage() {
		Main.expenseview.doneButton.setOnAction(e -> {
			// Check to see if all fields are answered
			try{
				submitPurchase();
				Main.iModel.setDisplayed(Displayed.DASHBOARD);
				showView();
			}
			catch(Exception exception){
				Main.expenseview.errorLabel.setText("Make sure to put in a number in for how much it is!");
			}
		});
		Main.expenseview.addMore.setOnAction(e -> {
			// Check to see if all fields are answered
			try{
				submitPurchase();
				Main.expenseview.textAmount.setText("");
				Main.expenseview.textLocation.setText("");
			}
			catch(Exception exception){
				Main.expenseview.errorLabel.setText("Make sure to put in a number in for how much it is!");
			}
		});
	}
	
	public void showView(){
		VBox vbox = new VBox();
		Stage oldStage =(Stage)Main.tbView.getScene().getWindow();
		oldStage.close();
		vbox.getChildren().addAll(Main.tbView, Main.dashview);
		Scene scene =  new Scene(vbox,400,780);
		vbox.setPrefSize(400,780);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
	    primaryStage.setResizable(false);

		primaryStage.show();
	}
	
	public void submitPurchase(){
		double text0 = Double.parseDouble(Main.expenseview.textAmount.getText());
		String text1 = Main.expenseview.textLocation.getText();
		int text1length = text1.length();
		
		if (text0 == 0 || text1length == 0) {
			Main.expenseview.errorLabel.setText("Uh oh, you forgot to fill in a part.");
		} 
		else {
			//Save new purchase to db
			Category c = null;
			String s = Main.expenseview.dropdown.getValue();
			if(s.equals("Groceries")){
				c = Category.GROCERIES;
			}
			else if(s.equals("Transportation")){
				c = Category.GAS;
			}
			else if(s.equals("Entertainment")){
				c = Category.ENTERTAINMENT;
			}
			else if(s.equals("Home")){
				c = Category.HOME;
			}
			else if(s.equals("Health")){
				c = Category.HEALTH;
			}
			else if(s.equals("Personal Shopping")){
				c = Category.PERSONAL;
			}
			else if(s.equals("Education")){
				c = Category.EDUCATION;
			}
			else if(s.equals("Other")){
				c = Category.OTHER;
			}
			Purchase newPurchase = new Purchase(c, text0, text1);



			if (Main.model.db.addPurchase(c.name(), Main.model.getWorkingWith().getID(),newPurchase.getDate(), text0, text1)){
				Main.model.getWorkingWith().addPurchases(newPurchase);
				Main.dashview.draw();
				System.out.println("WORKED");
			}
			else {
				System.out.println("ERROR!!! FAIL!!! FIX IT!!!");
			}			
		}
	}
}
