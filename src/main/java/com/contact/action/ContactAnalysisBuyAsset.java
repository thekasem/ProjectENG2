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

	public List<Double> getValuesCustomer(String id, char mode) {
		return analysisBuyAssetController.getValuesCustomer(id,mode);
	}

	public List<Double> getvaluesCustomer(String fromDate, String toDate, String id, char mode) {
		return analysisBuyAssetController.getvaluesCustomer(fromDate, toDate, id, mode);
	}

	public List<Double> getvaluesAsset(String id, char mode) {
		return analysisBuyAssetController.getvaluesAsset(id, mode);
	}

	public List<Double> getValuesAsset(String fromDate, String toDate, String id, char mode) {
		return analysisBuyAssetController.getValuesAsset(fromDate, toDate, id, mode);
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

	public List<Double> getValuesEachCustomer(String assetId, String id, char mode) {
		return analysisBuyAssetController.getValuesEachCustomer(assetId, id, mode);
	}

	public List<Double> getvaluesEachCustomer(String fromDate, String toDate,
			String assetId, String id, char mode) {
		return analysisBuyAssetController.getvaluesEachCustomer(fromDate, toDate, assetId, id, mode);
	}

	public List<Double> getvaluesEachAsset(String customerId, String id, char mode) {
		return analysisBuyAssetController.getvaluesEachAsset(customerId, id, mode);
	}

	public List<Double> getValuesEachAsset(String fromDate, String toDate,
			String customerId, String id, char mode) {
		return analysisBuyAssetController.getValuesEachAsset(fromDate, toDate, customerId, id, mode);
	}

	
}
