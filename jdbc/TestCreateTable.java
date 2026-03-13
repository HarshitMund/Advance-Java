package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCreateTable {

	public static void main(String[] args) throws Exception {
		 
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		System.out.println("Connection established: " + conn.getCatalog());
		
		Statement stmt = conn.createStatement();
		
		boolean pass = stmt.execute("create table st_user (id int primary key, FirstName varchar(20), LastName varchar(20), login varchar(45), pasword varchar(45), dob date)");
		
		System.out.println("Table created");
		
		conn.close();
		stmt.close();
		
	}

}
