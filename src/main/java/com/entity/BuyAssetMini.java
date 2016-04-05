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
	private long cost;
}
