package com.tap.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorFactory {
	
	//utility classes always contains static
	//These are used to serve some purpose
	static Connection con = null;
	static String url = "jdbc:mysql://localhost:3306/employee";
	static String unm = "root";
	static String pwd = "saiprema@3343";
	public static Connection requestConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, unm, pwd);
		return con;
		
	}

}
