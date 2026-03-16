package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestSearch {

	public static void main(String[] args) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("com.rays.jdbc.resourseBundling.app");
		String driver = rb.getString("driver");
		String url = rb.getString("url");
		String username = rb.getString("username");
		String pwd = rb.getString("pswd");
		
		Class.forName(driver);

		Connection conn = DriverManager.getConnection(url, username, pwd);
		System.out.println("Connection established: " + conn.getCatalog());

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt
				.executeQuery("select * from st_user where 1=1 and FirstName like 'a%' and pasword like 'a%'");

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.print("\t" + rs.getString(5));
			System.out.println("\t" + rs.getDate(6));
		}

		stmt.close();
		conn.close();

	}

}
