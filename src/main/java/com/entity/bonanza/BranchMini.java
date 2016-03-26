package com.entity.bonanza;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "BRANCH")
public class BranchMini {

	@Id
	@GeneratedValue
	@Column(name ="BRANCHID")
	private int branchId;
	
	@Column(name = "SYMBOL")
	private String symbol;
	
	@Column(name = "BANKBRANCHCODE")
	private String bankBranchCode;
		
	@Column(name = "NAMEEN")
	private String nameEn;
	
	@Column(name ="NAMEOTHER")
	private String nameOther;
	
	@Column(name = "ORGENIZATIONID")
	private int orgenizationId;
	
	@Column(name = "CREATEDATE")
	private String createDate;
	
	@Column(name = "CREATETIME")
	private String createTime;
	
	@Column(name = "LASTUPDATEBY")
	private int lastUpdateBy;
	
	@Column(name = "LASTUPDATEDATE")
	private String lastUpdateDate;
	
	@Column(name = "LASTUPDATETIME")
	private String lastUpdateTime;
	
	@Column(name = "LASTUPDATEBYNAME")
	private String lastUpdateByName;
	
	@Column(name = "CURRENCYID")
	private int currencyId;
	
	@Column(name = "ADDRESS")
	private  String address;
	
	@Column(name = "COUNTRYID")
	private int countryId;
	
	@Column(name = "PROVINCEID")
	private int provinceId;
	
	@Column(name = "AMPHORID")
	private int amphorId;
	
	@Column(name = "TOMBOID")
	private int tomoId;
	
	@Column(name = "ZIPCODE")
	private String zipCode;
	
	@Column(name ="TELEPHONE")
	private String telephone;
	
	@Column(name = "FAX")
	private String fax;
	
	@Column(name = "DISCRIPTION")
	private String discription;

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getBankBranchCode() {
		return bankBranchCode;
	}

	public void setBankBranchCode(String bankBranchCode) {
		this.bankBranchCode = bankBranchCode;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameOther() {
		return nameOther;
	}

	public void setNameOther(String nameOther) {
		this.nameOther = nameOther;
	}

	public int getOrgenizationId() {
		return orgenizationId;
	}

	public void setOrgenizationId(int orgenizationId) {
		this.orgenizationId = orgenizationId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(int lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getLastUpdateByName() {
		return lastUpdateByName;
	}

	public void setLastUpdateByName(String lastUpdateByName) {
		this.lastUpdateByName = lastUpdateByName;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public int getAmphorId() {
		return amphorId;
	}

	public void setAmphorId(int amphorId) {
		this.amphorId = amphorId;
	}

	public int getTomoId() {
		return tomoId;
	}

	public void setTomoId(int tomoId) {
		this.tomoId = tomoId;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	
}
