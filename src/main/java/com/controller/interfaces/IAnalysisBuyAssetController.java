package com.controller.interfaces;

import java.util.List;

public interface IAnalysisBuyAssetController {
	
	public List<Double> getValuesPieCustomer();
	
	public List<Double> getValuesPieCustomer(String fromDate, String toDate);
	
	public List<Double> getValuesPieAsset();
	
	public List<Double> getValuesPieAsset(String fromDate, String toDate);
	
	public List<Double> getValuesCustomer();
	
	public List<Double> getvaluesCustomer(String fromDate, String toDate);
	
	public List<Double> getvaluesAsset();
	
	public List<Double> getValuesAsset(String fromDate, String toDate);
	
	public List<Double> getValuesPieEachCustomer(String assetId);
	
	public List<Double> getValuesPieEachCustomer(String fromDate, String toDate, String assetId);
	
	public List<Double> getValuesPieEachAsset(String customerId);
	
	public List<Double> getValuesPieEachAsset(String fromDate, String toDate, String customerId);
	
	public List<Double> getValuesEachCustomer(String assetId);
	
	public List<Double> getvaluesEachCustomer(String fromDate, String toDate, String assetId);
	
	public List<Double> getvaluesEachAsset(String customerId);
	
	public List<Double> getValuesEachAsset(String fromDate, String toDate, String customerId);

}