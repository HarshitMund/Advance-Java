package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {

	public int add(MarksheetBean bean) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
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

	public void update(MarksheetBean bean) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update marksheet set rollNo = ?, name = ?, phy = ?, chm = ?, maths = ? where id = ?");

			pstmt.setInt(1, bean.getRollNo());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPhy());
			pstmt.setInt(4, bean.getChm());
			pstmt.setInt(5, bean.getMaths());
			pstmt.setInt(6, bean.getId());

			int i = pstmt.executeUpdate();
			System.out.println(i + " rows affected (rows updated)");

			conn.commit();
			pstmt.close();

		} catch (Exception e) {

			e.printStackTrace();
			conn.rollback();

		} finally {

			conn.close();

		}

	}

	public void delete(MarksheetBean bean) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"delete from marksheet where id = ?");

			pstmt.setInt(1, bean.getId());

			int i = pstmt.executeUpdate();
			System.out.println(i + " rows affected (rows deleted)");

			conn.commit();
			pstmt.close();

		} catch (Exception e) {

			e.printStackTrace();
			conn.rollback();

		} finally {

			conn.close();

		}

	}
	
	public List findStudentByPercentage(int percentage) throws Exception {
		
		List list = new ArrayList();
		MarksheetBean bean = null;
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
			
			PreparedStatement pstm = conn.prepareStatement("select * from marksheet where (phy+chm+maths)/3 > ?");
			pstm.setInt(1, percentage);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				bean = new MarksheetBean();
				bean.setId(rs.getInt(1));
				bean.setRollNo(rs.getInt(2));
				bean.setName(rs.getString(3));
				bean.setPhy(rs.getInt(4));
				bean.setChm(rs.getInt(5));
				bean.setMaths(rs.getInt(6));
				list.add(bean);
			}
			
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
		return list;
	}
	
}
