package com.controller.implement;

import java.util.ArrayList;
import java.util.List;

import com.controller.interfaces.IPortHoldingBySubAccountController;
import com.dao.interfaces.IPortHoldingBySubAccountDao;
import com.entity.bonanza.PortHoldingBySubAccountMini;

public class PortHoldingBySubAccountController implements
		IPortHoldingBySubAccountController {

	IPortHoldingBySubAccountDao portHoldingBySubAccountDao;

	public int getCountByCriteriaSearch(
			PortHoldingBySubAccountMini criteriaSearch) {
		return portHoldingBySubAccountDao
				.getCountByCriteriaSearch(criteriaSearch);
	}

	public IPortHoldingBySubAccountDao getPortHoldingBySubAccountDao() {
		return portHoldingBySubAccountDao;
	}

	public void setPortHoldingBySubAccountDao(
			IPortHoldingBySubAccountDao portHoldingBySubAccountDao) {
		this.portHoldingBySubAccountDao = portHoldingBySubAccountDao;
	}

	private String yearAndMonth(String year, int month) {
		String result = "";
		if (month < 10) {
			result = year + "0" + Integer.toString(month);
		} else {
			result = year + Integer.toString(month);
		}
		return result;
	}

	public List<Double> getSumAumSubAccByYear(String year) {
		List<Double> result = new ArrayList<Double>();
		for (int i = 1; i <= 12; i++) {
			result.add(portHoldingBySubAccountDao.sumMarketValue(yearAndMonth(year, i)));
		}
		return result;
	}

}