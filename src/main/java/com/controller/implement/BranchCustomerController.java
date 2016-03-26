package com.controller.implement;

import java.util.ArrayList;
import java.util.List;

import com.controller.interfaces.IBranchCustomerController;
import com.dao.interfaces.IBranchCustomerDao;

public class BranchCustomerController implements IBranchCustomerController {

	IBranchCustomerDao branchCustomerDao;

	public IBranchCustomerDao getBranchCustomerDao() {
		return branchCustomerDao;
	}

	public void setBranchCustomerDao(IBranchCustomerDao branchCustomerDao) {
		this.branchCustomerDao = branchCustomerDao;
	}

	public List<Integer> getDataCustomer(String year) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			result.add(branchCustomerDao.getDataCustomer(yearAndMonth(year,i)));
		}
		return result;
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

	public List<String> getListYear() {
		return branchCustomerDao.getListYear();
	}
	
	
}
