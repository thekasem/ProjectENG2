package com.contact.action;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.controller.interfaces.IActivityArchiveLogController;
import com.entity.archive.ArchiveActivityLogMini;

public class ContactActivityArchiveLog implements IActivityArchiveLogController {
	IActivityArchiveLogController activityArchiveLogController;
	

	public IActivityArchiveLogController getActivityArchiveLogController() {
		return activityArchiveLogController;
	}

	public void setActivityArchiveLogController(
			IActivityArchiveLogController activityArchiveLogController) {
		this.activityArchiveLogController = activityArchiveLogController;
	}

	public int getCount(ArchiveActivityLogMini criteriaSearch) {
		return activityArchiveLogController.getCount(criteriaSearch);
	}

	public List<ArchiveActivityLogMini> getList(
			ArchiveActivityLogMini criteriaSearch, Boolean isOrdering,
			Boolean isAscending, Integer firstResult, Integer maxResult) {
		return activityArchiveLogController.getList(criteriaSearch, isOrdering, isAscending, firstResult, maxResult);
	}

	public ArchiveActivityLogMini getObjectById(int eventId) {
		return activityArchiveLogController.getObjectById(eventId);
	}

	public void addArchive(String date, String condition)
			throws IllegalAccessException, InvocationTargetException {
		activityArchiveLogController.addArchive(date, condition);
	}

}
