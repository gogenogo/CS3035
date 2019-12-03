package application;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import application.Purchase.Category;
import javafx.scene.image.Image;

public class DataBaseManager {
	Connection connection = null;

	public Connection connector(){

		try {
			Class.forName("org.sqlite.JDBC");

			connection = DriverManager.getConnection("jdbc:sqlite::resource:projectDB.sl3");


		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

	public ArrayList<User> getUser(){
		ArrayList<User> user = new ArrayList<User>();
		try {
			String sql = "SELECT * FROM User";

            Statement stmt  = connection.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

           // loop through the result set
           while (rs.next()) {
        	   User addUser = new User (rs.getInt("userId"),(rs.getString("firstName") + " " + rs.getString("lastName")), rs.getString("password"),new Image("blank.png"));

        	   sql = "SELECT * FROM budget where userId = ? ;" ;


               PreparedStatement preparedStatement = connection.prepareStatement(sql);
               preparedStatement.setInt(1, addUser.getID());
               ResultSet rs2 = preparedStatement.executeQuery();
               Budget budget = new Budget();

               while (rs2.next()){
            	   budget.setWeeklyEarnings(rs2.getDouble("weeklyEarnings") );
            	   budget.setRent(rs2.getDouble("rentPerMonth") * 4);
            	   budget.setGroceries(rs2.getDouble("groceries"));
            	   budget.setGas(rs2.getDouble("gas"));
            	   budget.setEntertainment(rs2.getDouble("entertainment"));
            	   budget.setDiningOut(rs2.getDouble("diningOut"));
            	   budget.setHealth(rs2.getDouble("health"));
            	   budget.setHome(rs2.getDouble("home"));
            	   budget.setPersonal(rs2.getDouble("personal"));
            	   budget.setEducation(rs2.getDouble("education"));
            	   budget.setOther(rs2.getDouble("other"));
            	   budget.setCarry(rs2.getDouble("carryOver"));

            	   addUser.setBudget(budget);

               }

        	   sql = "SELECT * FROM goal where userId = ? ;" ;


               preparedStatement = connection.prepareStatement(sql);
               preparedStatement.setInt(1, addUser.getID());
               ResultSet rs3 = preparedStatement.executeQuery();
               while (rs3.next()){

            	   String entry = rs3.getString("entry");
            	   Double amount = rs3.getDouble("amount");


            	   addUser.getBudget().setGoal(amount,entry);

               }

               user.add(addUser);

           }
		} catch (Exception e) {
			System.out.println("ERROR GETTING INFORMATION");
			e.printStackTrace();
		}

		return user;
	}

	public boolean updateUserInfo() {
		try {
			Connection connection = connector();
			User  user = Main.model.getWorkingWith();
			String sql = "Update User set firstName = ? , password = ? where userId = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getID());
            preparedStatement.executeUpdate();


            sql = "Update Budget set weeklyEarnings = ? , rentPerMonth = ? where userId = ?";

			preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setDouble(1, user.getBudget().getWeeklyEarnings());
            preparedStatement.setDouble(2, user.getBudget().getRent());
            preparedStatement.setInt(3, user.getID());
            preparedStatement.executeUpdate();


            return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateBudgetInfo() {
		try {
			Connection connection = connector();
			User  user = Main.model.getWorkingWith();
			System.out.println(user.getID());



            String sql = "Update Budget set groceries = ?, gas = ?, entertainment = ?, diningOut = ?, home = ?, "
            		+ "health = ?, personal = ?, education = ?, other = ? where userId = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setDouble(1, user.getBudget().getGroceries());
            preparedStatement.setDouble(2, user.getBudget().getGas());
            preparedStatement.setDouble(3, user.getBudget().getEntertainment());
            preparedStatement.setDouble(4, user.getBudget().getDiningOut());
            preparedStatement.setDouble(5, user.getBudget().getHome());
            preparedStatement.setDouble(6, user.getBudget().getHealth());
            preparedStatement.setDouble(7, user.getBudget().getPersonal());
            preparedStatement.setDouble(8, user.getBudget().getEducation());
            preparedStatement.setDouble(9, user.getBudget().getOther());
            preparedStatement.setInt(10, user.getID());
            preparedStatement.executeUpdate();


            return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public boolean addPurchase(String name, int id, Date date, double text0, String text1) {
		try {
			Connection connection = connector();
			Statement stmt  = connection.createStatement();
			String sql = "INSERT INTO transactions (categoryId, UserId, dateEntered, amount, place) values ('"
	    					+ name + "', '" + id + "', '"
	    					+ date  + "', '" + text0+ "', '" + text1 + "');";
			int rs    = stmt.executeUpdate(sql);

			if (rs > 0){
				return true;
			}

		} catch (Exception e) {
			System.out.println("ERROR ADDING PURCHASES ");
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Purchase> loadPurchases(User user) {


		ArrayList<Purchase> purchase = new ArrayList<Purchase>();

		try {
			SimpleDateFormat format =  new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

			Connection connection = connector();
			String sql = "SELECT * FROM transactions where userId = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, user.getID());

            ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()){

				System.out.println("TEST " + rs.getString("dateEntered"));
				if (rs.getString("categoryId").equals(Category.GROCERIES.name())){
					purchase.add(new Purchase(Category.GROCERIES, rs.getDouble("amount"),rs.getString("place"), format.parse(rs.getString("dateEntered"))));
				}
				else if (rs.getString("categoryId").equals("GAS")){
					purchase.add(new Purchase(Category.GAS, rs.getDouble("amount"),rs.getString("place"),format.parse(rs.getString("dateEntered"))));

				}
				else if (rs.getString("categoryId").equals("ENTERTAINMENT")){
					purchase.add(new Purchase(Category.ENTERTAINMENT, rs.getDouble("amount"),rs.getString("place"),format.parse(rs.getString("dateEntered"))));
				}
				else if (rs.getString("categoryId").equals("HOME")){
					purchase.add(new Purchase(Category.HOME, rs.getDouble("amount"),rs.getString("place"),format.parse(rs.getString("dateEntered"))));
				}
				else if (rs.getString("categoryId").equals("HEALTH")){
					purchase.add(new Purchase(Category.HEALTH, rs.getDouble("amount"),rs.getString("place"),format.parse(rs.getString("dateEntered"))));
				}
				else if (rs.getString("categoryId").equals("PERSONAL")){
					purchase.add(new Purchase(Category.PERSONAL, rs.getDouble("amount"),rs.getString("place"),format.parse(rs.getString("dateEntered"))));
				}
				else if (rs.getString("categoryId").equals("EDUCATION")){
					purchase.add(new Purchase(Category.EDUCATION, rs.getDouble("amount"),rs.getString("place"),format.parse(rs.getString("dateEntered"))));
				}
				else if (rs.getString("categoryId").equals("OTHER")){
					purchase.add(new Purchase(Category.OTHER, rs.getDouble("amount"),rs.getString("place"),format.parse(rs.getString("dateEntered"))));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return purchase;
	}


	public boolean updateCarryOver() {
		try {
			Connection connection = connector();
			User  user = Main.model.getWorkingWith();


            String sql = "Update Budget set carryOver = ? where userId = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setDouble(1, user.getBudget().getCarry());
            preparedStatement.setInt(2, user.getID());
            preparedStatement.executeUpdate();

            return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public boolean deletePurchase(Date dateIn) {
		try {
			Connection connection = connector();
			User  user = Main.model.getWorkingWith();


            String sql = "Delete from transactions where userId = ? and dateEntered = '"+ dateIn + "' ;" ;

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, user.getID());
            preparedStatement.executeUpdate();

            return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public boolean addDiaryEntry(Diary newEntry) {
		 Statement stmt;
		try {
			Connection connection = connector();
			stmt = connection.createStatement();
			String sql = "INSERT INTO diary (userId, title, entry, datePosted) values ('"
    				+ newEntry.getUserId() + "', '" + newEntry.getTitle()+ "', '" + newEntry.getEntry() + "', '" + newEntry.getDatePosted() + "');";

			int rs    = stmt.executeUpdate(sql);
			if(rs > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return false;
	}

	public ArrayList<Diary> getDiaryEntries() {
		// TODO Auto-generated method stub
		ArrayList<Diary> diary = new ArrayList<Diary>();
		try {
			Connection connection = connector();
			String sql = "SELECT * FROM diary where UserId = ? order by datePosted desc;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, Main.model.getWorkingWith().getID());
            ResultSet rs    = preparedStatement.executeQuery();;

           // loop through the result set
           while (rs.next()) {
        	   SimpleDateFormat format =  new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        	   Diary object = new Diary(rs.getString("title"), rs.getString("entry"), rs.getInt("UserId"), format.parse(rs.getString("datePosted")));
        	   diary.add(object);
           }
           connection.close();
		} catch (Exception e) {
			System.out.println("ERROR GETTING Diary entries ");
			e.printStackTrace();
		}

		return diary;
	}


	public boolean updateDiaryEntry(String title, String entry, String datePosted) {
		// TODO Auto-generated method stub
		try {
			Connection connection = connector();
			User  user = Main.model.getWorkingWith();


            String sql = "Update diary set title = ?, entry = ? where userId = ? and datePosted = ?;";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, entry);
            preparedStatement.setInt(3, user.getID());
            preparedStatement.setString(4, datePosted);

            preparedStatement.executeUpdate();
            connection.close();
            return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
