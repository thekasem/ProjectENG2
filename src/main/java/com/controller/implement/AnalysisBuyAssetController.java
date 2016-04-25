package com.controller.implement;

import java.util.ArrayList;
import java.util.List;

import com.controller.interfaces.IAnalysisBuyAssetController;
import com.dao.interfaces.IBuyAssetDao;

public class AnalysisBuyAssetController implements IAnalysisBuyAssetController {

	private IBuyAssetDao buyAssetDao;

	public IBuyAssetDao getBuyAssetDao() {
		return buyAssetDao;
	}

	public void setBuyAssetDao(IBuyAssetDao buyAssetDao) {
		this.buyAssetDao = buyAssetDao;
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

	private double sum(List<Object[]> values) {
		double sum = 0;
		for (Object[] value : values) {
			if (value[0] != null) {
				sum = sum + Double.parseDouble(value[0] + "");
			}
		}
		return sum;
	}

	private List<Double> convertToListDouble(List<Object[]> values) {
		List<Double> result = new ArrayList<Double>();
		for (Object[] value : values) {
			double precent = 0;
			if (value[0] != null) {
				precent = Double.parseDouble(value[0] + "");
			}
			result.add(precent);
		}
		return result;

	}

	private List<Double> percentOfValues(List<Object[]> values) {
		List<Double> results = new ArrayList<Double>();
		double sum = sum(values);
		for (Object[] value : values) {
			double result = 0;
			if (value[0] != null) {
				result = (Double.parseDouble(value[0] + "") / sum) * 100;
			}
			results.add(result);
		}
		return results;
	}

	public List<Double> getValuesPieCustomer() {
		List<Object[]> values = buyAssetDao.getSumTypeCustomerValues("", "",
				true, "", '3');
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieCustomer(String fromDate, String toDate) {
		List<Object[]> values = buyAssetDao.getSumTypeCustomerValues(fromDate,
				toDate, false, "", '3');
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieAsset() {
		List<Object[]> values = buyAssetDao.getSumTypeAssetValues("", "", true,
				"", '3');
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieAsset(String fromDate, String toDate) {
		List<Object[]> values = buyAssetDao.getSumTypeAssetValues(fromDate,
				toDate, false, "", (char) 3);
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesCustomer(String id, char mode) {
		List<Object[]> values = buyAssetDao.getSumTypeCustomerValues("", "",
				true, id, mode);
		List<Double> result = convertToListDouble(values);
		return result;
	}

	public List<Double> getvaluesCustomer(String fromDate, String toDate,
			String id, char mode) {
		List<Object[]> values = buyAssetDao.getSumTypeCustomerValues(fromDate,
				toDate, false, id, mode);
		List<Double> result = convertToListDouble(values);
		return result;
	}

	public List<Double> getvaluesAsset(String id, char mode) {
		List<Object[]> values = buyAssetDao.getSumTypeAssetValues("", "", true,
				id, mode);
		List<Double> result = convertToListDouble(values);
		return result;
	}

	public List<Double> getValuesAsset(String fromDate, String toDate,
			String id, char mode) {
		List<Object[]> values = buyAssetDao.getSumTypeAssetValues(fromDate,
				toDate, false, id, mode);
		List<Double> result = convertToListDouble(values);
		return result;
	}

	public List<Double> getValuesPieEachCustomer(String assetId) {
		List<Object[]> values = buyAssetDao.getSumValuesByCustomer("", "",
				true, assetId, "", '3');
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieEachCustomer(String fromDate,
			String toDate, String assetId) {
		List<Object[]> values = buyAssetDao.getSumValuesByCustomer(fromDate,
				toDate, false, assetId, "", '3');
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieEachAsset(String customerId) {
		List<Object[]> values = buyAssetDao.getSumValuesByAsset("", "", true,
				customerId, "", '3');
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieEachAsset(String fromDate, String toDate,
			String customerId) {
		List<Object[]> values = buyAssetDao.getSumValuesByAsset(fromDate,
				toDate, false, customerId, "", '3');
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesEachCustomer(String assetId, String id,
			char mode) {
		List<Object[]> values = buyAssetDao.getSumValuesByCustomer("", "",
				true, assetId, id, mode);
		List<Double> result = convertToListDouble(values);
		return result;
	}

	public List<Double> getvaluesEachCustomer(String fromDate, String toDate,
			String assetId, String id, char mode) {
		List<Object[]> values = buyAssetDao.getSumValuesByCustomer(fromDate,
				toDate, false, assetId, id, mode);
		List<Double> result = convertToListDouble(values);
		return result;
	}

	public List<Double> getvaluesEachAsset(String customerId, String id,
			char mode) {
		List<Object[]> values = buyAssetDao.getSumValuesByAsset("", "", false,
				customerId, id, mode);
		List<Double> result = convertToListDouble(values);
		return result;
	}

	public List<Double> getValuesEachAsset(String fromDate, String toDate,
			String customerId, String id, char mode) {
		List<Object[]> values = buyAssetDao.getSumValuesByAsset(fromDate,
				toDate, false, customerId, id, mode);
		List<Double> result = convertToListDouble(values);
		return result;
	}

}
