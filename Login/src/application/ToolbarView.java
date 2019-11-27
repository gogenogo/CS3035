package application;

import java.util.Calendar;
import java.util.Date;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ToolbarView extends Pane{
	public Menu hamburger;
	public MenuItem addPurchase;
	public MenuItem addDiary;
	public MenuItem changeBudget;
	public MenuItem accountSettings;
	public MenuItem about;
	public MenuItem signOut;
	public Button back;
	public HBox rightMenu;

	
	public ToolbarView(){
		back = new Button();
		ImageView backIv = new ImageView("back.png");
		backIv.setFitHeight(20);
		backIv.setFitWidth(20);
		back.setGraphic(backIv);
		hamburger = new Menu();
		ImageView iv = new ImageView("hamburger_icon.png");
		iv.setFitHeight(20);
		iv.setFitWidth(20);
		hamburger.setGraphic(iv);
		addPurchase = new MenuItem("New Purchase");
		addDiary = new MenuItem("Check Diary");
		changeBudget = new MenuItem("Change Budget/Goal");
		accountSettings = new MenuItem("Account Settings");
		about = new MenuItem("About Us/Help");
		signOut = new MenuItem("Sign Out");
		hamburger.getItems().addAll(addPurchase, addDiary, changeBudget, accountSettings, about, signOut);
		
		
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(hamburger);
		menuBar.setBackground(Background.EMPTY);
		//back.setBackground(Background.EMPTY);
		//back.setBorder(null);

		Date now1 = new Date();
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(now1);

	    String finalDate = "";
	    
	    switch(calendar.get(Calendar.DAY_OF_WEEK)){
	    case 1:
	    	finalDate += "Sunday, ";
	    	break;
	    case 2:
	    	finalDate += "Monday, ";
	    	break;
	    case 3:
	    	finalDate += "Tuesday, ";
	    	break;
	    case 4:
	    	finalDate += "Wednesday, ";
	    	break;
	    case 5:
	    	finalDate += "Thursday, ";
	    	break;
	    case 6:
	    	finalDate += "Friday, ";
	    	break;
	    case 7:
	    	finalDate += "Saturday ";
	    	break;
	    }
	    
	    switch(calendar.get(Calendar.MONTH)){
	    case 0:
	    	finalDate += "January ";
	    	break;
	    case 1:
	    	finalDate += "February ";
	    	break;
	    case 2:
	    	finalDate += "March ";
	    	break;
	    case 3:
	    	finalDate += "April ";
	    	break;
	    case 4:
	    	finalDate += "May ";
	    	break;
	    case 5:
	    	finalDate += "June ";
	    	break;
	    case 6:
	    	finalDate += "July ";
	    	break;
	    case 7:
	    	finalDate += "August ";
	    	break;
	    case 8:
	    	finalDate += "September ";
	    	break;
	    case 9:
	    	finalDate += "October ";
	    	break;
	    case 10:
	    	finalDate += "November ";
	    	break;
	    case 11:
	    	finalDate += "December ";
	    	break;
	    }
	    
	    finalDate += calendar.get(Calendar.DATE);
		
		Text text = new Text(finalDate);
		text.setFont(Font.font("Open Sans", 20));
		Region leftRegion = new Region(); 
		leftRegion.setPrefWidth(45);
		Region rightRegion = new Region(); 
		rightRegion.setPrefWidth(45);
		rightMenu = new HBox();
		rightMenu.setPrefWidth(400);
		rightMenu.getChildren().addAll(back, leftRegion, text, rightRegion, menuBar);
		rightMenu.setAlignment(Pos.CENTER);
		this.getChildren().add(rightMenu);
	}	
}
