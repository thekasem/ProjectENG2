package com.contact.action;

import java.util.List;

import com.controller.interfaces.IAUMByBranchArchiveController;
import com.entity.archive.ArchiveAUMByBranchMini;

public class ContactAUMByBranchArchive  implements IAUMByBranchArchiveController{
	
	IAUMByBranchArchiveController aumByBranchArchiveController;

	public IAUMByBranchArchiveController getAumByBranchArchiveController() {
		return aumByBranchArchiveController;
	}

	public void setAumByBranchArchiveController(
			IAUMByBranchArchiveController aumByBranchArchiveController) {
		this.aumByBranchArchiveController = aumByBranchArchiveController;
	}

	public int getCount(ArchiveAUMByBranchMini criteriaSearch) {
		return aumByBranchArchiveController.getCount(criteriaSearch);
	}

	public List<ArchiveAUMByBranchMini> getList(
			ArchiveAUMByBranchMini criteriaSearch, Boolean isOrdering,
			Boolean isAscending, Integer firstResult, Integer maxResult) {
		return aumByBranchArchiveController.getList(criteriaSearch, isOrdering, isAscending, firstResult, maxResult);
	}

	public ArchiveAUMByBranchMini getObjectById(int eventId) {
		return aumByBranchArchiveController.getObjectById(eventId);
	}

	public void addArchive(String date, String condition) {
		aumByBranchArchiveController.addArchive(date, condition);
	}

}
