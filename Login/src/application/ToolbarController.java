package application;


import java.util.Optional;

import application.InteractionModel.Displayed;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ToolbarController {
	private ToolbarView tbView;
	public ToolbarController(ToolbarView newView){
		tbView = newView;
		tbView.addPurchase.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Main.iModel.setDisplayed(Displayed.PURCHASE);
				Stage stage = (Stage) tbView.getScene().getWindow();
				VBox newBox = new VBox();
				newBox.getChildren().addAll(tbView, Main.expenseview);
				Scene newScene = new Scene(newBox, 400, 600);
				Stage newStage = new Stage();
				newStage.setScene(newScene);
				stage.close();
				newStage.show();
			    newStage.setResizable(false);

				
			}
		});
		
		tbView.addDiary.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Add Diary Clicked");
				Main.iModel.setDisplayed(Displayed.OTHER);

			}
		});
		
		tbView.changeBudget.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				AccountModel accModel = new AccountModel();
				AccountView accView = new AccountView(accModel);
				AccountController accControl = new AccountController(accView, accModel, 4);
				VBox vbox = new VBox();
				Stage oldStage = (Stage) tbView.getScene().getWindow();
				vbox.getChildren().addAll(tbView, accView);
				Stage newStage = new Stage();
				Scene newScene = new Scene(vbox, 400, 600);
				

				oldStage.close();
				newStage.setScene(newScene);
			    newStage.setResizable(false);
				newStage.show();
				Main.iModel.setDisplayed(Displayed.OTHER);
				

				
			}
		});
		
		tbView.accountSettings.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				AccountModel accModel = new AccountModel();
				AccountView accView = new AccountView(accModel);
				AccountController accControl = new AccountController(accView, accModel, 3);
				VBox vbox = new VBox();
				Stage oldStage = (Stage) tbView.getScene().getWindow();
				vbox.getChildren().addAll(tbView, accView);
				Stage newStage = new Stage();
				Scene newScene = new Scene(vbox, 400, 600);
				

				oldStage.close();
				newStage.setScene(newScene);
				newStage.show();
			    newStage.setResizable(false);

				Main.iModel.setDisplayed(Displayed.OTHER);

			}
		});
		
		tbView.about.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				AboutView aboutView = new AboutView();
				VBox showing = new VBox();
				//ToolbarView tb2 = new ToolbarView();
				//ToolbarController tbc2 = new ToolbarController(tb2);
				Stage oldStage = (Stage) tbView.getScene().getWindow();

				showing.getChildren().addAll(tbView, aboutView);
				Scene scene = new Scene(showing, 400, 600);

			    Stage stage = new Stage();
			    stage.setScene(scene);
			    stage.show();
			    stage.setResizable(false);

			    oldStage.close();				
			    Main.iModel.setDisplayed(Displayed.OTHER);

				
			}
		});
	
		tbView.signOut.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Sign-Out");
				alert.setHeaderText("You are about to Sign-Out");
				alert.setContentText("Did you want to sign out?");

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK){
					Stage stage = (Stage) tbView.getScene().getWindow();
				    stage.close();
				} 
				
				
			}
		});
		
		
		tbView.back.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Displayed goTo = Main.iModel.getBack();
				if(goTo == Displayed.DASHBOARD){
					Stage stage = (Stage) tbView.getScene().getWindow();
					VBox newBox = new VBox();
					newBox.getChildren().addAll(tbView, Main.dashview);
					Scene newScene = new Scene(newBox, 400, 750);
					Stage newStage = new Stage();
					newStage.setScene(newScene);
					newStage.setResizable(false);

					stage.close();
					newStage.show();
				}
				else if(goTo == Displayed.OPEN){
					Stage stage = (Stage) tbView.getScene().getWindow();
					//Create Login object
					//Open new Window
					//Close old window
					System.out.println("Showing Login");
				}
			}
			
		});
	}
}
