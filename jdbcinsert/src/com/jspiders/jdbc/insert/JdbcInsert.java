package com.jspiders.jdbc.insert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcInsert {
private static Connection connection;
private static Statement statement;
private static int result;
private static FileReader fileReader;
private static Properties properties;
private  static String filepath;
public static void main(String[] args) {
	try {
		filepath="D:\\WEJM4\\jdbcinsert\\resources\\db_info.properties";
		
		fileReader=new FileReader(filepath);
		properties=new Properties();
		properties.load(fileReader);
		
		Class.forName(properties.getProperty("driverpath"));
		
		connection=DriverManager.getConnection(properties.getProperty("dburl"), properties);
		
		statement=connection.createStatement();
		
		result=statement.executeUpdate(properties.getProperty("query"));
		
		System.out.println(result+"rows affected");
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
	}
}
