package com.actions;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.bonanza.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts2.interceptors.UserAware;

public class PredictionEachAction extends ActionSupport implements UserAware,
		ModelDriven<User> {

	private static final String EACHPREDICTIONPIE = "eachpredictionpie";
	private HttpSession session;

	public void ContactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		session = ServletActionContext.getRequest().getSession();
	}

	public String predictionpie() {
		ContactController();
		return EACHPREDICTIONPIE;
	}


	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser(User user) {
		return this.user;
	}

	public User getModel() {
		return this.user;
	}

}
