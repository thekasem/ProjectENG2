package com.dao.interfaces;

import java.util.List;

import com.entity.bonanza.AUMByBranchMini;


public interface IAUMByBranchDao {
	
	public String createCriteriaSearch(AUMByBranchMini obj, boolean isOrdering, boolean isAscending, boolean isCount);
	
	 public List<AUMByBranchMini> getListByCriteriaSearch(AUMByBranchMini criteriaSearch, boolean isOrdering, boolean isAscending, int firstResult, int maxResult);
	 
	 public int getCountByCriteriaSearch(AUMByBranchMini criteriaSearch);
	 
	 public AUMByBranchMini getObjectById(int eventId);
	 
	 public void save(AUMByBranchMini entity);
	 
	 public void delete(AUMByBranchMini entity);
	 
	 public List<AUMByBranchMini> getListByDate(String date, String condition);
	 
	 public double sumMarketValue(String yearAndMonth);

}
