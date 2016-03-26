package com.controller.implement;

import java.util.ArrayList;
import java.util.List;

import com.controller.interfaces.IAUMByBranchController;
import com.dao.interfaces.IAUMByBranchDao;
import com.entity.bonanza.AUMByBranchMini;

public class AUMByBranchController implements IAUMByBranchController {

	IAUMByBranchDao aumByBranchDao;

	public int getCountByCriteriaSearch(AUMByBranchMini criteriaSearch) {
		return aumByBranchDao.getCountByCriteriaSearch(criteriaSearch);
	}

	public IAUMByBranchDao getAumByBranchDao() {
		return aumByBranchDao;
	}

	public void setAumByBranchDao(IAUMByBranchDao aumByBranchDao) {
		this.aumByBranchDao = aumByBranchDao;
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

	public List<Double> getSumAumBranchByYear(String year) {
		List<Double> result = new ArrayList<Double>();
		for (int i = 1; i <= 12; i++) {
			result.add(aumByBranchDao.sumMarketValue(yearAndMonth(year, i)));
		}
		return result;
	}

}