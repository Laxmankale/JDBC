package com.jspiders.jdbc.main;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1 {
	public static void main(String[] args) {
		try {
			//step-1:Load the Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step-2: Open connections
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wejm4?user=root&password=root");
			
			//Step-3: Create/Prepare Statement
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from students");
			
			//Step-4: Pr98000ocess the result
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " | "
						          +resultSet.getString(2) + " | "
						          +resultSet.getString(3) + " | "
						          +resultSet.getString(4) + " | "
						          +resultSet.getString(5));
				
			}
			
			//Step-5: Close Connections
			connection.close();
			statement.close();
			resultSet.close();
			
			
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
	}

}
