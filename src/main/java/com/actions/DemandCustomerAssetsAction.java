package com.actions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

public class DemandCustomerAssetsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8443598230468274297L;
	private static final String ANALYSISPIE = "analysispie";
	private static final String PREDICTIONPIE = "predictionpie";
	private static final String ANALYSISCOLUMN = "analysiscolumn";
	private static final String PREDICTIONCOLUMN = "predictioncolumn";

	public void ContactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
	}

	public String analysispie() {
		ContactController();
		return ANALYSISPIE;
	}

	public String predictionpie() {
		ContactController();
		return PREDICTIONPIE;
	}
	
	public String analysiscolumn() {
		ContactController();
		return ANALYSISCOLUMN;
	}

	public String predictioncolumn() {
		ContactController();
		return PREDICTIONCOLUMN;
	}
}