package com.actions;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

public class PredictionAction extends ActionSupport{

	private static final String PREDICTIONPIE = "predictionpie";
	private String userNameLogin;
	private HttpSession session;
	
	public void ContactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		session = ServletActionContext.getRequest().getSession();
	}
	
	public String predictionpie() {
		ContactController();
		userNameLogin = (String) session.getAttribute("user");
		return PREDICTIONPIE;
	}

	public String getUserNameLogin() {
		return userNameLogin;
	}
	
	
}
