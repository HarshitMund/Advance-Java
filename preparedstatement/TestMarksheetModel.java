package com.rays.jdbc.preparedstatement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
//		testDelete();
		testFindStudentByPercentage();

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
	
	public static void testFindStudentByPercentage() throws Exception {
		
		MarksheetModel model = new MarksheetModel();
		List list = new ArrayList();
		
		list = model.findStudentByPercentage(60);
		
		Iterator i = list.iterator();
		
		while(i.hasNext()) {
			MarksheetBean bean = (MarksheetBean) i.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhy());
			System.out.print("\t" + bean.getChm());
			System.out.println("\t" + bean.getMaths());
		}
	}

}
