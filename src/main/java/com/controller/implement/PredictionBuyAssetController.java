package com.controller.implement;

import java.util.ArrayList;
import java.util.List;

import com.controller.interfaces.IPredictionByAssetController;
import com.dao.interfaces.IBuyAssetDao;

public class PredictionBuyAssetController implements
		IPredictionByAssetController {

	IBuyAssetDao buyAssetDao;

	public IBuyAssetDao getBuyAssetDao() {
		return buyAssetDao;
	}

	public void setBuyAssetDao(IBuyAssetDao buyAssetDao) {
		this.buyAssetDao = buyAssetDao;
	}

	private Double Sumabs(List<Double> listData) {
		double result = 0.0;
		for (double value : listData) {
			result = result + Math.abs(value);
		}
		return result;
	}

	private String yearAndMonth(String year, int month) {
		String result = "";
		if (month < 10) {
			result = year + "0" + Integer.toString(month);
		} else {
			result = year + Integer.toString(month);
		}
		return result;
	}

	public List<Double> getDataSumAllYear() {
		List<Double> result = new ArrayList<Double>();
		List<String> listAllYear = buyAssetDao.getListYear();

		for (int i = 1; i <= 12; i++) {
			String yearAndMonth = yearAndMonth(
					listAllYear.get(listAllYear.size() - 1), i);
			String yearAndMonth_1 = yearAndMonth(
					listAllYear.get(listAllYear.size() - 2), i);
			String yearAndMonth_2 = yearAndMonth(
					listAllYear.get(listAllYear.size() - 3), i);
			double value = buyAssetDao.getSumCostAsset(yearAndMonth,
					yearAndMonth, "");
			double value_1 = buyAssetDao.getSumCostAsset(yearAndMonth_1,
					yearAndMonth_1, "");
			double value_2 = buyAssetDao.getSumCostAsset(yearAndMonth_2,
					yearAndMonth_2, "");
			double res = (value + value_1 + value_2) / 3;
			result.add(res);
		}

		return result;
	}

	public List<Double> getDataSumAllYearAsset(String AssetId) {
		List<Double> result = new ArrayList<Double>();
		List<String> listAllYear = buyAssetDao.getListYear();

		for (int i = 1; i <= 12; i++) {
			String yearAndMonth = yearAndMonth(
					listAllYear.get(listAllYear.size() - 1), i);
			String yearAndMonth_1 = yearAndMonth(
					listAllYear.get(listAllYear.size() - 2), i);
			String yearAndMonth_2 = yearAndMonth(
					listAllYear.get(listAllYear.size() - 3), i);
			double value = buyAssetDao.getSumCostAsset(yearAndMonth,
					yearAndMonth, AssetId);
			double value_1 = buyAssetDao.getSumCostAsset(yearAndMonth_1,
					yearAndMonth_1, AssetId);
			double value_2 = buyAssetDao.getSumCostAsset(yearAndMonth_2,
					yearAndMonth_2, AssetId);
			double res = (value + value_1 + value_2) / 3;
			result.add(res);
		}

		return result;
	}

	public List<Double> getDataSumAllYearCustomer(String CustomerId) {
		List<Double> result = new ArrayList<Double>();
		List<String> listAllYear = buyAssetDao.getListYear();

		for (int i = 1; i <= 12; i++) {
			String yearAndMonth = yearAndMonth(
					listAllYear.get(listAllYear.size() - 1), i);
			String yearAndMonth_1 = yearAndMonth(
					listAllYear.get(listAllYear.size() - 2), i);
			String yearAndMonth_2 = yearAndMonth(
					listAllYear.get(listAllYear.size() - 3), i);
			double value = buyAssetDao.getSumCostCustomer(yearAndMonth,
					yearAndMonth, CustomerId);
			double value_1 = buyAssetDao.getSumCostCustomer(yearAndMonth_1,
					yearAndMonth_1, CustomerId);
			double value_2 = buyAssetDao.getSumCostCustomer(yearAndMonth_2,
					yearAndMonth_2, CustomerId);
			double res = (value + value_1 + value_2) / 3;
			result.add(res);
		}

		return result;
	}

	public List<Double> getForecastNaive(List<Double> dataSumAllYear) {

		List<Double> result = new ArrayList<Double>();
		result.add(null);
		int loop = 0;
		do {
			result.add(dataSumAllYear.get(loop));
			loop++;
		} while (loop != dataSumAllYear.size() - 1);
		return result;
	}

	public List<Double> getForecastExponential(List<Double> dataSumAllYear,
			float alpha) {

		List<Double> result = new ArrayList<Double>();
		result.add(null);
		result.add(dataSumAllYear.get(0));

		for (int loop = 1; loop < dataSumAllYear.size(); loop++) {
			double available = dataSumAllYear.get(loop);
			double forcastT_1 = result.get(loop);
			double prediction = forcastT_1 + alpha * (available - forcastT_1);
			result.add(prediction);
		}
		return result;
	}

	private double sumList(List<Double> listValue) {
		double result = 0.0;
		for (int i = 0; i <= listValue.size() - 1; i++) {
			result = result + listValue.get(i);
		}
		return result;
	}

	private List<Double> multiTY(List<Double> dataSumAllYear) {
		List<Double> result = new ArrayList<Double>();
		for (int i = 1; i <= (dataSumAllYear.size()); i++) {
			double ty = dataSumAllYear.get(i - 1) * i;
			result.add(ty);
		}
		return result;
	}

	public List<Double> getForecastTrend(List<Double> dataSumAllYear) {

		List<Double> result = new ArrayList<Double>();
		List<Double> ty = multiTY(dataSumAllYear);
		double sumty = sumList(ty);
		double sumy = sumList(dataSumAllYear);
		int n = dataSumAllYear.size();
		double b = ((n * sumty) - (78 * sumy)) / ((n * 650) - (78 * 78));
		double a = (sumy - (b * 78)) / n;

		for (int i = n - 1; i < (n + n - 1); i++) {
			double prediction = a + (b * i);
			result.add(prediction);
		}
		return result;
	}

	public List<Double> calError(List<Double> listDataCurrentYear,
			List<Double> listDataNextYear) {
		List<Double> result = new ArrayList<Double>();

		for (int i = 0; i < listDataCurrentYear.size(); i++) {
			if (listDataNextYear.get(i) == null
					|| listDataCurrentYear.get(i) == null) {
				continue;
			}

			double tempCurrent = listDataCurrentYear.get(i);
			double tempNext = listDataNextYear.get(i);
			result.add(tempCurrent - tempNext);
		}

		return result;
	}

	public double getMAD(List<Double> ErrorValues) {
		double result = 0;
		result = Sumabs(ErrorValues) / ErrorValues.size();
		return result;
	}

	public double getMSE(List<Double> ErrorValues) {
		double result = 0;
		double sumPower = 0;
		for (double value : ErrorValues) {
			sumPower = sumPower + Math.pow(value, 2);
		}
		result = sumPower / (ErrorValues.size() - 1);
		return result;
	}

	public double getMAPE(List<Double> ErorValues,
			List<Double> listDataCurrentYear) {
		double result = 0;
		double sumMAPE = 0;
		for (int i = 0; i < ErorValues.size(); i++) {
			sumMAPE = sumMAPE
					+ (Math.abs(ErorValues.get(i)) / listDataCurrentYear.get(i));
		}
		result = (sumMAPE / ErorValues.size()) * 100;
		return result;
	}

	public List<Object[]> getDataPrediction(String date) {
		return buyAssetDao.getDataPrediction(date);
	}

	public List<Object[]> getDataEachPrediction(String date, String typeId,
			boolean type) {
		return buyAssetDao.getDataEachPrediction(date, typeId, type);
	}
	
	

}
