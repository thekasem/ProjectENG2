package com.controller.interfaces;

import java.util.List;

import com.entity.bonanza.MemberMini;

public interface IMemberController {
	
	public int countAllByYear(String year);
	
	public List<Float> getListAverageNewUser(String year);
	
	public List<String> getListYear();
	
	public List<Float> getAverage(List<Float> datacurrentyear, List<Float> datalastyear);
	
	public MemberMini showProfile(String loginname);
	
}
