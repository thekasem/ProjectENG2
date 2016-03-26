package com.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactAUMByCIF;
import com.contact.action.ContactBranchCustomer;
import com.contact.action.ContactLogin;
import com.contact.action.ContactMember;
import com.opensymphony.xwork2.ActionSupport;

public class DashBoardAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -146843680046469165L;
	private static final String DASHBOARD = "dashboard";
	private static final String BROWSERS = "browsers";
	private static final String LOGIN = "login";
	private static final String USER = "user";
	private static final String TOPMODULE = "topmodule";
	private static final String NEWUSER = "newuser";
	private static final String CUSTOMERS = "customers";
	private static final String TOPUSER = "topuser";
	private static final String ARGONSITE = "argonsite";
	private static final String VIEWAUM = "viewaum";
	private static final String DISKUSAGE = "diskusage";

	private String userNameLogin;
	private String date;
	private ContactLogin userController;
	private ContactBranchCustomer ControllerCustomer;
	private ContactAUMByCIF ControllerAUM;
	private ContactMember controllerMember;
	private List<String> listYears = new ArrayList<String>();
	
	public void ContactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		userController = (ContactLogin)context.getBean("userAction");
		ControllerCustomer = (ContactBranchCustomer) context.getBean("branchcustomers");
		ControllerAUM = (ContactAUMByCIF) context.getBean("aumByCIF");
		controllerMember = (ContactMember) context.getBean("members");
		HttpSession session = ServletActionContext.getRequest().getSession();
		userNameLogin = (String) session.getAttribute("user");
		
	}

	public String showDashBoard() {
		ContactController();
		return DASHBOARD;
	}

	public String browser() {
		ContactController();
		listYears = userController.getListYear();
		return BROWSERS;
	}

	public String user() {
		ContactController();
		return USER;
	}

	public String login() {
		ContactController();
		return LOGIN;
	}

	public String topModule() {
		ContactController();
		listYears = userController.getListYear();
		return TOPMODULE;
	}

	public String newUser() {
		ContactController();
		listYears = controllerMember.getListYear();
		return NEWUSER;
	}

	public String customer() {
		ContactController();
		listYears = ControllerCustomer.getListYear();
		return CUSTOMERS;
	}

	public String topUser() {
		ContactController();
		listYears = userController.getListYear();
		return TOPUSER;
	}

	public String argTimeOnSite() {
		ContactController();
		listYears = userController.getListYear();
		return ARGONSITE;
	}

	public String viewAUM() {
		ContactController();
		listYears = ControllerAUM.getListYear();
		return VIEWAUM;
	}

	public String diskUsage() {
		ContactController();
		return DISKUSAGE;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUserNameLogin() {
		return userNameLogin;
	}

	public List<String> getListYears() {
		return listYears;
	}

	
}
