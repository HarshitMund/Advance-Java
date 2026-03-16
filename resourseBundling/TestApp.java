package com.rays.jdbc.resourseBundling;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestApp {

	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.jdbc.resourseBundling.app");

		String driver = rb.getString("driver");
		String url = rb.getString("url");
		String username = rb.getString("username");
		String password = rb.getString("pswd");

		System.out.println(driver + "\n" + url + "\n" + username + "\n" + password);
		
		System.out.println("------------------");

		rb = ResourceBundle.getBundle("com.rays.jdbc.resourseBundling.app", new Locale("hi"));
		System.out.println(rb.getString("greeting"));
		
		rb = ResourceBundle.getBundle("com.rays.jdbc.resourseBundling.app", new Locale("sp"));
		System.out.println(rb.getString("greeting"));

	}

}
