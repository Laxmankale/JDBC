package com.Lucky.jdbctask;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.protocol.Resultset;

public class Task {
	private static Connection connection;
	private static Statement statement;
	private static FileReader fileReader;
	private static Properties properties;
	private static int output;
	private static String filepath;
	public static void main(String[] args) {
		
		try {
			filepath="D:\\WEJM4\\jdbctask\\resources\\db_info.properties";
			fileReader=new FileReader(filepath);
			properties=new Properties();	
			properties.load(fileReader);
			Class.forName(properties.getProperty("driverpath"));
			connection=DriverManager.getConnection(properties.getProperty("dburl"), properties);
			statement=connection.createStatement();
			
			//1:create a table
//			output=statement.executeUpdate(properties.getProperty("query1"));
//			output=statement.executeUpdate(properties.getProperty("query2"));
//			output=statement.executeUpdate(properties.getProperty("query3"));
//			output=statement.executeUpdate(properties.getProperty("query4"));
//			output=statement.executeUpdate(properties.getProperty("query5"));
			
			//2:update 2 records
			output=statement.executeUpdate(properties.getProperty("query5"));
			output=statement.executeUpdate(properties.getProperty("query3"));
			
			//3:display all the records
//		ResultSet resultset=statement.executeQuery("select * from employee");
//					while (resultset.next()) {
//						System.out.println(resultset.getString(1)+" | "
//					+resultset.getString(2)+" | "
//					+resultset.getString(3)+" | "
//					+resultset.getString(4)+" | "
//					+resultset.getString(5));}
	
			output=statement.executeUpdate(properties.getProperty("query2"));
			//4:display all the records
		ResultSet resultset2=statement.executeQuery("select * from employee");
					while (resultset2.next()) {
						System.out.println(resultset2.getString(1)+" | "
					+resultset2.getString(2)+" | "
					+resultset2.getString(3)+" | "
					+resultset2.getString(4)+" | "
					+resultset2.getString(5));}
		
			System.out.println(output+ " rows affected");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			
				try {
					if (connection!=null) {
					connection.close();
					}
					if (statement!=null) {
						statement.close();
					}
					
				} catch (SQLException e) {	
					e.printStackTrace();
				}
			}
		}
		
	}
	


