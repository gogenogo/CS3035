package application;

import javafx.geometry.Pos;

public class InteractionModel {
	public enum Displayed {OPEN, PASSWORD, NEW_ACCOUNT, DASHBOARD, INFO, PURCHASE, OTHER}
	private Displayed current = Displayed.OPEN;
	
	
	public Displayed getBack(){
		Displayed backTo = null;
		if(current == Displayed.PASSWORD || current == Displayed.NEW_ACCOUNT){
			backTo = Displayed.OPEN;
			setDisplayed(backTo);

		}
		else if(current == Displayed.INFO || current == Displayed.PURCHASE || current == Displayed.OTHER ){
			backTo = Displayed.DASHBOARD;
			setDisplayed(backTo);

		}
		return backTo;
		
	}
	
	public void setDisplayed(Displayed change){
		if(change == Displayed.OPEN){
			Main.tbView.hamburger.setDisable(true);
			Main.tbView.back.setDisable(true);
		}
		else if(change == Displayed.DASHBOARD){
			Main.tbView.hamburger.setDisable(false);
			Main.tbView.back.setDisable(true);

		}
		else{
			Main.tbView.hamburger.setDisable(false);
			Main.tbView.back.setDisable(false);

		}
		
		current = change;
	}
}
