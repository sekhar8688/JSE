package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public  class Launch {
	private static Connection connection;
	private static Statement statement;
	private static ResultSet res;

	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "root";
		
		 String query = "INSERT INTO employee1(id,name,email,department,salary)"
				 +"values+(4,'ramu','ramu@gmail.com','20000')";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		    connection=DriverManager.getConnection(url, username, password);
			
			 statement = connection.createStatement();
			int n=statement.executeUpdate(query);
			System.out.println(n);
			
			
		} catch (ClassNotFoundException  e) {
		
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
}
}