package com.dao.interfaces;

import java.util.List;


public interface IBuyAssetDao {
	
	public List<String> getListYear(); 
	
	public List<Object[]> getSumTypeAssetValues(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear);
	
	public List<Object[]> getSumTypeCustomerValues(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear);

}
