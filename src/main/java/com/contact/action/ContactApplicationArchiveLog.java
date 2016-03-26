package com.contact.action;

import java.util.List;

import com.controller.interfaces.IApplicationArchiveLogController;
import com.entity.archive.ArchiveApplicationLogMini;

public class ContactApplicationArchiveLog implements IApplicationArchiveLogController {
    IApplicationArchiveLogController applicationArchiveLogController;
    
    
	public IApplicationArchiveLogController getApplicationArchiveLogController() {
		return applicationArchiveLogController;
	}

	public void setApplicationArchiveLogController(
			IApplicationArchiveLogController applicationArchiveLogController) {
		this.applicationArchiveLogController = applicationArchiveLogController;
	}

	public int getCount(ArchiveApplicationLogMini criteriaSearch) {
		return applicationArchiveLogController.getCount(criteriaSearch);
	}

	public List<ArchiveApplicationLogMini> getList(
			ArchiveApplicationLogMini criteriaSearch, Boolean isOrdering,
			Boolean isAscending, Integer firstResult, Integer maxResult) {
		return applicationArchiveLogController.getList(criteriaSearch, isOrdering, isAscending, firstResult, maxResult);
	}

	public ArchiveApplicationLogMini getObjectById(int eventId) {
		return applicationArchiveLogController.getObjectById(eventId);
	}

	public void addArchive(String date, String condition) {
		applicationArchiveLogController.addArchive(date, condition);
	}

}
