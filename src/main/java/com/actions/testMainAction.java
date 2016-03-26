package com.actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class testMainAction {

	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String dateToday = dateFormat.format(new Date());
		
		System.out.println("date Today is :"+ dateToday);
		

	}

}
