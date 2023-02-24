package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	private static final String driverName = "com.mysql.cj.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://localhost:3306/mydb";
	static String user = "rocco";
	static String password = "password";
	static Connection connection = null;

	public static void main(String[] args) {
		System.out.println("-------- MySQL JDBC Connection Demo ------------");
		System.out.println(" ");

		 try
		 {
		 	Class.forName(getDriverName());

		 } catch (ClassNotFoundException e) {
		 	System.out.println("MySQL JDBC Driver not found!!");
		 }

		 System.out.println("MySQL JDBC Driver Registered!");

		try {
			connection = DriverManager.getConnection(DB_URL, user, password);
			System.out.println("SQL Connection to database established...");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console...");

		} finally {
			try
			{
				if(connection != null)
					connection.close();
				System.out.println("Connection closed...");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static String getDriverName() {
		return driverName;
	}
}