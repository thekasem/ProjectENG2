package com.controller.interfaces;

import java.util.List;

import com.entity.archive.ArchiveApplicationLogMini;


public interface IApplicationArchiveLogController {
	
	public int getCount(ArchiveApplicationLogMini criteriaSearch);
	
	public List<ArchiveApplicationLogMini> getList(ArchiveApplicationLogMini criteriaSearch, Boolean isOrdering, Boolean isAscending, Integer firstResult, Integer maxResult);
	
	public ArchiveApplicationLogMini getObjectById(int eventId);
	
	public void addArchive(String date,String condition);

}
