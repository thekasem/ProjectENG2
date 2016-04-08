package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BUYASSET")
public class BuyAssetMini {

	@Id
	@Column(name = "AOCID")
	private int aocId;

	@Column(name = "AOCDATE")
	private String aocDate;

	@Column(name = "CUSTOMERID")
	private int customerId;

	@Column(name = "ASSETID")
	private int assetId;

	@Column(name = "VALUEAOC")
	private int valueAOC;

	@Column(name = "COST")
	private double cost;

	public int getAocId() {
		return aocId;
	}

	public void setAocId(int aocId) {
		this.aocId = aocId;
	}

	public String getAocDate() {
		return aocDate;
	}

	public void setAocDate(String aocDate) {
		this.aocDate = aocDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public int getValueAOC() {
		return valueAOC;
	}

	public void setValueAOC(int valueAOC) {
		this.valueAOC = valueAOC;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
