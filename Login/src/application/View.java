package application;


import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class View extends Pane{
	private VBox bp;
	public ImageView logo;
	public ImageView addButton;
	public View(){
		bp = new VBox(30);
		bp.setPrefSize(400,570);
		draw();
	}
	
	public void draw(){
		GridPane avatars = new GridPane();
		ArrayList<User> users = Main.model.getUsersList();
		BackgroundFill bgf = new BackgroundFill(Color.rgb(217, 228, 255), CornerRadii.EMPTY, Insets.EMPTY);
		this.setBackground(new Background(bgf)); 
		Image logoPic = new Image("SharktLogo.png");
		logo = new ImageView(logoPic);
		logo.setFitHeight(100); 
		logo.setFitWidth(100);
		
		for(int i = 1; i<=users.size() + 1; i++){
			VBox vbox = new VBox();
			ImageView c;
			Label l;
			if(i == users.size() + 1){
				l = new Label("Add new");
				l.setFont(Font.font("Open Sans", 14));
				l.setTextFill(Main.forText);
				addButton = new ImageView(new Image("addButton.png"));
				
				addButton.setFitHeight(60); 
				addButton.setFitWidth(60);
				vbox.setAlignment(Pos.CENTER);
				vbox.getChildren().addAll(addButton, l); 
			}
			else{
				l = new Label(users.get(i-1).getName());
				c = users.get(i-1).getIcon();
				c.setFitHeight(60); 
				c.setFitWidth(60);
				c.setEffect(users.get(i - 1).getIcon().getEffect());
				l.setFont(Font.font("Open Sans", 14));
				l.setTextFill(Main.forText);
				vbox.setAlignment(Pos.CENTER);
				vbox.getChildren().addAll(c, l); 
			}
			
			if(i <= 6){
			vbox.setPadding(new Insets(12,12,5,5));
			avatars.add(vbox, (i- 1)%3, (i-1)/3);
			}
		}
		avatars.setAlignment(Pos.CENTER);
		avatars.setPadding(new Insets(5));
		
		Label welcome = new Label("Welcome to Sharkt!");
		welcome.setFont(Font.font("Open Sans", 30));
		welcome.setTextFill(Main.forText);
		Label info = new Label("Select account:");
		info.setFont(Font.font("Open Sans", 15));
		info.setTextFill(Main.forText);
		VBox infoBox = new VBox(5);
		infoBox.setAlignment(Pos.CENTER);
		infoBox.getChildren().addAll(info, avatars);
		bp.getChildren().addAll(logo, welcome, infoBox);
		bp.setAlignment(Pos.CENTER);
		this.getChildren().add(bp);
	}
}
