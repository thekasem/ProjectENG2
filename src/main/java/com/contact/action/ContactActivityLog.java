package com.contact.action;

import java.util.List;

import com.controller.interfaces.IActivityLogController;
import com.entity.bonanza.ActivityLogMini;

public class ContactActivityLog implements IActivityLogController {
	
	IActivityLogController activityLogController;
	
	

	public IActivityLogController getActivityLogController() {
		return activityLogController;
	}

	public void setActivityLogController(
			IActivityLogController activityLogController) {
		this.activityLogController = activityLogController;
	}

	public List<String> getNameBrowsers(String name,String year) {
		return activityLogController.getNameBrowsers(name, year);
	}

	public List<Float> getDataBrowsers(List<String> name, Boolean searchBy, String year) {
		return activityLogController.getDataBrowsers(name, searchBy, year);
	}

	public List<Integer> getDataAction(String name, String year) {
		return activityLogController.getDataAction(name, year);
	}

	public List<String> getNameAction(String year) {
		return activityLogController.getNameAction(year);
	}

	public int getCountByCriteriaSearch(ActivityLogMini criteriaSearch) {
		return activityLogController.getCountByCriteriaSearch(criteriaSearch);
	}

	public List<Float> getListAverageTimeOnSite(String year) {
		return activityLogController.getListAverageTimeOnSite(year);
	}

	public List<String> nameTopUser(String year) {
		return activityLogController.nameTopUser(year);
	}

	public List<Float> getDataAverageTimeByUser(String year, int numberTop) {
		return activityLogController.getDataAverageTimeByUser(year, numberTop);
	}
	
}
