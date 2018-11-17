package com.cg.ams.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.ams.exceptions.AssetException;

public class JdbcUtility {
	private static Connection connection = null;
	public static  Connection getConnection() throws AssetException
	{
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(new File("res/db.properties")));
			String driver = properties.getProperty("db.driver");
			String url = properties.getProperty("db.url");
			String username = properties.getProperty("db.username");
			String password = properties.getProperty("db.password");
			try 
			{
				Class.forName(driver);
				try 
				{
					connection = DriverManager.getConnection(url, username, password);
				} catch (SQLException e)
				{
					throw new AssetException("connection was not established");
				}
			} catch (ClassNotFoundException e) 
			{
				throw new AssetException("Unable to loads the class");
			}
			
		} 
		catch (IOException e)
		{
		 throw new AssetException("File not found");
		}
		return connection;
	}
	public static void closeconnection() throws AssetException
	{
		try {
			connection.close();
		} catch (SQLException e) {
			throw new AssetException("Unable to close");
		}
	}

}
