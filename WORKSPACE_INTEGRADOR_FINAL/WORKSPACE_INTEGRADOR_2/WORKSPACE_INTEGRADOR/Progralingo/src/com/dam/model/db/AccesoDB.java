package com.dam.model.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.sqlite.SQLiteConfig;

public class AccesoDB {
	
	private String driver;
	private String url;
	
	public AccesoDB() {
		Properties prop = new Properties();
		InputStream is = null;
		
		try {
			is = new FileInputStream("db/ConfiguracionDB.properties");
			prop.load(is);
			
			driver = prop.getProperty("DRIVER");
			url = prop.getProperty("URL");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (is != null) is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Connection getConexion() 
			throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url);
		
		return con;
		
	}

}
