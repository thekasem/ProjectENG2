package com.dao.interfaces;

import java.util.List;

import com.entity.bonanza.MemberMini;


public interface ILoginDao {
	
	public  MemberMini checkLoginUser(String user, String password, boolean mode);
	
	public void updateTimeLogin(Integer userName, int fault);
	
	public void updateTimeLogin(Integer userName, int fault, String dateLogin);
	
	public List<String> getListYear();

}
