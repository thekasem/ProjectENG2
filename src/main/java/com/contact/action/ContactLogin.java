package com.contact.action;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.controller.interfaces.ILoginController;
import com.entity.User;

public class ContactLogin implements ILoginController {
	
	private ILoginController loginController;
	

	public ILoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(ILoginController loginController) {
		this.loginController = loginController;
	}

	public User checkLogin(String user, String password) {
		// TODO Auto-generated method stub
		return loginController.checkLogin(user, password);
	}

	public boolean checkLoginUser(String user, String password) {
		// TODO Auto-generated method stub
		return loginController.checkLoginUser(user, password);
	}

	public List<User> getUser() {
		// TODO Auto-generated method stub
		return loginController.getUser();
	}

	public void testSent(List<User> list) throws IllegalAccessException,
			InvocationTargetException {
		loginController.testSent(list);
		
	}

	public List<String> getListYear() {
		return loginController.getListYear();
	}
	

}
