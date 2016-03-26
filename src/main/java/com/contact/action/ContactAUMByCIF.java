package com.contact.action;

import java.util.List;

import com.controller.interfaces.IAUMByCIFController;
import com.entity.bonanza.AUMByCIFMini;

public class ContactAUMByCIF implements IAUMByCIFController{
	
	IAUMByCIFController aumByCIFController;
	
	public int getCountByCriteriaSearch(AUMByCIFMini criteriaSearch) {
		return aumByCIFController.getCountByCriteriaSearch(criteriaSearch);
	}

	public IAUMByCIFController getAumByCIFController() {
		return aumByCIFController;
	}

	public void setAumByCIFController(IAUMByCIFController aumByCIFController) {
		this.aumByCIFController = aumByCIFController;
	}

	public List<Double> getSumAumCIFByYear(String year) {
		return aumByCIFController.getSumAumCIFByYear(year);
	}

	public List<String> getListYear() {
		return aumByCIFController.getListYear();
	}
	
}