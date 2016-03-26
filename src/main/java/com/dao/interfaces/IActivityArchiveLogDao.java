package com.dao.interfaces;

import java.util.List;

import com.entity.archive.ArchiveActivityLogMini;

public interface IActivityArchiveLogDao {
	
	 public String createCriteriaSearch(ArchiveActivityLogMini obj, boolean isOrdering, boolean isAscending, boolean isCount);
	
	 public List<ArchiveActivityLogMini> getListByCriteriaSearch(ArchiveActivityLogMini criteriaSearch, boolean isOrdering, boolean isAscending, int firstResult, int maxResult);
	 
	 public int getCountByCriteriaSearch(ArchiveActivityLogMini criteriaSearch);
	 
	 public ArchiveActivityLogMini getObjectById(int eventId);

	 public void save(ArchiveActivityLogMini entity);
	 
	 public void delete(ArchiveActivityLogMini entity);
}
