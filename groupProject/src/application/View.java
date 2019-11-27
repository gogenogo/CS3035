package application;


import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class View extends Pane{
	private BorderPane bp;
	public ImageView logo;
	public ImageView addButton;
	public View(){
		bp = new BorderPane();
		bp.setPrefSize(400,600);
		draw();
	}

	public void draw(){
		GridPane avatars = new GridPane();
		ArrayList<User> users = Main.model.getUsersList();
		BackgroundFill bgf = new BackgroundFill(Color.rgb(237, 248, 255), CornerRadii.EMPTY, Insets.EMPTY);
		this.setBackground(new Background(bgf));
		Image logoPic = new Image("SharktLogo.png");
		logo = new ImageView(logoPic);
		logo.setFitHeight(80);
		logo.setFitWidth(80);
		BorderPane.setAlignment(logo, Pos.CENTER);
	    BorderPane.setMargin(logo, new Insets(12,12,12,12));
		bp.setTop(logo);

		for(int i = 1; i<=users.size() + 1; i++){
			VBox vbox = new VBox();
			BorderPane.setAlignment(vbox, Pos.CENTER);
			ImageView c;
			Label l;
			if(i == users.size() + 1){
				l = new Label("Add new");
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
				vbox.setAlignment(Pos.CENTER);
				vbox.getChildren().addAll(c, l);
			}


			vbox.setPadding(new Insets(12,12,5,5));
			avatars.add(vbox, (i- 1)%2, (i-1)/2);
		}
		avatars.setAlignment(Pos.CENTER);
		avatars.setPadding(new Insets(5));
		bp.setBottom(avatars);

		Label welcome = new Label("Welcome to _______!");
		Label info = new Label("Select account:");
		VBox infoBox = new VBox();
		infoBox.setAlignment(Pos.CENTER);
		infoBox.getChildren().addAll(welcome,info);
		BorderPane.setAlignment(infoBox, Pos.CENTER);
		bp.setCenter(infoBox);

		this.getChildren().add(bp);
	}
}
