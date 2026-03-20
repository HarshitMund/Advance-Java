package com.rays.jdbc.preparedstatement;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {
		
		testAdd();

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

}
