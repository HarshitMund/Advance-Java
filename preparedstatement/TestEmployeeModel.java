package com.rays.jdbc.preparedstatement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestEmployeeModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
//		testDelete();
//		testSearchByCompany();
//		testFindById();
		testSreach();

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

	public static void testSearchByCompany() throws Exception {

		List list = new ArrayList();

		EmployeeModel model = new EmployeeModel();
		list = model.searchByCompany("TCS");

		Iterator i = list.iterator();

		while (i.hasNext()) {
			EmployeeBean bean = (EmployeeBean) i.next();
			System.out.println(bean.getID() + " " + bean.getNAME() + " " + bean.getCOMPANY() + " " + bean.getSAALARY()
					+ " " + bean.getDEPT_NO());
		}
	}
	
	public static void testFindById() throws Exception {
		
		EmployeeBean bean = new EmployeeBean();
		EmployeeModel model = new EmployeeModel();
		
		bean = model.FindById(10);
		
		System.out.println(bean.getID());
		System.out.println(bean.getNAME());
		System.out.println(bean.getCOMPANY());
		System.out.println(bean.getSAALARY());
		System.out.println(bean.getDEPT_NO());
	}
	
	public static void testSreach() throws Exception {
		
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		
		EmployeeBean bean = new EmployeeBean();
		EmployeeModel model = new EmployeeModel();
		
		list = model.search(bean);
		
		Iterator<EmployeeBean> it = list.iterator();
		
		while(it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getID());
			System.out.print("\t" + bean.getNAME());
			System.out.print("\t" + bean.getCOMPANY());
			System.out.print("\t" + bean.getSAALARY());
			System.out.println("\t" + bean.getDEPT_NO());
		}
	}

}
