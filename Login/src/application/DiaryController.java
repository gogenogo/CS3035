package application;

import java.util.Date;

import application.InteractionModel.Displayed;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DiaryController {

	public DiaryController(DiaryView diaryView){


		diaryView.submit.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {

				if(diaryView.buttonSetting == 0){
					Diary newEntry = new Diary(diaryView.title.getText(), diaryView.entry.getText(), Main.model.getWorkingWith().getID(),new Date());
					if(Main.model.db.addDiaryEntry(newEntry)){
						diaryView.listView.getItems().add(0,newEntry);
						diaryView.entry.clear();
						diaryView.title.clear();

						diaryView.resultMessage.setText("Sucessfully Added");

					}
					else {
						diaryView.resultMessage.setText("Error adding the entry");
					}
				}
				else {
					if(Main.model.db.updateDiaryEntry(diaryView.title.getText(), diaryView.entry.getText(),("" + diaryView.getSelected().getDatePosted()))){

						diaryView.resultMessage.setText("Sucessfully updated");

					}
					else {
						diaryView.resultMessage.setText("Error adding the entry");
					}
				}



			}

		});


		diaryView.listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Diary>() {





			@Override
			public void changed(ObservableValue<? extends Diary> arg0, Diary oldValue, Diary newValue) {
				// TODO Auto-generated method stub

				diaryView.setSelected(newValue);

				diaryView.DisplayEntries(newValue);

				Main.iModel.setDisplayed(Displayed.OTHER);
			}
		});

	}

}
