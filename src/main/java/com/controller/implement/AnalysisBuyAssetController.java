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
				true, '3');
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieCustomer(String fromDate, String toDate) {
		List<Object[]> values = buyAssetDao.getSumTypeCustomerValues(fromDate,
				toDate, false, '3');
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieAsset() {
		List<Object[]> values = buyAssetDao.getSumTypeAssetValues("", "", true,
				'3');
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieAsset(String fromDate, String toDate) {
		List<Object[]> values = buyAssetDao.getSumTypeAssetValues(fromDate,
				toDate, false, '3');
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieEachCustomer(String assetId) {
		List<String> listDate = buyAssetDao.getListYear();
		List<Object[]> values = buyAssetDao.getSumValuesByCustomer(
				listDate.get(0)+"01", listDate.get(listDate.size()-1)+"12", false, assetId,
				'1');
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieEachCustomer(String fromDate,
			String toDate, String assetId) {
		List<Object[]> values = buyAssetDao.getSumValuesByCustomer(fromDate,
				toDate, false, assetId, '1');
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieEachAsset(String customerId) {
		List<String> listDate = buyAssetDao.getListYear();
		List<Object[]> values = buyAssetDao.getSumValuesByAsset(
				listDate.get(0)+"01", listDate.get(listDate.size()-1)+"12", false,
				customerId, '1');
		List<Double> result = percentOfValues(values);
		return result;
	}

	public List<Double> getValuesPieEachAsset(String fromDate, String toDate,
			String customerId) {
		List<Object[]> values = buyAssetDao.getSumValuesByAsset(fromDate,
				toDate, false, customerId, '1');
		List<Double> result = percentOfValues(values);
		return result;
	}



	public List<String> getDateList(String selectTime, String fromYear,
			String toYear, String fromMonth, String toMonth, String toYearII) {
		List<String> result = new ArrayList<String>();
		if (selectTime.trim().equals("1")) {
			result = buyAssetDao.getListYear();

		} else if (selectTime.trim().equals("2")) {
			int dateQuartar = Math.abs(Integer.parseInt(toYear.trim())
					- Integer.parseInt(fromYear.trim())) + 1;
			if (Integer.parseInt(toYear) >= Integer.parseInt(fromYear)) {
				for (int i = 0; i < dateQuartar; i++) {
					int y = 0;
					int fromYEAR = Integer.parseInt(fromYear) + i;
					for (y = 1; y <= 4; y++) {
						result.add(yearAndMonth(fromYEAR + "", y * 3));
					}
				}
			} else if (Integer.parseInt(toYear) < Integer.parseInt(fromYear)) {
				for (int i = dateQuartar; i >= 0; i++) {
					int y = 4;
					int toYEAR = Integer.parseInt(toYear) + i;
					for (y = 4; y >= 1; y--) {
						result.add(yearAndMonth(toYEAR + "", y / 3));
					}
				}
			}

		} else if (selectTime.trim().equals("3")) {
			int temp = Math.abs(Integer.parseInt(toMonth)
					- Integer.parseInt(fromMonth)) + 1;

			if (Integer.parseInt(toMonth) > Integer.parseInt(fromMonth)) {
				for (int i = 0; i < temp; i++) {
					result.add(yearAndMonth(toYearII,
							(Integer.parseInt(fromMonth)) + i)
							+ "");
				}
			} else if (Integer.parseInt(toMonth) < Integer.parseInt(fromMonth)) {
				for (int i = temp; i > 0; i--) {
					result.add(yearAndMonth(toYearII,
							(Integer.parseInt(toMonth)) - i)
							+ "");
				}
			}
		}
		return result;
	}
	
	private Object[]  setResult(List<Object[]> listSum){
		Object[] temp = new Object[listSum.size()];
		int i = 0;
		for (Object[] sum : listSum) {
			if (sum[0] != null) {
				temp[i] = sum[0];
			} else {
				temp[i] = 0;
			}
			i++;
		}
		return temp;
	}

	public List<Object[]> getValueCutomer(List<String> dateList,
			String selectTime) {
		List<Object[]> result = new ArrayList<Object[]>();
		for (String date : dateList) {
			List<Object[]> listSumTypeCustomer = new ArrayList<Object[]>();

			if (selectTime.trim().equals("1")) {
				listSumTypeCustomer = buyAssetDao.getSumTypeCustomerValues(date
						+ "01", date + "12", false, '3');
			} else if (selectTime.trim().equals("2")) {
				listSumTypeCustomer = buyAssetDao.getSumTypeCustomerValues(
						(Integer.parseInt(date) - 3) + "", date, false, '3');
			} else if (selectTime.trim().equals("3")) {
				listSumTypeCustomer = buyAssetDao.getSumTypeCustomerValues(
						date, date, false, '3');
			}

			result.add(setResult(listSumTypeCustomer));

		}
		return result;
	}

	public List<Object[]> getValueAsset(List<String> dateList, String selectTime) {
		List<Object[]> result = new ArrayList<Object[]>();
		for (String date : dateList) {
			List<Object[]> listSumTypeAsset = new ArrayList<Object[]>();

			if (selectTime.trim().equals("1")) {
				listSumTypeAsset = buyAssetDao.getSumTypeAssetValues(date
						+ "01", date + "12", false, '3');
			} else if (selectTime.trim().equals("2")) {
				listSumTypeAsset = buyAssetDao.getSumTypeAssetValues(
						(Integer.parseInt(date) - 3) + "", date, false, '3');
			} else if (selectTime.trim().equals("3")) {
				listSumTypeAsset = buyAssetDao.getSumTypeAssetValues(date,
						date, false, '3');
			}

			result.add(setResult(listSumTypeAsset));

		}
		return result;
	}

	public List<Object[]> getValueEachCustomer(List<String> dateList,
			String selectTime, String assetId) {
		List<Object[]> result = new ArrayList<Object[]>();
		for (String date : dateList) {
			List<Object[]> listSumTypeCustomer = new ArrayList<Object[]>();

			if (selectTime.trim().equals("1")) {
				listSumTypeCustomer = buyAssetDao.getSumValuesByCustomer(date
						+ "01", date + "12", false, assetId, '1');
			} else if (selectTime.trim().equals("2")) {
				listSumTypeCustomer = buyAssetDao.getSumValuesByCustomer(
						(Integer.parseInt(date) - 3) + "", date, false, assetId, '1');
			} else if (selectTime.trim().equals("3")) {
				listSumTypeCustomer = buyAssetDao.getSumValuesByCustomer(
						date, date, false, assetId, '1');
			}

			result.add(setResult(listSumTypeCustomer));

		}
		return result;
	}

	public List<Object[]> getValueEachAsset(List<String> dateList,
			String selectTime, String customerId) {
		List<Object[]> result = new ArrayList<Object[]>();
		for (String date : dateList) {
			List<Object[]> listSumTypeAsset = new ArrayList<Object[]>();

			if (selectTime.trim().equals("1")) {
				listSumTypeAsset = buyAssetDao.getSumValuesByAsset(date
						+ "01", date + "12", false, customerId, '1');
			} else if (selectTime.trim().equals("2")) {
				listSumTypeAsset = buyAssetDao.getSumValuesByAsset(
						(Integer.parseInt(date) - 3) + "", date, false, customerId, '1');
			} else if (selectTime.trim().equals("3")) {
				listSumTypeAsset = buyAssetDao.getSumValuesByAsset(date,
						date, false, customerId, '1');
			}

			result.add(setResult(listSumTypeAsset));

		}
		return result;
	}
	
	

	/*
	 * public List<Object[]> getValueCutomer(String selectTime, String fromYear,
	 * String toYear, String fromMonth, String toMonth, String toYearII) {
	 * List<Object[]> result = new ArrayList<Object[]>();
	 * if(selectTime.trim().equals("1")){
	 * 
	 * }else if(selectTime.trim().equals("2")){
	 * 
	 * }else if(selectTime.trim().equals("3")){
	 * 
	 * } return result; }
	 */

}
