package com.contact.action;

import java.util.List;

import com.controller.interfaces.IAUMByCIFArchiveController;
import com.entity.archive.ArchiveAUMByCIFMini;

public class ContactAUMByCIFArchive implements IAUMByCIFArchiveController{
	
	IAUMByCIFArchiveController aumByCIFArchiveController;
	
	public IAUMByCIFArchiveController getAumByCIFArchiveController() {
		return aumByCIFArchiveController;
	}

	public void setAumByCIFArchiveController(
			IAUMByCIFArchiveController aumByCIFArchiveController) {
		this.aumByCIFArchiveController = aumByCIFArchiveController;
	}

	public int getCount(ArchiveAUMByCIFMini criteriaSearch) {
		return aumByCIFArchiveController.getCount(criteriaSearch);
	}

	public List<ArchiveAUMByCIFMini> getList(
			ArchiveAUMByCIFMini criteriaSearch, Boolean isOrdering,
			Boolean isAscending, Integer firstResult, Integer maxResult) {
		return aumByCIFArchiveController.getList(criteriaSearch, isOrdering, isAscending, firstResult, maxResult);
	}

	public ArchiveAUMByCIFMini getObjectById(int eventId) {
		return aumByCIFArchiveController.getObjectById(eventId);
	}

	public void addArchive(String date, String condition) {
		aumByCIFArchiveController.addArchive(date, condition);
	}

}
