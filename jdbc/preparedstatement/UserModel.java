package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {

	public int add(UserBean bean) throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstm = conn.prepareStatement("insert into st_user values(?, ?, ?, ?, ?, ?)");

			pstm.setInt(1, bean.getId());
			pstm.setString(2, bean.getFirstName());
			pstm.setString(3, bean.getLastName());
			pstm.setString(4, bean.getLogin());
			pstm.setString(5, bean.getPasword());
			pstm.setDate(6, new java.sql.Date(bean.getDob().getTime()));

			int i = pstm.executeUpdate();

			System.out.println(i + " row affected(record inserted)");
			conn.commit();
			pstm.close();

		} catch (Exception e) {

			e.printStackTrace();
			conn.rollback();

		} finally {
			conn.close();
		}

		return bean.getId();

	}

	public void update(UserBean bean) throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstm = conn.prepareStatement(
					"update st_user set FirstName = ?, LastName = ?, login = ?, pasword = ?, dob = ? where id = ?");

			pstm.setString(1, bean.getFirstName());
			pstm.setString(2, bean.getLastName());
			pstm.setString(3, bean.getLogin());
			pstm.setString(4, bean.getPasword());
			pstm.setDate(5, new java.sql.Date(bean.getDob().getTime()));
			pstm.setInt(6, bean.getId());

			int i = pstm.executeUpdate();

			System.out.println(i + " row affected(record update)");
			conn.commit();
			pstm.close();

		} catch (Exception e) {

			e.printStackTrace();
			conn.rollback();

		} finally {
			conn.close();
		}

	}

	public void delete(UserBean bean) throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstm = conn.prepareStatement("delete from st_user where id = ?");

			pstm.setInt(1, bean.getId());

			int i = pstm.executeUpdate();

			System.out.println(i + " row affected(record update)");
			conn.commit();
			pstm.close();

		} catch (Exception e) {

			e.printStackTrace();
			conn.rollback();

		} finally {
			conn.close();
		}

	}

	public UserBean findByPK(int id) throws Exception {

		Connection conn = null;
		UserBean bean = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			PreparedStatement pstm = conn.prepareStatement("select * from st_user where id = ?");

			pstm.setInt(1, id);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPasword(rs.getString(5));
				bean.setDob(rs.getDate(6));
			}

			pstm.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;
	}

	public UserBean findByLogin(String login) throws Exception {

		Connection conn = null;
		UserBean bean = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			PreparedStatement pstm = conn.prepareStatement("select * from st_user where login = ?");

			pstm.setString(1, login);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPasword(rs.getString(5));
				bean.setDob(rs.getDate(6));
			}

			pstm.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;
	}

	public UserBean authenticate(String login, String password) throws Exception{
		
		Connection conn = null;
		UserBean bean = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
			
			PreparedStatement pstm = conn.prepareStatement("select * from st_user where login = ? and pasword = ?");
			
			pstm.setString(1, login);
			pstm.setString(2, password);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPasword(rs.getString(5));
				bean.setDob(rs.getDate(6));
			}
			
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
		return bean;
	}
}
