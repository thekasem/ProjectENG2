package com.dao.interfaces;

import java.util.List;

import com.entity.archive.ArchiveAUMByCIFMini;


public interface IAUMByCIFArchiveDao {
	
	public String createCriteriaSearch(ArchiveAUMByCIFMini obj, boolean isOrdering, boolean isAscending, boolean isCount);
	
	 public List<ArchiveAUMByCIFMini> getListByCriteriaSearch(ArchiveAUMByCIFMini criteriaSearch, boolean isOrdering, boolean isAscending, int firstResult, int maxResult);
	 
	 public int getCountByCriteriaSearch(ArchiveAUMByCIFMini criteriaSearch);
	 
	 public ArchiveAUMByCIFMini getObjectById(int eventId);
	 
     public void save(ArchiveAUMByCIFMini entity);
	 
	 public void delete(ArchiveAUMByCIFMini entity);

}
