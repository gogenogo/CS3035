package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class AboutView extends Pane{
	Color forText = Color.rgb(13, 140, 255);

	public AboutView(){
		
		this.setBackground(new Background(new BackgroundFill(Color.rgb(217, 228, 255), CornerRadii.EMPTY, null)));
		
		Text aboutTitle = new Text("About Us");
		aboutTitle.setFont(Font.font("Open Sans", 30));
		aboutTitle.setStroke(forText);
		aboutTitle.setFill(forText);
		
		Text about = new Text("Sharkt is a budgeting app to help you save money to\nmake your dreams a reality! The application was\ncreated by: Catherine Higgins, Cassandra Wendlandt-\nBloodsworth, and Connor Wilson.\nHappy saving!");
		about.setFont(Font.font("Open Sans", 14));
		about.setStroke(forText);
		about.setFill(forText);
		about.setTextAlignment(TextAlignment.CENTER);

		ImageView logo = new ImageView("SharktLogo.png");
		
		Text helpTitle = new Text("Help");
		helpTitle.setFont(Font.font("Open Sans", 30));
		helpTitle.setStroke(forText);
		helpTitle.setFill(forText);

		Text help = new Text(
				"At the top of the dashboard, the large widget displays\n"
				+ "how close you are to reaching your goal. As you spend\n"
				+ "more money, the circles on the dashboard will go\n"
				+ "down. If you want to see more details about your\n"
				+ "budget, click on the widgets. To record a new\n"
				+ "purchase, click on the button at the bottom of\n"
				+ "the dashboard or the option from the menu in the top\n"
				+ "lefthand corner You can also add diary entries or\n"
				+ "change budget/account details from the menu.");
		help.setFont(Font.font("Open Sans", 14));
		help.setStroke(forText);
		help.setFill(forText);
		help.setTextAlignment(TextAlignment.CENTER);
		VBox vbox = new VBox(50);
		VBox aboutBox = new VBox(5);
		VBox helpBox = new VBox(5);

		aboutBox.getChildren().addAll(aboutTitle, about);
		helpBox.getChildren().addAll(helpTitle, help);
		vbox.getChildren().addAll(aboutBox, logo, helpBox);
		vbox.setPadding(new Insets(10, 10, 10, 10));
		vbox.setAlignment(Pos.CENTER);
		vbox.setPrefWidth(400);
		vbox.setPrefHeight(570);
		aboutBox.setAlignment(Pos.CENTER);
		helpBox.setAlignment(Pos.CENTER);
		this.getChildren().add(vbox);
		
	}
}
