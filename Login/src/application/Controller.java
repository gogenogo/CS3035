package application;

import application.InteractionModel.Displayed;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Controller {
	private ImageView selected;

	public Controller(){
		Main.view.setOnMousePressed(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				if(event.getTarget().getClass() == ImageView.class && event.getTarget() != Main.view.logo){
					if(event.getTarget() == Main.view.addButton){
						AccountModel accountModel = new AccountModel();
						AccountView accountView = new AccountView(accountModel);
						AccountController accountController = new AccountController(accountView, accountModel);
						Stage oldStage = (Stage)Main.view.getScene().getWindow();
						oldStage.hide();
						Scene scene = new Scene(accountView, 400,600);
					    Stage stage = new Stage();
					    stage.setResizable(false);

					    stage.setOnCloseRequest(new EventHandler<WindowEvent>(){

							@Override
							public void handle(WindowEvent event) {
								oldStage.show();					    
								Main.iModel.setDisplayed(Displayed.OPEN);

								
							}
					    	
					    });
					    stage.setScene(scene);
					    stage.show();
						Main.iModel.setDisplayed(Displayed.NEW_ACCOUNT);

					}
					else{
						User clickedOn = Main.model.findUserFromImage((ImageView)event.getTarget());
						LoginView loginView = new LoginView(clickedOn);
						LoginController loginControl = new LoginController(loginView);
						Scene scene = new Scene(loginView);
						Stage oldStage = (Stage)Main.view.getScene().getWindow();
						oldStage.hide();
						Stage stage = new Stage();
					    stage.setResizable(false);

					    stage.setScene(scene);
					    stage.setOnCloseRequest(new EventHandler<WindowEvent>(){

							@Override
							public void handle(WindowEvent event) {
								oldStage.show();
								Main.iModel.setDisplayed(Displayed.OPEN);

								
							}
					    	
					    });
					    stage.show();
					    Main.iModel.setDisplayed(Displayed.NEW_ACCOUNT);
					}
				}
				else{

				}
				
			}
			
		});
		
		Main.view.setOnMouseMoved(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				if(event.getTarget().getClass() == ImageView.class && event.getTarget() != Main.view.logo){
					if(event.getTarget() == Main.view.addButton){
						selected = (ImageView)(event.getTarget());
						ColorAdjust bright = new ColorAdjust();
						bright.setBrightness(0.4);
						selected.setEffect(bright);
					}
					else{
						selected = (ImageView)(event.getTarget());
						ColorAdjust bright = new ColorAdjust();
						bright.setBrightness(0.4);
						selected.setEffect(bright);
					}
				}
				else{
					if(selected!=null){
						ColorAdjust bright = new ColorAdjust();
						bright.setBrightness(0);
						selected.setEffect(bright);
					}
				}
			}
			
		});
		
	}
}
