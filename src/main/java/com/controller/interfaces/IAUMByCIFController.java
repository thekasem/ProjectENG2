package com.controller.interfaces;

import java.util.List;

import com.entity.bonanza.AUMByCIFMini;

public interface IAUMByCIFController {

	public int getCountByCriteriaSearch(AUMByCIFMini criteriaSearch);

	public List<Double> getSumAumCIFByYear(String year);

	public List<String> getListYear();

}