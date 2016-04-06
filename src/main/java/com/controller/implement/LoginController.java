package com.controller.implement;

import java.util.List;

import com.controller.interfaces.ILoginController;
import com.dao.interfaces.ILoginDao;

public class LoginController implements ILoginController {
      private ILoginDao loginDao;

	public ILoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(ILoginDao loginDao) {
		this.loginDao = loginDao;
	}


	public boolean checkLoginUser(String user, String password) {
		return loginDao.checkLoginUser(user, password);
	}


	public List<String> getListYear() {
		return loginDao.getListYear();
	}
      
      
}
