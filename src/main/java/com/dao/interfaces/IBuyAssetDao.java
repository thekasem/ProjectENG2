package com.dao.interfaces;

import java.util.List;


public interface IBuyAssetDao {
	
	public List<String> getListYear(); 
	
	public List<Object[]> getSumTypeAssetValues(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear, String id ,char mode);
	
	public List<Object[]> getSumTypeCustomerValues(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear ,String id , char mode);
	
	public List<Object[]> getSumValuesByCustomer(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear, String assetId, String  id , char mode);
	
	public List<Object[]> getSumValuesByAsset(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear, String customerId,String id, char mode);

}
