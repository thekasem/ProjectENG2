package com.contact.action;

import java.util.List;

import com.controller.interfaces.IPortHoldingBySubAccountArchiveCotroller;
import com.entity.archive.ArchivePortHoldingBySubAccountMini;

public class ContactPortHoldingBySubAccountArchive implements IPortHoldingBySubAccountArchiveCotroller {

	IPortHoldingBySubAccountArchiveCotroller portHoldingBySubAccountArchiveCotroller;
	
	public IPortHoldingBySubAccountArchiveCotroller getPortHoldingBySubAccountArchiveCotroller() {
		return portHoldingBySubAccountArchiveCotroller;
	}

	public void setPortHoldingBySubAccountArchiveCotroller(
			IPortHoldingBySubAccountArchiveCotroller portHoldingBySubAccountArchiveCotroller) {
		this.portHoldingBySubAccountArchiveCotroller = portHoldingBySubAccountArchiveCotroller;
	}

	public int getCount(ArchivePortHoldingBySubAccountMini criteriaSearch) {
		return portHoldingBySubAccountArchiveCotroller.getCount(criteriaSearch);
	}

	public List<ArchivePortHoldingBySubAccountMini> getList(
			ArchivePortHoldingBySubAccountMini criteriaSearch,
			Boolean isOrdering, Boolean isAscending, Integer firstResult,
			Integer maxResult) {
		return portHoldingBySubAccountArchiveCotroller.getList(criteriaSearch, isOrdering, isAscending, firstResult, maxResult);
	}

	public ArchivePortHoldingBySubAccountMini getObjectById(int eventId) {
		return portHoldingBySubAccountArchiveCotroller.getObjectById(eventId);
	}

	public void addArchive(String date, String condition) {
		portHoldingBySubAccountArchiveCotroller.addArchive(date, condition);
		
	}

}
