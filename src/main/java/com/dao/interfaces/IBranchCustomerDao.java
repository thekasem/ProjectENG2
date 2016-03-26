package com.dao.interfaces;

import java.util.List;

import com.entity.bonanza.BranchCustomerMini;

public interface IBranchCustomerDao {
	
	 public String createCriteriaSearch(BranchCustomerMini obj, boolean isOrdering, boolean isAscending, boolean isCount);
		
	 public List<BranchCustomerMini> getListByCriteriaSearch(BranchCustomerMini criteriaSearch, boolean isOrdering, boolean isAscending, int firstResult, int maxResult);
	 
	 public int getCountByCriteriaSearch(BranchCustomerMini criteriaSearch);
	 
	 public BranchCustomerMini getObjectById(int eventId);

	 public void save(BranchCustomerMini entity);
	 
	 public void delete(BranchCustomerMini entity);
	 
	 public int getDataCustomer(String yearAndMonth);
	 
	 public List<String> getListYear();
	 
}
