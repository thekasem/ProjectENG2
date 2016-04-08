package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ASSET")
public class AssetMini {

	@Id
	@Column(name = "ASSETID")
	private int assetId;

	@Column(name = "ASSETNAME")
	private String assetName;

	@Column(name = "TYPEASSETID")
	private int typeAssetId;

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public int getTypeAssetId() {
		return typeAssetId;
	}

	public void setTypeAssetId(int typeAssetId) {
		this.typeAssetId = typeAssetId;
	}
	
	

}
