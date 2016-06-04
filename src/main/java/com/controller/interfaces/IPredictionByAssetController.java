package com.controller.interfaces;

import java.util.List;

public interface IPredictionByAssetController {
	
	public List<Double> getDataSumAllYear();
	
	public List<Double> getDataSumAllYearAsset(String AssetId);
	
	public List<Double> getDataSumAllYearCustomer(String CustomerId);
	
	public List<Double> getForecastNaive(List<Double> dataSumAllYear);
	
	public List<Double> getForecastExponential(List<Double> dataSumAllYear ,float alpha);
	
	public List<Double> getForecastTrend(List<Double> dataSumAllYear);
	
	public List<Double> calError(List<Double> listDataCurrentYear,	List<Double> listDataNextYear);
	
	public double getMAD(List<Double> ErrorValues);
	
	public double getMSE(List<Double> ErrorValues);
	
	public double getMAPE(List<Double> ErorValues, List<Double> listDataCurrentYear);
	
	public List<Object[]> getDataPrediction(String date);
	
	public List<Object[]> getDataEachPrediction(String date, String typeId, boolean type);

	public List<Double>  getForCastNeuralNetwork(List<Double> dataSumAllYear) ;
}
