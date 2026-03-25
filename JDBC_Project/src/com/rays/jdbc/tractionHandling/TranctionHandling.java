package com.rays.jdbc.tractionHandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TranctionHandling {

	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
			System.out.println("Connection successfully established: " + conn.getCatalog());
			
			conn.setAutoCommit(false);
			
			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate(
					"INSERT INTO st_user VALUES (10,'Rahul','Sharma','rahul123','pass123','1998-05-10'), (11,'Amit','Verma','amitv','amit@123','1997-08-15'),(12,'Neha','Gupta','nehag','neha123','1999-02-20'), (4,'Rohit','Singh','rohits','rohit@321','1996-11-25'), (5,'Priya','Mehta','priyam','priya123','2000-03-12')");

			System.out.println(i + " rows affected (records inserted)");

			conn.commit();
			stmt.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			conn.rollback();
			
		} finally {
			
			conn.close();
			
		}

	}

}
