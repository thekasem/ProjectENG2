package com.contact.action;

import java.util.List;

import com.controller.interfaces.IAUMByBranchController;
import com.entity.bonanza.AUMByBranchMini;

public class ContactAUMByBranch  implements IAUMByBranchController{
	
	IAUMByBranchController aumByBranchController;

	public int getCountByCriteriaSearch(AUMByBranchMini criteriaSearch) {
		return aumByBranchController.getCountByCriteriaSearch(criteriaSearch);
	}

	public IAUMByBranchController getAumByBranchController() {
		return aumByBranchController;
	}

	public void setAumByBranchController(
			IAUMByBranchController aumByBranchController) {
		this.aumByBranchController = aumByBranchController;
	}

	public List<Double> getSumAumBranchByYear(String year) {
		return aumByBranchController.getSumAumBranchByYear(year);
	}
	
}