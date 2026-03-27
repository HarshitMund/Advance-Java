package com.rays.discount;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DiscountModel {
	
	public long add(DiscountBean bean) throws Exception {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/modelproject", "root", "root");
			conn.setAutoCommit(false);
			
			PreparedStatement pstm = conn.prepareStatement("insert into discount values (?, ?, ?, ?, ?)");
			
			pstm.setLong(1, bean.getDiscountId());
			pstm.setString(2, bean.getDiscountCode());
			pstm.setDouble(3, bean.getPercentage());
			pstm.setDate(4, new Date(bean.getExpireDate().getTime()));
			pstm.setString(5, bean.getStatus());
			
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
		
		return bean.getDiscountId();
		
	}

}
