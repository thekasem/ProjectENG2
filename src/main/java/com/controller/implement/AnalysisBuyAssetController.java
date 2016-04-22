package com.controller.implement;

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
			sum = sum + Double.parseDouble(value[0]+"");
		}
		return sum;
	}
	
	private List<Double> convertToListDouble(List<Object[]> values){
		List<Double> result = null;
		for (Object[] value : values) {
			double precent = Double.parseDouble(value[0]+"");
			result.add(precent);
		}
		return result;
		
	}

	private List<Double> percentOfValues(List<Object[]> values) {
		List<Double> result = null;
		double sum = sum(values);
		for (Object[] value : values) {
			double precent = (Double.parseDouble(value[0]+"")/sum)*100;
			result.add(precent);
		}
		return result;
	}

	public List<Double> getValuesPieCustomer() {
		List<Object[]> values = buyAssetDao.getSumTypeCustomerValues("", "", true);
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieCustomer(String fromDate, String toDate) {
		List<Object[]> values = buyAssetDao.getSumTypeCustomerValues(fromDate, toDate, false);
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieAsset() {
		List<Object[]> values = buyAssetDao.getSumTypeAssetValues("", "", true);
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieAsset(String fromDate, String toDate) {
		List<Object[]> values = buyAssetDao.getSumTypeAssetValues(fromDate, fromDate, false);
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesCustomer() {
		List<Object[]> values = buyAssetDao.getSumTypeCustomerValues("", "", true);
		List<Double> result = convertToListDouble(values);
		return result;
	}

	public List<Double> getvaluesCustomer(String fromDate, String toDate) {
		List<Object[]> values = buyAssetDao.getSumTypeCustomerValues(fromDate, toDate, false);
		List<Double> result = convertToListDouble(values);
		return result;
	}

	public List<Double> getvaluesAsset() {
		List<Object[]> values = buyAssetDao.getSumTypeAssetValues("", "", true);
		List<Double> result = convertToListDouble(values);
		return result;
	}

	public List<Double> getValuesAsset(String fromDate, String toDate) {
		List<Object[]> values = buyAssetDao.getSumTypeAssetValues(fromDate, toDate, false);
		List<Double> result = convertToListDouble(values);
		return result;
	}

	public List<Double> getValuesPieEachCustomer(String assetId) {
		List<Object[]> values = buyAssetDao.getSumValuesByCustomer("","" , true, assetId);
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieEachCustomer(String fromDate,
			String toDate, String assetId) {
		List<Object[]> values = buyAssetDao.getSumValuesByCustomer(fromDate, toDate, false, assetId);
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieEachAsset(String customerId) {
		List<Object[]> values = buyAssetDao.getSumValuesByAsset("", "",true, customerId);
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieEachAsset(String fromDate, String toDate,
			String customerId) {
		List<Object[]> values = buyAssetDao.getSumValuesByAsset(fromDate, toDate, false, customerId);
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesEachCustomer(String assetId) {
		List<Object[]> values = buyAssetDao.getSumValuesByCustomer("", "", true, assetId);
		List<Double> result = convertToListDouble(values);
		return result;
	}

	public List<Double> getvaluesEachCustomer(String fromDate, String toDate,
			String assetId) {
		List<Object[]> values = buyAssetDao.getSumValuesByCustomer(fromDate, toDate, false, assetId);
		List<Double> result = convertToListDouble(values);
		return result;
	}

	public List<Double> getvaluesEachAsset(String customerId) {
		List<Object[]> values = buyAssetDao.getSumValuesByAsset("", "", false, customerId);
		List<Double> result = convertToListDouble(values);
		return result;
	}

	public List<Double> getValuesEachAsset(String fromDate, String toDate,
			String customerId) {
		List<Object[]> values = buyAssetDao.getSumValuesByAsset(fromDate, toDate, false, customerId);
		List<Double> result = convertToListDouble(values);
		return result;
	}


}
