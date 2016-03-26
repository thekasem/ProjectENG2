package com.dao.interfaces;

import java.util.List;

import com.entity.bonanza.AUMByCIFMini;


public interface IAUMByCIFDao {
	
	 public String createCriteriaSearch(AUMByCIFMini obj, boolean isOrdering, boolean isAscending, boolean isCount);
	
	 public List<AUMByCIFMini> getListByCriteriaSearch(AUMByCIFMini criteriaSearch, boolean isOrdering, boolean isAscending, int firstResult, int maxResult);
	 
	 public int getCountByCriteriaSearch(AUMByCIFMini criteriaSearch);
	 
	 public AUMByCIFMini getObjectById(int eventId);
	 
	 public void save(AUMByCIFMini entity);
	 
	 public void delete(AUMByCIFMini entity);
	 
	 public List<AUMByCIFMini> getListByDate(String date, String condition);
	 
	 public double sumMarketValue(String yearAndMonth);
	 
	 public List<String> getListYear();

}
