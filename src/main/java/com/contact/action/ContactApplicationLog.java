package com.contact.action;

import com.controller.interfaces.IApplicationLogController;
import com.entity.bonanza.ApplicationLogMini;

public class ContactApplicationLog implements IApplicationLogController {
	
	IApplicationLogController applicationLogController;

	public int getCountByCriteriaSearch(ApplicationLogMini criteriaSearch) {
		return applicationLogController.getCountByCriteriaSearch(criteriaSearch);
	}

	public IApplicationLogController getApplicationLogController() {
		return applicationLogController;
	}

	public void setApplicationLogController(
			IApplicationLogController applicationLogController) {
		this.applicationLogController = applicationLogController;
	}
	
}