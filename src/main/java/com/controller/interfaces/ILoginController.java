package com.controller.interfaces;

import java.util.List;


public interface ILoginController {

	public String checkLoginUser(String user, String password);
	
	public List<String> getListYear();
}
