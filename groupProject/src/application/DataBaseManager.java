package application;

import java.sql.*;

public class DataBaseManager {
	Connection connection = null;

	public Connection connector(){

		try {
			Class.forName("org.sqlite.JDBC");

			connection =DriverManager.getConnection("jdbc:sqlite::resource:projectDB.sl3");

			DatabaseMetaData md = connection.getMetaData();
			ResultSet rs = md.getTables(null, null, "%", null);
			while (rs.next()) {
			  System.out.println(rs.getString(3));
			}

			return connection;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}




}
