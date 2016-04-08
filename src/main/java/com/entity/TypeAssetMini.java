package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TYPEASSET")
public class TypeAssetMini {

	@Id
	@Column(name = "TYPEASSETID")
	private int typeAssesId;

	@Column(name = "TYPEASSETNAME")
	private String typeAssetName;

	public int getTypeAssesId() {
		return typeAssesId;
	}

	public void setTypeAssesId(int typeAssesId) {
		this.typeAssesId = typeAssesId;
	}

	public String getTypeAssetName() {
		return typeAssetName;
	}

	public void setTypeAssetName(String typeAssetName) {
		this.typeAssetName = typeAssetName;
	}

	
	
}
