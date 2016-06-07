package com.actions;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactMember;
import com.entity.bonanza.MemberMini;
import com.entity.bonanza.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts2.interceptors.UserAware;

public class ProfileAction extends ActionSupport implements UserAware, ModelDriven<User> {
	private ContactMember ControllerMember;
	private String userNameLogin;
	private MemberMini member;
	private HttpSession session;

	public void ContactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		ControllerMember = ((ContactMember) context.getBean("members"));
		session = ServletActionContext.getRequest().getSession();
	}

	public String profile() {
		ContactController();
		userNameLogin = user.getUserName();
		member = ControllerMember.showProfile(userNameLogin);
		return "profile";
	}

	public String getUserNameLogin() {
		return userNameLogin;
	}

	public MemberMini getMember() {
		return member;
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
