package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MarksheetSearch {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from marksheet");
		
		while(rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.print("\t" + rs.getInt(6));
			int total = rs.getInt(4) + rs.getInt(5) + rs.getInt(6);
			int percentage = total / 3;
			System.out.print("\t" + total);
			System.out.println("\t" + percentage);
		}
		
		stmt.close();
		conn.close();
		
	}

}
