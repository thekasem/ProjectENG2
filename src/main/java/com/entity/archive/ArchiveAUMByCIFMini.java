package com.entity.archive;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="CRM_ARCHIVEAUMBYCIF")
public class ArchiveAUMByCIFMini {
	
	@Id
	@Column(name = "AUMBYCIFID")
	private int aumbyCifId;
	
	@Column(name = "CUSTOMER_NAMEEN")	
	private String customerNameEn;
	
	@Column(name = "CUSTTOMER_NAMEOTHER")
	private String customerNameOther;
	
	@Column(name = "AUMDATE")
	private String aumDate;
	
	@Column(name = "AUMMARKET_VALUE")
	private String aumMarketValue;
	
	@Column(name = "REMARK")
	private BigDecimal remark;
	
	@Column(name = "CREATEDATE")
	private String createDate;
	
	@Column(name = "CREATEBY")
	private String createBy;
	
	@Column(name = "CREATEBYNAME")
	private String createByName;
	
	@Column(name ="LASTUPDATEDATE")
	private String lastUpdateDate;
	
	@Column(name = "LASTUPDATETIME")
	private String lastUpdateTime;
	
	@Column(name ="LASTUPDATEBY")
	private int lastUpdateBy;
	
	@Column(name = "LASTUPDATEBYNAME")
	private String lastUpdatByName;
	
	@Column(name ="USERARCHIVE")
	private String userArchive;
	
	@Column(name = "DATEARCHIVE")
	private String dateArchive;
	
	@Column(name = "CONDITIONARCHIVE")
	private String coditionArhcive;

	public int getAumbyCifId() {
		return aumbyCifId;
	}

	public void setAumbyCifId(int aumbyCifId) {
		this.aumbyCifId = aumbyCifId;
	}

	public String getCustomerNameEn() {
		return customerNameEn;
	}

	public void setCustomerNameEn(String customerNameEn) {
		this.customerNameEn = customerNameEn;
	}

	public String getCustomerNameOther() {
		return customerNameOther;
	}

	public void setCustomerNameOther(String customerNameOther) {
		this.customerNameOther = customerNameOther;
	}

	public String getAumDate() {
		return aumDate;
	}

	public void setAumDate(String aumDate) {
		this.aumDate = aumDate;
	}

	public String getAumMarketValue() {
		return aumMarketValue;
	}

	public void setAumMarketValue(String aumMarketValue) {
		this.aumMarketValue = aumMarketValue;
	}

	public BigDecimal getRemark() {
		return remark;
	}

	public void setRemark(BigDecimal remark) {
		this.remark = remark;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateByName() {
		return createByName;
	}

	public void setCreateByName(String createByName) {
		this.createByName = createByName;
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

	public int getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(int lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public String getLastUpdatByName() {
		return lastUpdatByName;
	}

	public void setLastUpdatByName(String lastUpdatByName) {
		this.lastUpdatByName = lastUpdatByName;
	}

	public String getUserArchive() {
		return userArchive;
	}

	public void setUserArchive(String userArchive) {
		this.userArchive = userArchive;
	}

	public String getDateArchive() {
		return dateArchive;
	}

	public void setDateArchive(String dateArchive) {
		this.dateArchive = dateArchive;
	}

	public String getCoditionArhcive() {
		return coditionArhcive;
	}

	public void setCoditionArhcive(String coditionArhcive) {
		this.coditionArhcive = coditionArhcive;
	}
	
	
	}
