package application;

import java.text.NumberFormat;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class InfoView extends Pane{
	Color forText = Color.rgb(13, 140, 255);
	NumberFormat format = NumberFormat.getCurrencyInstance();
	public InfoView(String s){
		
		this.setBackground(new Background(new BackgroundFill(Color.rgb(217, 228, 255), CornerRadii.EMPTY, null)));
		
		Text title = new Text(s);
		ObservableList<String> list = FXCollections.observableArrayList();

		title.setFont(Font.font("Open Sans", 30));
		title.setStroke(forText);
		title.setFill(forText);
		double[] array = null;
		Text about = new Text("");
		if(s.equals("Goal")){
			array = Main.model.getWorkingWith().getDailySpent(Main.model.getWorkingWith().getWeekList());
			about.setText("You have saved: " + format.format((Main.model.getWorkingWith().getCarryOver() + 
					(Main.model.getWorkingWith().getBudget().getWeeklyEarnings() - 
							Main.model.getWorkingWith().getSpent()
							- Main.model.getWorkingWith().getBudget().getRent()))) + "/ " + format.format(Main.model.getWorkingWith().getBudget().getGoal().getGoal()) + "\nKeep saving for: " + Main.model.getWorkingWith().getBudget().getGoal().getGoalName());
			ArrayList<Purchase> arrayList = Main.model.getWorkingWith().getWeekList();
			for(int i = 0; i < arrayList.size(); i++){
				list.add(arrayList.get(i).toString());
			}
		}
		else if(s.equals("Groceries")){
			array = Main.model.getWorkingWith().getDailySpent(Main.model.getWorkingWith().getGroceriesList());
			about.setText("You are currently spending: " + format.format(Main.model.getWorkingWith().getSpentOnGroceries())+ "/ " + format.format(Main.model.getWorkingWith().getBudget().getGroceries()));
			ArrayList<Purchase> arrayList = Main.model.getWorkingWith().getGroceriesList();
			for(int i = 0; i < arrayList.size(); i++){
				list.add(arrayList.get(i).toString());
			}
		}
		else if(s.equals("Transportation")){
			array = Main.model.getWorkingWith().getDailySpent(Main.model.getWorkingWith().getTransportationList());
			about.setText("You are currently spending: " + format.format(Main.model.getWorkingWith().getSpentOnTransportation())+ "/ " + format.format(Main.model.getWorkingWith().getBudget().getGas()));
			ArrayList<Purchase> arrayList = Main.model.getWorkingWith().getTransportationList();
			for(int i = 0; i < arrayList.size(); i++){
				list.add(arrayList.get(i).toString());
			}
		}
		else if(s.equals("Entertainment")){
			array = Main.model.getWorkingWith().getDailySpent(Main.model.getWorkingWith().getEntertainmentList());
			about.setText("You are currently spending: " + format.format(Main.model.getWorkingWith().getSpentOnEntertainment())+ "/ " + format.format(Main.model.getWorkingWith().getBudget().getEntertainment()));
			ArrayList<Purchase> arrayList = Main.model.getWorkingWith().getEntertainmentList();
			for(int i = 0; i < arrayList.size(); i++){
				list.add(arrayList.get(i).toString());
			}
		}
		else if(s.equals("Home")){
			array = Main.model.getWorkingWith().getDailySpent(Main.model.getWorkingWith().getHomeList());
			about.setText("You are currently spending: " + format.format(Main.model.getWorkingWith().getSpentOnHome())+ "/ " + format.format(Main.model.getWorkingWith().getBudget().getHome()));
			ArrayList<Purchase> arrayList = Main.model.getWorkingWith().getHomeList();
			for(int i = 0; i < arrayList.size(); i++){
				list.add(arrayList.get(i).toString());
			}
		}
		else if(s.equals("Health")){
			array = Main.model.getWorkingWith().getDailySpent(Main.model.getWorkingWith().getHealthList());
			about.setText("You are currently spending: " + format.format(Main.model.getWorkingWith().getSpentOnHealth())+ "/ " + format.format(Main.model.getWorkingWith().getBudget().getHealth()));
			ArrayList<Purchase> arrayList = Main.model.getWorkingWith().getHealthList();
			for(int i = 0; i < arrayList.size(); i++){
				list.add(arrayList.get(i).toString());
			}
		}
		else if(s.equals("Personal")){
			array = Main.model.getWorkingWith().getDailySpent(Main.model.getWorkingWith().getPersonalList());
			System.out.println("Test");
			about.setText("You are currently spending: " + format.format(Main.model.getWorkingWith().getSpentOnPersonal())+ "/ " + format.format(Main.model.getWorkingWith().getBudget().getPersonal()));
			ArrayList<Purchase> arrayList = Main.model.getWorkingWith().getPersonalList();
			for(int i = 0; i < arrayList.size(); i++){
				list.add(arrayList.get(i).toString());
			}
		}
		else if(s.equals("Education")){
			array = Main.model.getWorkingWith().getDailySpent(Main.model.getWorkingWith().getEducationList());
			about.setText("You are currently spending: " + format.format(Main.model.getWorkingWith().getSpentOnEducation())+ "/ " + format.format(Main.model.getWorkingWith().getBudget().getEducation()));
			ArrayList<Purchase> arrayList = Main.model.getWorkingWith().getEducationList();
			for(int i = 0; i < arrayList.size(); i++){
				list.add(arrayList.get(i).toString());
			}
		}
		else if(s.equals("Other")){
			array = Main.model.getWorkingWith().getDailySpent(Main.model.getWorkingWith().getOtherList());
			about.setText("You are currently spending: " + format.format(Main.model.getWorkingWith().getSpentOnOther())+ "/ " + format.format(Main.model.getWorkingWith().getBudget().getOther()));
			ArrayList<Purchase> arrayList = Main.model.getWorkingWith().getOtherList();
			for(int i = 0; i < arrayList.size(); i++){
				list.add(arrayList.get(i).toString());
			}
		}
		
		about.setFont(Font.font("Open Sans", 14));
		about.setStroke(forText);
		about.setFill(forText);
		about.setTextAlignment(TextAlignment.CENTER);

		LineGraph line = new LineGraph("Spent this week", "", array);
		
        ListView<String> lv = new ListView<>(list);
        lv.setCellFactory(param -> new XCell());

		Text expensesTitle = new Text("Expenses");
		expensesTitle.setFont(Font.font("Open Sans", 30));
		expensesTitle.setStroke(forText);
		expensesTitle.setFill(forText);

		
		VBox vbox = new VBox(50);
		VBox aboutBox = new VBox(5);
		VBox helpBox = new VBox(5);

		aboutBox.getChildren().addAll(title, about, line);
		aboutBox.setMinHeight(350);
		helpBox.getChildren().addAll(expensesTitle, lv);
		helpBox.setBackground(new Background(new BackgroundFill(Color.rgb(217, 228, 255), CornerRadii.EMPTY, null)));
		vbox.getChildren().addAll(aboutBox, helpBox);
		vbox.setPadding(new Insets(10, 10, 10, 10));
		vbox.setAlignment(Pos.CENTER);
		vbox.setPrefWidth(400);
		vbox.setPrefHeight(570);
		aboutBox.setAlignment(Pos.CENTER);
		helpBox.setAlignment(Pos.CENTER);
		this.getChildren().add(vbox);
		
	}
}
