package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Model {
	private ArrayList<User> users;
	private User workingWith = null;
	Connection connection;
	DataBaseManager db = new DataBaseManager();
	
	
	public Model(){
		connection = db.connector();

		users = db.getUser();
		
	}
	
	public ArrayList<User> getUsersList(){
		return users;
	}
	
	public User findUserFromImage(ImageView search){
		User correct = null;
		for(int i =0; i<users.size(); i++){
			if(search == users.get(i).getIcon()){
				correct = users.get(i);
			}
		}
		return correct;
	}

	public User getWorkingWith() {
		return workingWith;
	}

	public void setWorkingWith(User workingWith) {
		this.workingWith = workingWith;
	}
	
	public boolean isLogin(int id, String pass) throws SQLException{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query  = "select * from User where userId = ? and password = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, pass);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()){
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			preparedStatement.close();
			resultSet.close();
		}
	}
 

	public void saveUser(User user) {
		try {
		    Statement stmt  = connection.createStatement();

		    String sql = "INSERT INTO USER (firstName, lastName, password, income) values ('"
		    				+ user.getName() + "', '', '" + user.getPassword() + "', '" + user.getBudget().getWeeklyEarnings() + "');";

			int rs    = stmt.executeUpdate(sql);
			if(rs > 0){
				sql = "Select * from USER where firstName = ? and password = ?;";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, user.getName());
				preparedStatement.setString(2, user.getPassword());
				ResultSet resultSet = preparedStatement.executeQuery();

				if (resultSet.next()){
					sql = "INSERT INTO BUDGET (userId, weeklyEarnings, rentPerMonth, groceries, gas, entertainment, diningOut, home, health, personal, education, other, changed) values ('"
										+ resultSet.getInt("userId") + "', '"  +user.getBudget().getWeeklyEarnings() + "', '" + user.getBudget().getRent() + "', '" + user.getBudget().getGroceries() +"', '"
										+ user.getBudget().getGas() + "', '" + user.getBudget().getEntertainment()
										+ "', '"  + user.getBudget().getDiningOut() + "', '" + user.getBudget().getHome() + "', '" + user.getBudget().getHealth()
										+ "', '"  + user.getBudget().getPersonal() + "', '"  + user.getBudget().getEducation() + "', '"  + user.getBudget().getOther() + "', 0); ";
					rs = stmt.executeUpdate(sql);

					if (rs > 0 ){
						System.out.println("YAY I DID IT");
					}
				}
				sql = "insert into goal(userId,entry,amount) values ('" + resultSet.getInt("userId") + "', '"
						+ user.getBudget().getGoal().getGoalName() + "', '" + user.getBudget().getGoal().getGoal() +"')";

						rs = stmt.executeUpdate(sql);				users.add(user);
			}
			else{
				System.out.println("error adding a new user");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void resetColours(){
		for(int i = 0; i < users.size(); i++){
			users.get(i).resetColor();
		}
	}


}
