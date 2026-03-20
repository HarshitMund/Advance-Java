package com.rays.jdbc.preparedstatement;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
		testDelete();

	}

	public static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(5);
		bean.setRollNo(105);
		bean.setName("Dev");
		bean.setPhy(75);
		bean.setChm(60);
		bean.setMaths(70);

		MarksheetModel model = new MarksheetModel();
		int id = model.add(bean);

		System.out.println("Record inserted at id: " + id);

	}

	public static void testUpdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(5);
		bean.setRollNo(106);
		bean.setName("Ashu");
		bean.setPhy(70);
		bean.setChm(65);
		bean.setMaths(80);

		MarksheetModel model = new MarksheetModel();
		model.update(bean);

		System.out.println("Record updated");

	}

	public static void testDelete() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(5);

		MarksheetModel model = new MarksheetModel();
		model.delete(bean);

		System.out.println("Record Deleted");

	}

}
