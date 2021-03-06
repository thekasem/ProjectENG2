package com.actions;

import com.entity.bonanza.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts2.interceptors.UserAware;

public class WelcomeAction extends ActionSupport implements UserAware, ModelDriven<User> {

	private static final long serialVersionUID = 8111120314704779336L;

	@Override
	public String execute(){
		return SUCCESS;
	}
	
	private User user;
	
	public void setUser(User user) {
		this.user=user;
	}
	
	public User getUser(User user){
		return this.user;
	}

	public User getModel() {
		return this.user;
	}

}
