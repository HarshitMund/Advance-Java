package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserModel {

	public int add(UserBean bean) throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstm = conn.prepareStatement("insert into st_user values(?, ?, ?, ?, ?, ?");

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

}
