package com.dao.interfaces;

import java.util.List;

import com.entity.bonanza.PortHoldingBySubAccountMini;

public interface IPortHoldingBySubAccountDao {
	
	 public String createCriteriaSearch(PortHoldingBySubAccountMini obj, boolean isOrdering, boolean isAscending, boolean isCount);
	
	 public List<PortHoldingBySubAccountMini> getListByCriteriaSearch(PortHoldingBySubAccountMini criteriaSearch, boolean isOrdering, boolean isAscending, int firstResult, int maxResult);
	 
	 public int getCountByCriteriaSearch(PortHoldingBySubAccountMini criteriaSearch);
	 
	 public PortHoldingBySubAccountMini getObjectById(int eventId);
	 
	 public void save(PortHoldingBySubAccountMini entity);
	 
	 public void delete(PortHoldingBySubAccountMini entity);
	 
	 public List<PortHoldingBySubAccountMini> getListByDate(String date, String condition);
	 
	 public double sumMarketValue(String yearAndMonth); 

}
