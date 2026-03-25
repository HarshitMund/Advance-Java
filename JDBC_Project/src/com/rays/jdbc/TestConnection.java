package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestConnection {

	public static void main(String[] args) throws Exception {
		
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.jdbc.resourseBundling.app");
		String driver = rb.getString("driver");
		String url = rb.getString("url");
		String username = rb.getString("username");
		String pwd = rb.getString("pswd");
		
		Class.forName(driver);

		Connection conn = DriverManager.getConnection(url, username, pwd);

		//Step 1 Load Driver
//		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Step 2 Make Connection to the database
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays" , "root", "root");
		
		System.out.println("Connection established successfully: " + conn.getCatalog());
		
		//Step 3 Create Statement and get ResultSet or get number of rows
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from employee");
		
		while(rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.println("\t" + rs.getInt(4));
		}
		
		
	}

}
