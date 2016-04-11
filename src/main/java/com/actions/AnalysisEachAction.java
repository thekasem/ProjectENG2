package com.actions;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactBuyAsset;
import com.opensymphony.xwork2.ActionSupport;

public class AnalysisEachAction extends ActionSupport {
	
	private static final long serialVersionUID = -8443598230468274297L;
	private static final String EACHANALYSISPIE = "eachanalysispie";

	private static final String EACHANALYSISLINE = "eachanalysisline";
	private static final String EACHANALYSISCOLUMN = "eachanalysiscolumn";
	private static final String EACHANALYSISSCATTER = "eachanalysisscatter";
	private HttpSession session;
	private String userNameLogin;
	private List<String> listYears;
	private ContactBuyAsset contBuyAsset;

	public void ContactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		contBuyAsset = (ContactBuyAsset) context.getBean("buyasset");
		session = ServletActionContext.getRequest().getSession();
	}

	public String analysispie() {
		ContactController();
		userNameLogin = (String) session.getAttribute("user");
		listYears = contBuyAsset.getListYear();
		return EACHANALYSISPIE;
	}

	public String analysisline() {
		ContactController();
		userNameLogin = (String) session.getAttribute("user");
		listYears = contBuyAsset.getListYear();
		return EACHANALYSISLINE;
	}

	public String analysiscolumn() {
		ContactController();
		userNameLogin = (String) session.getAttribute("user");
		listYears = contBuyAsset.getListYear();
		return EACHANALYSISCOLUMN;
	}

	public String analysisscatter() {
		ContactController();
		userNameLogin = (String) session.getAttribute("user");
		listYears = contBuyAsset.getListYear();
		return EACHANALYSISSCATTER;
	}

	public String getUserNameLogin() {
		return userNameLogin;
	}

	public List<String> getListYears() {
		return listYears;
	}

}
