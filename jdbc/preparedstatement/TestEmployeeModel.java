package com.rays.jdbc.preparedstatement;

public class TestEmployeeModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
		testDelete();

	}

	public static void testAdd() throws Exception {

		EmployeeBean bean = new EmployeeBean();

		bean.setID(26);
		bean.setNAME("abc");
		bean.setCOMPANY("xyz");
		bean.setSAALARY(12235);
		bean.setDEPT_NO(2);

		EmployeeModel model = new EmployeeModel();
		int i = model.add(bean);
		System.out.println("Record inserted in id: " + i);
	}

	public static void testUpdate() throws Exception {

		EmployeeBean bean = new EmployeeBean();

		bean.setID(26);
		bean.setNAME("xyz");
		bean.setCOMPANY("zbc");
		bean.setSAALARY(98765);
		bean.setDEPT_NO(1);

		EmployeeModel model = new EmployeeModel();
		model.update(bean);
		System.out.println("Record updated");
	}

	public static void testDelete() throws Exception {

		EmployeeBean bean = new EmployeeBean();

		bean.setID(26);

		EmployeeModel model = new EmployeeModel();
		model.delete(bean);
		System.out.println("Record delete");
	}

}
