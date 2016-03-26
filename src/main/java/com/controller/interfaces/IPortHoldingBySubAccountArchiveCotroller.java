package com.controller.interfaces;

import java.util.List;

import com.entity.archive.ArchivePortHoldingBySubAccountMini;

public interface IPortHoldingBySubAccountArchiveCotroller {
	
	public int getCount(ArchivePortHoldingBySubAccountMini criteriaSearch);
	
	public List<ArchivePortHoldingBySubAccountMini> getList(ArchivePortHoldingBySubAccountMini criteriaSearch, Boolean isOrdering, Boolean isAscending, Integer firstResult, Integer maxResult);
	
	public ArchivePortHoldingBySubAccountMini getObjectById(int eventId);
	
	public void addArchive(String date, String condition);
}
