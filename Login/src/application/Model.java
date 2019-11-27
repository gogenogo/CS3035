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

		users = new ArrayList<User>();
		getUser();
		/*
		for(int i = 1; i<4; i++){
			users.add(new User(i, "User #" + i, "password", new Image("blank.png")));
			Budget budgetIn = new Budget();
			budgetIn.setDiningOut(100);
			budgetIn.setEducation(100);
			budgetIn.setEntertainment(100);
			budgetIn.setGas(100);
			budgetIn.setGoal(100);
			budgetIn.setGroceries(100);
			budgetIn.setHealth(100);
			budgetIn.setHome(100);
			budgetIn.setOther(100);
			budgetIn.setPersonal(100);
			budgetIn.setRent(100);
			budgetIn.setWeeklyEarnings(100);
			users.get(i-1).setBudget(budgetIn);
		}*/
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

	public void getUser(){
		try {
			String sql = "SELECT * FROM User";

            Statement stmt  = connection.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

           // loop through the result set
           while (rs.next()) {

        	   users.add(new User (rs.getInt("userId"),(rs.getString("firstName") + " " + rs.getString("lastName")), rs.getString("password"),new Image("blank.png") ));
//               System.out.println(rs.getInt("userId") +  "\t" +
//                                  rs.getString("firstName") + "\t" +
//                                  rs.getString("lastName"));
           }
		} catch (Exception e) {
			System.out.println("ERROR GETTING INFORMATION");
		}
	}

	public void saveUser(User user) {
		try {
		    Statement stmt  = connection.createStatement();
		    		
		    String sql = "INSERT INTO USER (firstName, lastName, password, income) values ('" + user.getName() + "', '', '" + user.getPassword() + "', '" + user.getBudget().getWeeklyEarnings() + "');"; 

			int rs    = stmt.executeUpdate(sql);
			if(rs > 0){
				System.out.println("Worked!");
				users.add(user);

			}
			else{
				System.out.println("Didn't work!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	for(int i = 1; i<4; i++){
//		users.add(new User("User #" + i, "password", new Image("blank.png")));
//	}

	
}
