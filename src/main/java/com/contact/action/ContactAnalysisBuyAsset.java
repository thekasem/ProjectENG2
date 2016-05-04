package com.contact.action;

import java.util.List;

import com.controller.interfaces.IAnalysisBuyAssetController;

public class ContactAnalysisBuyAsset implements IAnalysisBuyAssetController{
	
	IAnalysisBuyAssetController analysisBuyAssetController;
	
	

	public IAnalysisBuyAssetController getAnalysisBuyAssetController() {
		return analysisBuyAssetController;
	}

	public void setAnalysisBuyAssetController(
			IAnalysisBuyAssetController analysisBuyAssetController) {
		this.analysisBuyAssetController = analysisBuyAssetController;
	}

	public List<Double> getValuesPieCustomer() {
		return analysisBuyAssetController.getValuesPieCustomer();
	}

	public List<Double> getValuesPieCustomer(String fromDate, String toDate) {
		return analysisBuyAssetController.getValuesPieCustomer(fromDate, toDate);
	}

	public List<Double> getValuesPieAsset() {
		return analysisBuyAssetController.getValuesPieAsset();
	}

	public List<Double> getValuesPieAsset(String fromDate, String toDate) {
		return analysisBuyAssetController.getValuesPieAsset(fromDate, toDate);
	}


	public List<Double> getValuesPieEachCustomer(String assetId) {
		return analysisBuyAssetController.getValuesPieEachCustomer(assetId);
	}

	public List<Double> getValuesPieEachCustomer(String fromDate,
			String toDate, String assetId) {
		return analysisBuyAssetController.getValuesPieEachCustomer(fromDate, toDate, assetId);
	}

	public List<Double> getValuesPieEachAsset(String customerId) {
		return analysisBuyAssetController.getValuesPieEachAsset(customerId);
	}

	public List<Double> getValuesPieEachAsset(String fromDate, String toDate,
			String customerId) {
		return analysisBuyAssetController.getValuesPieEachAsset(fromDate, toDate, customerId);
	}


	public List<String> getDateList(String selectTime, String fromYear,
			String toYear, String fromMonth, String toMonth, String toYearII) {
		return analysisBuyAssetController.getDateList(selectTime, fromYear, toYear, fromMonth, toMonth, toYearII);
	}

	public List<Object[]> getValueCutomer(List<String> dateList, String selectTime) {
		return analysisBuyAssetController.getValueCutomer(dateList, selectTime);
	}

	public List<Object[]> getValueAsset(List<String> dateList, String selectTime) {
		return analysisBuyAssetController.getValueAsset(dateList, selectTime);
	}

	public List<Object[]> getValueEachCustomer(List<String> dateList,
			String selectTime, String assetId) {
		return analysisBuyAssetController.getValueEachCustomer(dateList, selectTime, assetId);
	}

	public List<Object[]> getValueEachAsset(List<String> dateList,
			String selectTime, String customerId) {
		return analysisBuyAssetController.getValueEachAsset(dateList, selectTime, customerId);
	}



	
}
