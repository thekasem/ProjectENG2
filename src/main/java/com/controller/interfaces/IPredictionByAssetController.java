package com.controller.interfaces;

import java.util.List;

public interface IPredictionByAssetController {
	
	public List<Double> getDataSumAllYear();
	
	public List<Double> getDataSumAllYearAsset(String AssetId);
	
	public List<Double> getDataSumAllYearCustomer(String CustomerId);
	
	public List<Double> getForecastNaive(List<Double> dataSumAllYear);
	
	public List<Double> getForecastExponential(List<Double> dataSumAllYear ,float alpha);
	
	public List<Double> getForecastTrend(List<Double> dataSumAllYear);

}
