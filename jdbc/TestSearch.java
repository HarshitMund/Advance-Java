package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSearch {
	
public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		System.out.println("Connection established: " + conn.getCatalog());
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from st_user where 1=1 and FirstName like 'a%' and pasword like 'a%'");
		
		while(rs.next()) {
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
