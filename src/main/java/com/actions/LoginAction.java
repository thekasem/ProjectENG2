package com.actions;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactLogin;
import com.entity.bonanza.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements SessionAware, ModelDriven<User>{

	private static final long serialVersionUID = -3369875299120377549L;
	private String arlert = "Login Fail";
	private ContactLogin userController;
	private HttpSession session;
	
	public void ContactController(){
    	ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
    	 userController = (ContactLogin)context.getBean("userAction");
    	 session = ServletActionContext.getRequest().getSession();
    }

	@Override
	public String execute(){
		ContactController();
		boolean userlogin;
		userlogin = userController.checkLoginUser(user.getUser(), user.getPassword());
//		System.out.println("inside execute");
		if(userlogin){
			arlert = "";
			user.setUserName(user.getUser());
			sessionAttributes.put("USER", user);
			return SUCCESS;
		}
		return INPUT;
	}
	
	public String logout(){
    	session = ServletActionContext.getRequest().getSession();
    	arlert = "";
    	session.removeAttribute("USER");
    	return INPUT;
    }
	
	private User user = new User();
	private Map<String, Object> sessionAttributes = null;

	public void setSession(Map<String, Object> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}
	
	public User getModel() {
		return user;
	}
	
}
