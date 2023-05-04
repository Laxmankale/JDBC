package com.lucky.dynamicinsert;

import java.io.FileNotFoundException;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class JdbcDynamicInsert {
private static Connection connection;
private static PreparedStatement preparedStatement;
private static int result;
private static FileReader fileReader;
private static Properties properties;
private static String filepath="D:\\WEJM4\\dynamicinsert\\resourcess\\db_info.properties";
private static Scanner scanner=new Scanner(System.in);

public static void main(String[] args) {
	try {
		fileReader=new FileReader(filepath);
	properties=new Properties();
	properties.load(fileReader);
	Class.forName(properties.getProperty("driverpath"));
	connection=DriverManager.getConnection(properties.getProperty("dburl"), properties);
    preparedStatement=connection.prepareStatement(properties.getProperty("query"));
  
	System.out.println("enter the Student id : ");
	int id=scanner.nextInt();
	preparedStatement.setInt(1, id);
	
	System.out.println("enter the Student name : ");
	String name=scanner.next();
	preparedStatement.setString(2, name);
	
	System.out.println("enter the Student email : ");
	String email=scanner.next();
	preparedStatement.setString(3, email);
	
	System.out.println("enter the Student contact : ");
	long contact=scanner.nextLong();
	preparedStatement.setLong(4, contact);
	
	System.out.println("enter the Student city : ");
	String city=scanner.next();
	preparedStatement.setString(5, city);
	
	result=preparedStatement.executeUpdate();
	System.out.println(result + "  row(s)affected");
	
	
		
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
}
