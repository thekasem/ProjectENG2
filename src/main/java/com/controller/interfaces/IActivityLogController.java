package com.controller.interfaces;

import java.util.List;

import com.entity.bonanza.ActivityLogMini;


public interface IActivityLogController {
	
	public List<String> getNameBrowsers(String name,String year);
	
	public List<Float> getDataBrowsers(List<String> name, Boolean searchBy,String year);
	
	public List<Integer> getDataAction(String name, String year);
	
	public List<String> getNameAction(String year);
	
	public int getCountByCriteriaSearch(ActivityLogMini criteriaSearch);
	
	public List<Float> getListAverageTimeOnSite(String year);
	
	public List<String> nameTopUser(String year);
	
	public List<Float> getDataAverageTimeByUser(String year, int numberTop);
}
