package com.contact.action;

import java.util.List;

import com.controller.interfaces.IPredictionByAssetController;

public class ContactPredictionBuyAsset implements IPredictionByAssetController {

	IPredictionByAssetController predictionByAssetController;

	public IPredictionByAssetController getPredictionByAssetController() {
		return predictionByAssetController;
	}

	public void setPredictionByAssetController(
			IPredictionByAssetController predictionByAssetController) {
		this.predictionByAssetController = predictionByAssetController;
	}

	public List<Double> getDataSumAllYear() {
		return predictionByAssetController.getDataSumAllYear();
	}

	public List<Double> getDataSumAllYearAsset(String AssetId) {
		return predictionByAssetController.getDataSumAllYearAsset(AssetId);
	}

	public List<Double> getDataSumAllYearCustomer(String CustomerId) {
		return predictionByAssetController.getDataSumAllYearCustomer(CustomerId);
	}

	public List<Double> getForecastNaive(List<Double> dataSumAllYear) {
		return predictionByAssetController.getForecastNaive(dataSumAllYear);
	}

	public List<Double> getForecastExponential(List<Double> dataSumAllYear,
			float alpha) {
		return predictionByAssetController.getForecastExponential(dataSumAllYear, alpha);
	}

	public List<Double> getForecastTrend(List<Double> dataSumAllYear) {
		return predictionByAssetController.getForecastTrend(dataSumAllYear);
	}
	
	
	
}
