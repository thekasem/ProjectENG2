package com.actions;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactActivityArchiveLog;
import com.contact.action.ContactApplicationArchiveLog;
import com.contact.action.ContactLogin;
import com.entity.User;
import com.entity.archive.ArchiveActivityLogMini;
import com.entity.archive.ArchiveApplicationLogMini;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private String username,userpass;
	private String arlert = "Login Fail";
	private List<ArchiveApplicationLogMini> list;
	private ContactLogin userController;
	private ContactApplicationArchiveLog archiveController;
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




	public List<ArchiveApplicationLogMini> getList() {
		return list;
	}


	public void ContactController(){
    	ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
    	 userController = (ContactLogin)context.getBean("userAction");
    	 archiveController = (ContactApplicationArchiveLog)context.getBean("applicationArchive");
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
				ArchiveApplicationLogMini archive = new ArchiveApplicationLogMini();
				archiveController.addArchive("20150101", "=");
				list = archiveController.getList(archive, true, false, 0, 15);
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
		ArchiveApplicationLogMini archive = new ArchiveApplicationLogMini();
		list = archiveController.getList(archive, true, false, 0, 15);
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
