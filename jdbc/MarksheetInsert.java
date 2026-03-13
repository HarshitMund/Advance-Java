package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MarksheetInsert {
	
public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		System.out.println("Connection successfully established: " + conn.getCatalog());
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("INSERT INTO marksheet VALUES (1,101,'Rahul',78,82,90), (2,102,'Amit',65,70,72), (3,103,'Neha',88,91,85), (4,104,'Rohit',55,60,58),(5,105,'Priya',92,89,95)");
		
		System.out.println(i + " rows affected (records inserted)");
		
	}

}
