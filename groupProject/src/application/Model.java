package application;

import java.sql.*;
import java.util.ArrayList;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Model {
	private ArrayList<User> users;
	Connection connection;
	DataBaseManager db = new DataBaseManager();
	public Model(){
		connection = db.connector();

		users = new ArrayList<User>();
		getUser();
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

	public boolean isDbConnected(){
		try {
			return !connection.isClosed();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
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

//	for(int i = 1; i<4; i++){
//		users.add(new User("User #" + i, "password", new Image("blank.png")));
//	}

}
