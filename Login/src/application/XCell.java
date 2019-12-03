package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

import application.InteractionModel.Displayed;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class XCell extends ListCell<String> {
        HBox hbox = new HBox();
        Label label = new Label("");
        Pane pane = new Pane();
        Button button = new Button("Del");

        public XCell() {
            super();

            hbox.getChildren().addAll(label, pane, button);
            HBox.setHgrow(pane, Priority.ALWAYS);
            button.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Delete Event");
					alert.setHeaderText("We are about to delete this event.");
					alert.setContentText("Are you ok with this?");

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK){
						SimpleDateFormat format =  new SimpleDateFormat(" EEE MMM dd HH:mm:ss zzz yyyy");
						Scanner scan = new Scanner(label.getText());
						scan.useDelimiter(" ");
						scan.next();
						scan.next();
						scan.next();
						String toDate = scan.nextLine();
						try {
							Date toDelete = format.parse(toDate);
							Main.model.getWorkingWith().deleteFromList(toDelete);
							Main.model.db.deletePurchase(toDelete);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Stage stage = (Stage) Main.tbView.getScene().getWindow();
						stage.close();
						VBox newBox = new VBox();
						Main.dashview = new DashboardView();
						Main.dashcontroller = new DashboardController();
						newBox.getChildren().addAll(Main.tbView, Main.dashview);
						Scene newScene = new Scene(newBox, 400, 750);
						Stage newStage = new Stage();
						newStage.setScene(newScene);
						newStage.setResizable(false);
						newStage.show();
						Main.iModel.setDisplayed(Displayed.DASHBOARD);
					} else {
					   
					}
					
				}
            		
            		
            });
        }

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            setText(null);
            setGraphic(null);

            if (item != null && !empty) {
                label.setText(item);
                setGraphic(hbox);
            }
        }
    }

