package com.lucky.dynamicdelete;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class DynamicDelete {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static int result;
	private static FileReader fileReader;
	private static Properties properties;                                   
	private static String filepath="D:\\WEJM4\\dynamicdelete\\resourcess\\db_info.properties";
	

	public static void  main(String[] args) {
		
	
		try {
			fileReader=new FileReader(filepath);
		properties=new Properties();
		properties.load(fileReader);
		Class.forName(properties.getProperty("driver"));
		connection=DriverManager.getConnection(properties.getProperty("dburl"), properties);
	    preparedStatement=connection.prepareStatement(properties.getProperty("query"));
	    Scanner scanner=new Scanner(System.in);
	    System.out.println("enter id no. :");
		int id=scanner.nextInt();
		preparedStatement.setInt(1, id);
		result=preparedStatement.executeUpdate();
		
			System.out.println(result+" rows affected");
		
	} catch (SQLException e) {
	e.printStackTrace();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	finally {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			if (preparedStatement !=null) {
				try {
					preparedStatement.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
	
			}
	}

	}
	}