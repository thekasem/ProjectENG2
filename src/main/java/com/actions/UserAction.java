package com.actions;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactLogin;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private String username,userpass;
	private String arlert = "Login Fail";
	private ContactLogin userController;
	private String userNameLogin;
	private HttpSession session;
	
	

	public String getUserNameLogin() {
		return userNameLogin;
	}


	public void setUserNameLogin(String userNameLogin) {
		this.userNameLogin = userNameLogin;
	}


	public String getArlert() {
		return arlert;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUserpass() {
		return userpass;
	}


	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}





	public void ContactController(){
    	ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
    	 userController = (ContactLogin)context.getBean("userAction");
    	 session = ServletActionContext.getRequest().getSession();
    }
	
	public String execute() {
	ContactController();
		String result = "fail";
		 session.setAttribute("user", username);
		boolean userlogin ;
		try{
		  userlogin = userController.checkLoginUser(username, userpass);
			if (userlogin){
				arlert = "";
				userNameLogin = (String) session.getAttribute("user");
				result = "success";
				
				return result;
			}
		}catch(Exception e){
			result= "fail";
			e.printStackTrace();
		}
		
		return result;
	}

	public String homeFirst(){
		ContactController();
		userNameLogin = (String) session.getAttribute("user");
		return "success";
	}
    public String logout(){
    	session = ServletActionContext.getRequest().getSession();
    	arlert = "";
    	session.removeAttribute("user");
    	return "logout";
    }
}
