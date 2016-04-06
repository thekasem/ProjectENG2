package com.dao.interfaces;

import java.util.List;


public interface ILoginDao {
	
	public  boolean checkLoginUser(String user, String password);
	
	public List<String> getListYear();

}
