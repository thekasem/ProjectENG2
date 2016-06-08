package com.contact.action;

import java.util.List;

import com.controller.interfaces.ILoginController;

public class ContactLogin implements ILoginController {
	
	private ILoginController loginController;
	

	public ILoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(ILoginController loginController) {
		this.loginController = loginController;
	}


	public String checkLoginUser(String user, String password) {
		// TODO Auto-generated method stub
		return loginController.checkLoginUser(user, password);
	}


	public List<String> getListYear() {
		return loginController.getListYear();
	}
	

}
