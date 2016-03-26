package com.entity.archive;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CRM_ARCHIVEAUMBYBRANCH")
public class ArchiveAUMByBranchMini {
	
	@Id
	@Column(name = "AUMBYBRANCHID")
	private int aumByBranchId;
	
	@Column(name = "CUSTOMERNAMEEN")
	private String customerNameEn;
	
	@Column(name = "CUMSTOMERNAMEOTHER")
	private String customerNameOther;
	
	@Column(name = "BRANCHCODE")
	private String branchCode;
	
	@Column(name = "AUMDATE")
	private String aumDate;
	
	@Column(name = "AUMMARKETVALUE")
	private String aumMarketValue;
	
	@Column(name = "RAMARK")
	private String remark;
	
	@Column(name = "CREATEDATE")
	private String createDate;
	
	@Column(name = "CREATETIME")
	private String createTime;
	
	@Column(name = "CREATEBY")
	private int createBy;
	
	@Column(name = "CRAEATEBYNAME")
	private String createByName;
	
	@Column(name ="LASTUPDATEDATE")
	private String latUpdateDate;
	
	@Column(name = "LASTUPDATETIME")
	private String lastUpdateTime;
	
	@Column(name ="LASTUPDATEBY")
	private String lastUpdateBy;
	
	@Column(name ="LASTUPDATEBYNAME")
	private String lastUpdateByName;
		
	@Column(name ="ISMAXAUM")
	private char isMaxAUM;
	
	@Column(name = "USERARCHIVE")
	private String userArchive;
	
	@Column(name = "DATEARCHIVE")
	private String dateArchive;
	
	@Column(name = "CONDITIONARCHIVE")
	private String conditionArchive;

	public int getAumByBranchId() {
		return aumByBranchId;
	}

	public void setAumByBranchId(int aumByBranchId) {
		this.aumByBranchId = aumByBranchId;
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

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public int getCreateBy() {
		return createBy;
	}

	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}

	public String getCreateByName() {
		return createByName;
	}

	public void setCreateByName(String createByName) {
		this.createByName = createByName;
	}

	public String getLatUpdateDate() {
		return latUpdateDate;
	}

	public void setLatUpdateDate(String latUpdateDate) {
		this.latUpdateDate = latUpdateDate;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public String getLastUpdateByName() {
		return lastUpdateByName;
	}

	public void setLastUpdateByName(String lastUpdateByName) {
		this.lastUpdateByName = lastUpdateByName;
	}

	public char getIsMaxAUM() {
		return isMaxAUM;
	}

	public void setIsMaxAUM(char isMaxAUM) {
		this.isMaxAUM = isMaxAUM;
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

	public String getConditionArchive() {
		return conditionArchive;
	}

	public void setConditionArchive(String conditionArchive) {
		this.conditionArchive = conditionArchive;
	}
	
	
	}
