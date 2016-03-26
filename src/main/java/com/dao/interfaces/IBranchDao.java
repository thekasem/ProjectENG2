package com.dao.interfaces;

import java.util.List;

import com.entity.bonanza.BranchMini;


public interface IBranchDao {
	 public String createCriteriaSearch(BranchMini obj, boolean isOrdering, boolean isAscending, boolean isCount);
		
	 public List<BranchMini> getListByCriteriaSearch(BranchMini criteriaSearch, boolean isOrdering, boolean isAscending, int firstResult, int maxResult);
	 
	 public int getCountByCriteriaSearch(BranchMini criteriaSearch);
	 
	 public BranchMini getObjectById(int eventId);

	 public void save(BranchMini entity);
	 
	 public void delete(BranchMini entity);

}
