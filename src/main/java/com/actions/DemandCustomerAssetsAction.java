package com.actions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

public class DemandCustomerAssetsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4046499723306978192L;
	private static final String ANALYSIS = "analysis";
	private static final String PREDICTION = "prediction";

	public void ContactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
	}

	public String analysis() {
		ContactController();
		return ANALYSIS;
	}

	public String prediction() {
		ContactController();
		return PREDICTION;
	}
}