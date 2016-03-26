package com.contact.action;

import java.util.List;

import com.controller.interfaces.IPortHoldingBySubAccountController;
import com.entity.bonanza.PortHoldingBySubAccountMini;

public class ContactPortHoldingBySubAccount implements IPortHoldingBySubAccountController {

	IPortHoldingBySubAccountController portHoldingBySubAccountController;
	
	public int getCountByCriteriaSearch(PortHoldingBySubAccountMini criteriaSearch) {
		return portHoldingBySubAccountController.getCountByCriteriaSearch(criteriaSearch);
	}

	public IPortHoldingBySubAccountController getPortHoldingBySubAccountController() {
		return portHoldingBySubAccountController;
	}

	public void setPortHoldingBySubAccountController(
			IPortHoldingBySubAccountController portHoldingBySubAccountController) {
		this.portHoldingBySubAccountController = portHoldingBySubAccountController;
	}

	public List<Double> getSumAumSubAccByYear(String year) {
		return portHoldingBySubAccountController.getSumAumSubAccByYear(year);
	}	
	
}