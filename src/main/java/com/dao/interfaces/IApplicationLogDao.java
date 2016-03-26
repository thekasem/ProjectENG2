package com.dao.interfaces;

import java.util.List;

import com.entity.bonanza.ApplicationLogMini;


public interface IApplicationLogDao {
	
	public String createCriteriaSearch(ApplicationLogMini obj, boolean isOrdering, boolean isAscending, boolean isCount);
	
	 public List<ApplicationLogMini> getListByCriteriaSearch(ApplicationLogMini criteriaSearch, boolean isOrdering, boolean isAscending, int firstResult, int maxResult);
	 
	 public int getCountByCriteriaSearch(ApplicationLogMini criteriaSearch);
	 
	 public ApplicationLogMini getObjectById(int eventId);
	 
    public void save(ApplicationLogMini entity);
	 
	 public void delete(ApplicationLogMini entity);
	 
	 public List<ApplicationLogMini> getListByDate(String date, String condition);

}
