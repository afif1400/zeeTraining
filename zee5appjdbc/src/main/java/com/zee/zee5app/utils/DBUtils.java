package com.zee.zee5app.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	//this class is used to get the db connection and to close the connection
	
	//singleton DP
	
	private DBUtils() throws IOException {
		Properties properties = loadProperties();
	}
	private static DBUtils dbUtils;
	public static DBUtils getInstance() throws IOException{
		if(dbUtils ==null)
			//but we refer using interface only i.e.
			//repository = new UserRepository()
			// we can only access interface methods
			
			// this will use functionalities of the interface and both class only
			dbUtils = new DBUtils();
		return dbUtils;
	}
	
	public Connection getConnection() {
		//get db connection
		
		Connection connection = null;
		
		try {
			properties = loadProperties();
			
			connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),
					properties.getProperty("jdbc.username"),
					properties.getProperty("jdbc.password"));
			System.out.println(properties);
			return connection;
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	Properties properties;
	private Properties loadProperties() throws IOException {
		//read the properties file
		InputStream inputStream =  DBUtils.class.getClassLoader().getResourceAsStream("application.properties");
		
		Properties properties = new Properties();
		properties.load(inputStream);
		// this will read properties internally
		
		return properties;
	}
	
//	public static void main(String[] args) {
//		DBUtils dbUtils = DBUtils.getInstance();
//		Connection connection = dbUtils.getConnection();
//		System.out.println(connection!=null);
//		//getting the connection object
//		
//       				
//	}
//	

}
