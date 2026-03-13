package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		System.out.println("Connection successfully established: " + conn.getCatalog());
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("INSERT INTO st_user VALUES (1,'Rahul','Sharma','rahul123','pass123','1998-05-10'), (2,'Amit','Verma','amitv','amit@123','1997-08-15'),(3,'Neha','Gupta','nehag','neha123','1999-02-20'), (4,'Rohit','Singh','rohits','rohit@321','1996-11-25'), (5,'Priya','Mehta','priyam','priya123','2000-03-12'),(6,'Ankit','Jain','ankitj','ankit@456','1995-07-30'),(7,'Pooja','Agarwal','poojaa','pooja789','1998-09-18'),(8,'Vikas','Yadav','vikasy','vikas@123','1997-12-05'),(9,'Sneha','Patel','snehap','sneha456','1999-06-22'),(10,'Arjun','Kumar','arjunk','arjun@789','1996-01-14')");
		
		System.out.println(i + " rows affected (records inserted)");
		
		conn.close();
		stmt.close();
		
	}
	
}
