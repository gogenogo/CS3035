package application;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class DiaryView extends Pane {

	private Diary selected = null;

	public TextField title = new TextField();
	public TextField entry = new TextField();
	public Label resultMessage = new Label();

	public int buttonSetting = 0;

	public Button submit = new Button("Submit");

	private VBox vbox = new VBox(10);
	private HBox hbox = new HBox(10);

	public  ListView<Diary> listView = new ListView<Diary>();

	private ArrayList<Diary> diaryEntries;

	public DiaryView (){

		diaryEntries = Main.model.db.getDiaryEntries();

		this.setBackground(new Background(new BackgroundFill(Color.rgb(217, 228, 255), CornerRadii.EMPTY, null)));
		this.setPrefSize(400, 570);

		resultMessage.setText("");

		vbox.setPadding(new Insets (10,0,0,25));

		title.setPromptText("Enter the title");
		entry.setPromptText("Entry");

		title.setPrefSize(350, 25);
		entry.setPrefSize(300, 250);

		entry.setAlignment(Pos.TOP_LEFT);
		submit.setAlignment(Pos.BOTTOM_RIGHT);

		hbox.getChildren().addAll(resultMessage,submit);

		hbox.setAlignment(Pos.BASELINE_RIGHT);




		for (int i =0; i <diaryEntries.size(); i++){
			listView.getItems().add(diaryEntries.get(i));
		}



        VBox hbox2 = new VBox(listView);

        listView.setPrefSize(300, 200);

		vbox.getChildren().addAll(title,entry,hbox,hbox2);
		vbox.setAlignment(Pos.CENTER);



		this.getChildren().add(vbox);
        //this.getChildren().add(hbox2);

	}

	public void DisplayEntries(Diary newValue){

		buttonSetting = 1;

		title.setText(newValue.getTitle());
		entry.setText(newValue.getEntry());

		submit.setText("update");

	}

	public Diary getSelected() {
		return selected;
	}

	public void setSelected(Diary selected) {
		this.selected = selected;
	}
}
