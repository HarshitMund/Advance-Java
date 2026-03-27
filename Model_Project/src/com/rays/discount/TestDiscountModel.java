package com.rays.discount;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDiscountModel {

	public static void main(String[] args) throws Exception {
		
		testAdd();

	}
	
	public static void testAdd() throws Exception {
		
		DiscountBean bean = new DiscountBean();
		DiscountModel model = new DiscountModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		bean.setDiscountId(16);
		bean.setDiscountCode("SUPERSALE40");
		bean.setPercentage(39.50);
		bean.setExpireDate(sdf.parse("2026-03-28"));
		bean.setStatus("ACTIVE");
		
		long id = model.add(bean);
		System.out.println("Record inserted at ID: " + id);
		
	}

}
