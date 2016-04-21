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
	
//	public List<Double> getValuesColumnCustomer();
//	
//	public List<Double> getValuesColumnCustomer(String fromDate, String toDate);
//	
//	public List<Double> getValuesColumnAsset();
//	
//	public List<Double> getValuesColumnAsset(String fromDate, String toDate);
//	
//	public List<Double> getValuesScatterCustomer();
//	
//	public List<Double> getValuesScatterCustomer(String fromDate, String toDate);
//	
//	public List<Double> getValuesScatterAsset();
//	
//	public List<Double> getValuesScatterAsset(String fromDate, String toDate);
	

}