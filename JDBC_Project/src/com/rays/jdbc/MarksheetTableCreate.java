package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MarksheetTableCreate {

	public static void main(String[] args) throws Exception {
		 
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		System.out.println("Connection established: " + conn.getCatalog());
		
		Statement stmt = conn.createStatement();
		
		boolean pass = stmt.execute("create table marksheet (id int primary key, rollNo int, name varchar(45), phy int, chm int, maths int)");
		
		System.out.println("Table created");
		
		conn.close();
		stmt.close();

	}

}
