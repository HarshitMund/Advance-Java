package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MarksheetDelete {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("delete from marksheet where id = 5");
		
		System.out.println(i + " row affected (rows deleted)");
		
		conn.close();
		stmt.close();

	}

}
