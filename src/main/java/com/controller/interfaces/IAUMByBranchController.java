package com.controller.interfaces;

import java.util.List;

import com.entity.bonanza.AUMByBranchMini;


public interface IAUMByBranchController {
	
	public int getCountByCriteriaSearch(AUMByBranchMini criteriaSearch);
	
	public List<Double> getSumAumBranchByYear(String year);

}