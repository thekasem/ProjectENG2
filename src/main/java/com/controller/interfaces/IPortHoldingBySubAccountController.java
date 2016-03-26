package com.controller.interfaces;

import java.util.List;

import com.entity.bonanza.PortHoldingBySubAccountMini;

public interface IPortHoldingBySubAccountController {
	
	public int getCountByCriteriaSearch(PortHoldingBySubAccountMini criteriaSearch);
	
	public List<Double> getSumAumSubAccByYear(String year);
}