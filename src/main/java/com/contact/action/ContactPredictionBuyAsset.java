package com.contact.action;

import java.io.IOException;
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

	public List<Double> calError(List<Double> listDataCurrentYear,
			List<Double> listDataNextYear) {
		return predictionByAssetController.calError(listDataCurrentYear, listDataNextYear);
	}

	public double getMAD(List<Double> ErrorValues) {
		return predictionByAssetController.getMAD(ErrorValues);
	}

	public double getMSE(List<Double> ErrorValues) {
		return predictionByAssetController.getMSE(ErrorValues);
	}

	public double getMAPE(List<Double> ErorValues,
			List<Double> listDataCurrentYear) {
		return predictionByAssetController.getMAPE(ErorValues, listDataCurrentYear);
	}

	public List<Object[]> getDataPrediction(String date) {
		return predictionByAssetController.getDataPrediction(date);
	}

	public List<Object[]> getDataEachPrediction(String date, String typeId,
			boolean type) {
		return predictionByAssetController.getDataEachPrediction(date, typeId, type);
	}

	public List<Double> getForCastNeuralNetwork(List<Double> dataSumAllYear) {
		return predictionByAssetController.getForCastNeuralNetwork(dataSumAllYear);
	}
	
	
	
}
