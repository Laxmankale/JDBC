package com.lucky.jdbcmockDelete;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcDelete{
	  static String filepath="D:\\WEJM4\\jdbcmockDelete\\resources\\db_info.properties";
	public static void main(String[] args) {
		try {
			FileReader fileReader=new FileReader(filepath);
			
			Properties properties=new Properties();
			properties.load(fileReader);
			Class.forName(properties.getProperty("driver"));
			
			Connection connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);
			Statement Statement = connection.createStatement();
			int result = Statement.executeUpdate(properties.getProperty("query"));
			System.out.println(result+" rews affected");
			
			fileReader.close();
			properties.clone();
			connection.close();
			Statement.close();
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
