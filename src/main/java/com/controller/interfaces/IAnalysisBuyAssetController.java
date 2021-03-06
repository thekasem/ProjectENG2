package com.controller.interfaces;

import java.util.List;

public interface IAnalysisBuyAssetController {
	
	public List<Double> getValuesPieCustomer();
	
	public List<Double> getValuesPieCustomer(String fromDate, String toDate);
	
	public List<Double> getValuesPieAsset();
	
	public List<Double> getValuesPieAsset(String fromDate, String toDate);
	
	
	public List<String> getDateList(String selectTime, String fromYear, String toYear, String fromMonth, String toMonth, String toYearII);
	
	
	public List<Object[]> getValueCutomer(List<String> dateList, String selectTime);
	
	public List<Object[]> getValueAsset(List<String> dateList, String selectTime);
	
	
	public List<Double> getValuesPieEachCustomer(String assetId);
	
	public List<Double> getValuesPieEachCustomer(String fromDate, String toDate, String assetId);
	
	public List<Double> getValuesPieEachAsset(String customerId);
	
	public List<Double> getValuesPieEachAsset(String fromDate, String toDate, String customerId);
	
	
	public List<Object[]> getValueEachCustomer(List<String> dateList, String selectTime,String assetId);
	
	public List<Object[]> getValueEachAsset(List<String> dateList, String selectTime, String customerId);
	

}