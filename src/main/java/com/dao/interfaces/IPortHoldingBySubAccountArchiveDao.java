package com.dao.interfaces;

import java.util.List;

import com.entity.archive.ArchivePortHoldingBySubAccountMini;


public interface IPortHoldingBySubAccountArchiveDao {
	
	 public String createCriteriaSearch(ArchivePortHoldingBySubAccountMini obj, boolean isOrdering, boolean isAscending, boolean isCount);
	
	 public List<ArchivePortHoldingBySubAccountMini> getListByCriteriaSearch(ArchivePortHoldingBySubAccountMini criteriaSearch, boolean isOrdering, boolean isAscending, int firstResult, int maxResult);
	 
	 public int getCountByCriteriaSearch(ArchivePortHoldingBySubAccountMini criteriaSearch);
	 
	 public ArchivePortHoldingBySubAccountMini getObjectById(int eventId);
	 
	 public void save(ArchivePortHoldingBySubAccountMini entity);
	 
	 public void delete(ArchivePortHoldingBySubAccountMini entity);

}
