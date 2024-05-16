package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Shiva22 {

	private static Connection connnection;
	private static Statement statement;
	private static ResultSet res;
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "root";
		
		
		
		String Query = "SELECT * FROM `employee1`";
		
		String str = "INSERT INTO `employee1` (id, name, email, department, salary)"
				+ " VALUES (10,'Ram','ram@gmail.com','IT','123456');";
		
		try {
			connnection = DriverManager.getConnection(url, username, password);
			System.out.println("old table: ");
			statement = connnection.createStatement();
			res = statement.executeQuery(Query);
			System.out.println("+-----------------------------------------------------------------------------------+");
			while (res.next()) {
				System.out.println(res.getInt("ID") + " " + res.getString("name") + " " + res.getString("email") + " "
						+ res.getString("department") + " " + res.getString("salary"));
			}
			do {
				res = statement.executeQuery(Query);
				System.out.println("+-----------------------------------------------------------------------------------+");
				while (res.next()) {
					System.out.println(res.getInt("ID") + " " + res.getString("name") + " " + res.getString("email") + " "
							+ res.getString("department") + " " + res.getString("salary"));
				}
				statement.executeUpdate(str);				
				res = statement.executeQuery(Query);		
				System.out.println("+-----------------------------------------------------------------------------------+");
				while (res.next()) {
					System.out.println(res.getInt("ID") + " " + res.getString("name")+ " " + res.getString("email")+ " " + res.getString("department")+ " " + res.getString("salary"));
				}	
				System.out.println("Do Want To Insert More Details? ( Yes / No): ");
			} while (sc.next().equalsIgnoreCase("Yes"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
