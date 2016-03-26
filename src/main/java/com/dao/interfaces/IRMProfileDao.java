package com.dao.interfaces;

import java.util.List;

import com.entity.bonanza.RMProfileMini;


public interface IRMProfileDao {
	
	 public String createCriteriaSearch(RMProfileMini obj, boolean isOrdering, boolean isAscending, boolean isCount);
		
	 public List<RMProfileMini> getListByCriteriaSearch(RMProfileMini criteriaSearch, boolean isOrdering, boolean isAscending, int firstResult, int maxResult);
	 
	 public int getCountByCriteriaSearch(RMProfileMini criteriaSearch);
	 
	 public RMProfileMini getObjectById(int eventId);

	 public void save(RMProfileMini entity);
	 
	 public void delete(RMProfileMini entity);

}
