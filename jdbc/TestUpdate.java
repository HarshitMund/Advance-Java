package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestUpdate {

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
		
		int i = stmt.executeUpdate("update st_user set FirstName = 'Dev', LastName = 'Dash', login = 'devd@123', pasword = 'dev@123345' where id = 7 ");
		
		System.out.println(i + " rows affected (rows updated)");
		
		stmt.close();
		conn.close();

	}

}
