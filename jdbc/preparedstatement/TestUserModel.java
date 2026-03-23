package com.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
//		testDelete();
//		testFindByPK();
//		testFindByLogin();
		testAuthenticate();

	}

	public static void testAdd() throws Exception {

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

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();

		bean.setId(10);
		bean.setFirstName("xzy");
		bean.setLastName("abc");
		bean.setLogin("def@gmail.com");
		bean.setPasword("def123");
		bean.setDob(sdf.parse("2002-02-02"));

		UserModel model = new UserModel();
		model.update(bean);
		System.out.println("record updated");

	}

	public static void testDelete() throws Exception {

		UserBean bean = new UserBean();

		bean.setId(10);

		UserModel model = new UserModel();
		model.delete(bean);
		System.out.println("record Deleted");

	}

	public static void testFindByPK() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean = model.findByPK(2);

		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPasword());
			System.out.println(bean.getDob());
		} else
			System.out.println("User not found");

	}

	public static void testFindByLogin() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean = model.findByLogin("nehag");

		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPasword());
			System.out.println(bean.getDob());
		} else
			System.out.println("User not found");

	}

	public static void testAuthenticate() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean = model.authenticate("nehag", "neha123");

		if (bean != null) 
			System.out
					.println("Authentication Successfull \nWelcome " + bean.getFirstName() + " " + bean.getLastName());
		else
			System.out.println("Authentication Failed... Please try again");

	}

}
