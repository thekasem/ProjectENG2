package com.dao.interfaces;

import java.util.List;

import com.entity.archive.ArchiveAUMByBranchMini;


public interface IAUMByBranchArchiveDao {
	
	 public String createCriteriaSearch(ArchiveAUMByBranchMini obj, boolean isOrdering, boolean isAscending, boolean isCount);
		
	 public List<ArchiveAUMByBranchMini> getListByCriteriaSearch(ArchiveAUMByBranchMini criteriaSearch, boolean isOrdering, boolean isAscending, int firstResult, int maxResult);
	 
	 public int getCountByCriteriaSearch(ArchiveAUMByBranchMini criteriaSearch);
	 
	 public ArchiveAUMByBranchMini getObjectById(int eventId);
	 
	 public void save(ArchiveAUMByBranchMini entity);
	 
	 public void delete(ArchiveAUMByBranchMini entity);

}
