package com.dao.interfaces;

import java.util.List;


public interface IBuyAssetDao {
	
	public List<String> getListYear(); 
	
	public List<Object[]> getSumTypeAssetValues(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear, char mode);
	
	public List<Object[]> getSumTypeCustomerValues(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear, char mode);
	
	public List<Object[]> getSumValuesByCustomer(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear, String assetId, char mode);
	
	public List<Object[]> getSumValuesByAsset(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear, String customerId, char mode);
	
	public double getSumCostAsset(String yearAndMonthFrom, String yearAndMonthTo, String typeAssetId);
	
	public double getSumCostCustomer(String yearAndMonthFrom, String yearAndMonthTo, String typeCustomerId);
	
	public List<Object[]> getDataPrediction(String date);
	
	public List<Object[]> getDataEachPrediction(String date, String typeId, boolean type);

}
