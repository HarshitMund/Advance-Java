package com.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;

public class TestUserModel {

	public static void main(String[] args) throws Exception {
		
		testAdd();

	}
	
	public static void testAdd() throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();
		
		bean.setId(10);
		bean.setFirstName("abc");
		bean.setLastName("xyz");
		bean.setLogin("abc@gmail.com");
		bean.setPasword("abc123");
		bean.setDob(sdf.parse("2002-02-02"));
		
		UserModel model = new UserModel();
		int id = model.add(bean);
		System.out.println("record inserted at id: " + id);
		
	}

}
