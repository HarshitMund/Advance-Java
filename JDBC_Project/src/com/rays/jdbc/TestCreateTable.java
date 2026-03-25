package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestCreateTable {

	public static void main(String[] args) throws Exception {
		
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.jdbc.resourseBundling.app");
		String driver = rb.getString("driver");
		String url = rb.getString("url");
		String username = rb.getString("username");
		String pwd = rb.getString("pswd");
		
		Class.forName(driver);

		Connection conn = DriverManager.getConnection(url, username, pwd);
		 
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		System.out.println("Connection established: " + conn.getCatalog());
		
		Statement stmt = conn.createStatement();
		
		boolean pass = stmt.execute("create table st_user (id int primary key, FirstName varchar(20), LastName varchar(20), login varchar(45), pasword varchar(45), dob date)");
		
		System.out.println("Table created");
		
		conn.close();
		stmt.close();
		
	}

}
