package com.dao.implement;

import com.controller.interfaces.IAnalysisBuyAssetController;

public class AnalysisBuyAssetController implements IAnalysisBuyAssetController {
	
	
	
	private String yearAndMonth(String year, int month) {
		String result = "";
		if (month < 10) {
			result = year + "0" + Integer.toString(month);
		} else {
			result = year + Integer.toString(month);
		}
		return result;
	}

}
