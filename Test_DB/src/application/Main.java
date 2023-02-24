package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		System.out.println("-------- MySQL JDBC Connection Demo ------------");
		System.out.println(" ");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("MySQL JDBC Driver not found !!");
			return;
		}
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "password");
			System.out.println("SQL Connection to database established!");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			return;
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
