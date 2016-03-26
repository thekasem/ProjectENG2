package com.controller.implement;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.controller.interfaces.ILoginController;
import com.dao.interfaces.ILoginDao;
import com.entity.User;

public class LoginController implements ILoginController {
      private ILoginDao loginDao;

	public ILoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(ILoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public User checkLogin(String user, String password) {
		return loginDao.checkLogin(user, password);
	}

	public boolean checkLoginUser(String user, String password) {
		return loginDao.checkLoginUser(user, password);
	}

	public List<User> getUser() {
		return loginDao.getUser();
	}

	public void testSent(List<User> list) throws IllegalAccessException, InvocationTargetException {
		loginDao.testSent(list);
		
	}

	public List<String> getListYear() {
		return loginDao.getListYear();
	}
      
      
}
