package com.controller.interfaces;

import java.util.List;

import com.entity.archive.ArchiveAUMByCIFMini;


public interface IAUMByCIFArchiveController {
	
	public int getCount(ArchiveAUMByCIFMini criteriaSearch);
	
	public List<ArchiveAUMByCIFMini> getList(ArchiveAUMByCIFMini criteriaSearch, Boolean isOrdering, Boolean isAscending, Integer firstResult, Integer maxResult);
	
	public ArchiveAUMByCIFMini getObjectById(int eventId);
	
	public void addArchive(String date, String condition);
}
