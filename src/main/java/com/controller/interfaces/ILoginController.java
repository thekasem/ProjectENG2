package com.controller.interfaces;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.entity.User;

public interface ILoginController {
	public User checkLogin(String user, String password);

	public boolean checkLoginUser(String user, String password);
	
	List<User> getUser();
	
	public void testSent(List<User> list) throws IllegalAccessException, InvocationTargetException;
	
	public List<String> getListYear();
}
