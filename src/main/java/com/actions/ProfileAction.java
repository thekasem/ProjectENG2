package com.actions;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactMember;
import com.entity.bonanza.MemberMini;
import com.opensymphony.xwork2.ActionSupport;

public class ProfileAction extends ActionSupport {
	private ContactMember ControllerMember;
	private String userNameLogin;
	private MemberMini member;
	private HttpSession session;

	public void ContactController(){
    	ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
    	ControllerMember = ((ContactMember) context.getBean("members"));
    	session = ServletActionContext.getRequest().getSession();
    }
	
	public String profile() {
		ContactController();
		userNameLogin = (String) session.getAttribute("user");
		member = ControllerMember.showProfile(userNameLogin);
		return "profile";
	}

	public String getUserNameLogin() {
		return userNameLogin;
	}

	public MemberMini getMember() {
		return member;
	}
	
}
