package com.actions;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

public class AnalysisAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8443598230468274297L;
	private static final String ANALYSISPIE = "analysispie";
	
	private static final String ANALYSISLINE = "analysisline";
	private static final String ANALYSISCOLUMN = "analysiscolumn";
	private static final String ANALYSISSCATTER = "analysisscatter";
	private HttpSession session;
	private String userNameLogin;
	
	public void ContactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		session = ServletActionContext.getRequest().getSession();
	}

	public String analysispie() {
		ContactController();
		userNameLogin = (String) session.getAttribute("user");
		return ANALYSISPIE;
	}

	
	
	public String analysisline() {
		ContactController();
		userNameLogin = (String) session.getAttribute("user");
		return ANALYSISLINE;
	}
	
	public String analysiscolumn() {
		ContactController();
		userNameLogin = (String) session.getAttribute("user");
		return ANALYSISCOLUMN;
	}
	
	public String analysisscatter() {
		ContactController();
		userNameLogin = (String) session.getAttribute("user");
		return ANALYSISSCATTER;
	}

	public String getUserNameLogin() {
		return userNameLogin;
	}
	
	
	
}