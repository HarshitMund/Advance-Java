package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List searchByCompany(String company) throws Exception {

		List list = new ArrayList();
		EmployeeBean bean = null;
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			PreparedStatement pstm = conn.prepareStatement("select * from employee where COMPANY = ?");
			pstm.setString(1, company);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				bean = new EmployeeBean();
				bean.setID(rs.getInt(1));
				bean.setNAME(rs.getString(2));
				bean.setCOMPANY(rs.getString(3));
				bean.setSAALARY(rs.getInt(4));
				bean.setDEPT_NO(rs.getInt(5));
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

	public EmployeeBean FindById(int id) throws Exception {
		
		EmployeeBean bean = null;
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
			
			PreparedStatement pstm = conn.prepareStatement("select * from employee where id = ?");
			pstm.setInt(1, id);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				bean = new EmployeeBean();
				bean.setID(rs.getInt(1));
				bean.setNAME(rs.getString(2));
				bean.setCOMPANY(rs.getString(3));
				bean.setSAALARY(rs.getInt(4));
				bean.setDEPT_NO(rs.getInt(5));
			}
			pstm.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
		return bean;
	}
	
	public List<EmployeeBean> search(EmployeeBean bean) throws Exception {
		
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		
		StringBuffer sb = new StringBuffer("select * from employee where 1 = 1 ");
		
		if(bean != null) {
			
			if(bean.getNAME() != null && bean.getNAME().length() > 0)
				sb.append("and NAME like '" + bean.getNAME() + "%'");
			
			if(bean.getCOMPANY() != null && bean.getCOMPANY().length() > 0)
				sb.append("and COMPANY like '" + bean.getCOMPANY() + "%'");
			
			if(bean.getID() != 0 && bean.getID() > 0)
				sb.append("and ID = " + bean.getID());
		}
		
		PreparedStatement pstm = conn.prepareStatement(sb.toString());
		
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next()) {
			bean = new EmployeeBean();
			bean.setID(rs.getInt(1));
			bean.setNAME(rs.getString(2));
			bean.setCOMPANY(rs.getString(3));
			bean.setSAALARY(rs.getInt(4));
			bean.setDEPT_NO(rs.getInt(5));
			list.add(bean);
		}
		
		pstm.close();
		conn.close();
		
		return list;
	}
}
