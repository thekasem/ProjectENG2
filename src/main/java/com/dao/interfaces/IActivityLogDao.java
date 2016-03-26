package com.dao.interfaces;

import java.util.List;

import com.entity.bonanza.ActivityLogMini;
import com.entity.bonanza.BranchCustomerMini;


public interface IActivityLogDao {

	 public String createCriteriaSearch(ActivityLogMini obj, boolean isOrdering, boolean isAscending, boolean isCount);
		
	 public List<ActivityLogMini> getListByCriteriaSearch(ActivityLogMini criteriaSearch, boolean isOrdering, boolean isAscending, int firstResult, int maxResult);
	 
	 public int getCountByCriteriaSearch(ActivityLogMini criteriaSearch);
	 
	 public ActivityLogMini getObjectById(int eventId);

	 public void save(ActivityLogMini entity);
	 
	 public void delete(ActivityLogMini entity);
	 
	 public List<ActivityLogMini> getListByDate(String date, String condition);
	 
	 public int getDataBrowsers(String name, Boolean searchBy,String year);
	 
	 public List<String> getNameBrowsers(String name,String year);
	 
	 public List<String> getNameAction(String year);
	 
	 public int getDataAction(String name, String year);
	 
	 public List<Integer> getListSumTimeUsingSite(String yearAndMonth ,boolean modeSearch ,int memberId);
	 
	 public List<Object[]> getListTopUser(String year);
	 
	 public int countAllByYear(String year);
	 
 }
