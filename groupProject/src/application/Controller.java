package application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
						new AccountController(accountView, accountModel);
						Scene scene = new Scene(accountView, 300,300);
					    Stage stage = new Stage();
					    stage.setScene(scene);
					    stage.show();
					}
					else{
						System.out.println("user clicked");
						User clickedOn = Main.model.findUserFromImage((ImageView)event.getTarget());
						System.out.println(clickedOn.getName());
						LoginView loginView = new LoginView(clickedOn);
						new LoginController(loginView);
						Scene scene = new Scene(loginView);
					    Stage stage = new Stage();
					    stage.setScene(scene);
					    stage.show();
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
