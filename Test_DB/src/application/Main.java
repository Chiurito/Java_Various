package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	static String driverName = "com.mysql.cj.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://localhost:3306/users";
	static String user = "root";
	static String password = "password";

	public static void main(String[] args) {
		System.out.println("-------- MySQL JDBC Connection Demo ------------");
		System.out.println(" ");
		try
		{
			Class.forName(driverName);
		} 
		catch (ClassNotFoundException e) {
			System.out.println("MySQL JDBC Driver not found!!");
			return;
		}
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
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
}
