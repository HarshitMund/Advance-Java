package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MarksheetModel {

	public int add(MarksheetBean bean) throws Exception {

		Connection conn = null;

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
			conn.setAutoCommit(false);
			
			PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");
			
			pstmt.setInt(1, bean.getId());
			pstmt.setInt(2, bean.getRollNo());
			pstmt.setString(3, bean.getName());
			pstmt.setInt(4, bean.getPhy());
			pstmt.setInt(5, bean.getChm());
			pstmt.setInt(6, bean.getMaths());
			
			int i = pstmt.executeUpdate();
			System.out.println(i + " rows affected (rows inserted)");
			
			conn.commit();
			pstmt.close();

		} catch (Exception e) {
			
			e.printStackTrace();
			conn.rollback();

		} finally {
			
			conn.close();

		}

		return bean.getId();

	}

}
