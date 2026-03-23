package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeModel {

	public int add(EmployeeBean bean) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
			conn.setAutoCommit(false);

			PreparedStatement pstm = conn.prepareStatement("insert into Employee values(?, ?, ?, ?, ?)");

			pstm.setInt(1, bean.getID());
			pstm.setString(2, bean.getNAME());
			pstm.setString(3, bean.getCOMPANY());
			pstm.setInt(4, bean.getSAALARY());
			pstm.setInt(5, bean.getDEPT_NO());

			int i = pstm.executeUpdate();
			System.out.println(i + " rows affected (rows inserted)");

			pstm.close();
			conn.commit();

		} catch (Exception e) {

			e.printStackTrace();
			conn.rollback();

		} finally {
			conn.close();
		}

		return bean.getID();
	}

	public void update(EmployeeBean bean) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
			conn.setAutoCommit(false);

			PreparedStatement pstm = conn.prepareStatement(
					"update Employee set NAME = ?, COMPANY = ?, SAALARY = ?, DEPT_ID = ? where id = ?");

			pstm.setString(1, bean.getNAME());
			pstm.setString(2, bean.getCOMPANY());
			pstm.setInt(3, bean.getSAALARY());
			pstm.setInt(4, bean.getDEPT_NO());
			pstm.setInt(5, bean.getID());

			int i = pstm.executeUpdate();
			System.out.println(i + " rows affected (rows updated)");

			pstm.close();
			conn.commit();

		} catch (Exception e) {

			e.printStackTrace();
			conn.rollback();

		} finally {
			conn.close();
		}
		
	}

	public void delete(EmployeeBean bean) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
			conn.setAutoCommit(false);

			PreparedStatement pstm = conn.prepareStatement("delete from Employee where id = ?");

			pstm.setInt(1, bean.getID());
	
			int i = pstm.executeUpdate();
			System.out.println(i + " rows affected (rows deleted)");

			pstm.close();
			conn.commit();

		} catch (Exception e) {

			e.printStackTrace();
			conn.rollback();

		} finally {
			conn.close();
		}

	}

}
