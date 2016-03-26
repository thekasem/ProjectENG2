package com.controller.implement;

import java.util.ArrayList;
import java.util.List;

import com.controller.interfaces.IAUMByCIFController;
import com.dao.interfaces.IAUMByCIFDao;
import com.entity.bonanza.AUMByCIFMini;

public class AUMByCIFController implements IAUMByCIFController {
	
	IAUMByCIFDao aumByCIFDao;

	public int getCountByCriteriaSearch(AUMByCIFMini criteriaSearch) {
		return aumByCIFDao.getCountByCriteriaSearch(criteriaSearch);
	}

	public IAUMByCIFDao getAumByCIFDao() {
		return aumByCIFDao;
	}

	public void setAumByCIFDao(IAUMByCIFDao aumByCIFDao) {
		this.aumByCIFDao = aumByCIFDao;
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
	public List<Double> getSumAumCIFByYear(String year) {
		List<Double> result = new ArrayList<Double>();
		for (int i = 1; i <= 12; i++) {
			result.add(aumByCIFDao.sumMarketValue(yearAndMonth(year, i)));
		}
		return result;
	}

	public List<String> getListYear() {
		return aumByCIFDao.getListYear();
	}
	
	
}