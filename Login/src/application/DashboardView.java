package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DashboardView extends GridPane {
	
	public final Button addExpenses = new Button("Add a new expense");

	public DashboardView() {
		this.setStyle("-fx-background-color: #FFFFFF;");
		this.setAlignment(Pos.CENTER);
		CWidget goal = new CWidget(100, 100, 100.0);
		CWidget shopping = new CWidget(80, 80, 25.0);
		CWidget Education = new CWidget(80, 80, 25.0);
		CWidget Entertainment = new CWidget(80, 80, 30.0);
		CWidget Utilities = new CWidget(80, 80, 50.0);
		CWidget Health = new CWidget(80, 80, 45.0);
		CWidget Transportation = new CWidget(80, 80, 75.0);
		CWidget Other = new CWidget(80, 80, 50.0);
		CWidget Other1 = new CWidget(80, 80, 45.0);
		CWidget Other2 = new CWidget(80, 80, 75.0);
		Label header = new Label ("Goal");
		header.setStyle("-fx-font-size: 20px;-fx-font-weight: bold;");
		Label l1 = new Label("Groceries");
		Label l2 = new Label("Transportation");
		Label l3 = new Label("Entertainment");
		Label l4 = new Label("Home");
		Label l5 = new Label("Health");
		Label l6 = new Label("Personal Shopping");
		Label l7 = new Label("Education");
		Label l8 = new Label("Other");
		Label l9 = new Label("Other2");
		
		//double spentThisWeek = Main.model.getWorkingWith().getBudget().getGroceries() - Main.model.getWorkingWith().getSpentGroceries();
		//Label t1 = new Label("$" + spentThisWeek);
		Label t1 = new Label("10.50$");
		Label t2 = new Label("10.50$");
		Label t3 = new Label("10.50$");
		Label t4 = new Label("10.50$");
		Label t5 = new Label("10.50$");
		Label t6 = new Label("10.50$");
		Label t7 = new Label("10.50$");
		Label t8 = new Label("10.50$");
		Label t9 = new Label("10.50$");
		Label goalTotal = new Label("500.00$");
		goalTotal.setAlignment(Pos.CENTER);
		VBox vbox = new VBox(8);
		// GOAL
		HBox headerbox = new HBox(0);
		headerbox.getChildren().add(header);
		headerbox.setAlignment(Pos.CENTER);
		// GOAL
		HBox hgoal = new HBox(0);
		hgoal.setMinHeight(80);
		hgoal.getChildren().add(goal);
		hgoal.setAlignment(Pos.CENTER);
		// ROW 0
		HBox row0 = new HBox(24);
		VBox rCol0 = new VBox(4);
		VBox rCol1 = new VBox(4);
		VBox rCol2 = new VBox(4);
		rCol0.setAlignment(Pos.CENTER);
		rCol1.setAlignment(Pos.CENTER);
		rCol2.setAlignment(Pos.CENTER);
		rCol0.setMinHeight(120);
		rCol1.setMinHeight(120);
		rCol2.setMinHeight(120);
		rCol0.getChildren().addAll(shopping, t1, l1);
		rCol1.getChildren().addAll(Education, t2, l2);
		rCol2.getChildren().addAll(Entertainment, t3, l3);
		row0.getChildren().addAll(rCol0, rCol1, rCol2);
		// ROW 1
		HBox row1 = new HBox(24);
		VBox r1Col0 = new VBox(4);
		VBox r1Col1 = new VBox(4);
		VBox r1Col2 = new VBox(4);
		r1Col0.setAlignment(Pos.CENTER);
		r1Col1.setAlignment(Pos.CENTER);
		r1Col2.setAlignment(Pos.CENTER);
		r1Col0.setMinHeight(120);
		r1Col1.setMinHeight(120);
		r1Col2.setMinHeight(120);
		r1Col0.getChildren().addAll(Utilities, t4, l4);
		r1Col1.getChildren().addAll(Health, t5, l5);
		r1Col2.getChildren().addAll(Transportation, t6, l6);
		row1.getChildren().addAll(r1Col0, r1Col1, r1Col2);
		
		// ROW 2
		HBox row2 = new HBox(24);
		VBox r2Col0 = new VBox(4);
		VBox r2Col1 = new VBox(4);
		VBox r2Col2 = new VBox(4);
		r2Col0.setAlignment(Pos.CENTER);
		r2Col1.setAlignment(Pos.CENTER);
		r2Col2.setAlignment(Pos.CENTER);
		r2Col0.setMinHeight(120);
		r2Col1.setMinHeight(120);
		r2Col2.setMinHeight(120);
		r2Col0.getChildren().addAll(Other, t7, l7);
		r2Col1.getChildren().addAll(Other1, t8, l8);
		r2Col2.getChildren().addAll(Other2, t9, l9);
		row2.getChildren().addAll(r2Col0, r2Col1, r2Col2);
		
		// ADD BUTTON
		HBox addExp = new HBox();
		addExp.getChildren().add(addExpenses);
		addExp.setAlignment(Pos.CENTER);
		//addExp.setMinHeight(60);
		vbox.getChildren().addAll(hgoal, headerbox, goalTotal, row0, row1, row2, addExp);
		

		addExpenses.setMinWidth(280);
		addExpenses.setPrefHeight(40);
        addExpenses.setStyle("-fx-background-color: #0000ff;"
        		+ " -fx-text-fill: #ffffff;"
        		+ "-fx-background-radius: 6.4, 4, 5, 3;"
        		+ "-fx-font-size: 14px;-fx-font-weight: bold;");
		this.add(vbox, 0, 0);
		this.setMinSize(400, 650);
	}

}
