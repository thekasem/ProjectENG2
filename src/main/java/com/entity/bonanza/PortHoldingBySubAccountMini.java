package com.entity.bonanza;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="CRM_PORTHOLDINGBYSUBACCOUNT")
public class PortHoldingBySubAccountMini {

	@Id
	@GeneratedValue
	@Column(name = "PORTHOLDINGID")
	private int portHoldingId;
	
	@Column(name = "SUBACCOUNTID")
	private int subAccountId;
	
	@Column(name = "SUBACCOUNTNO")
	private String subAccountNO;
	
	@Column(name = "ACCOUNTID")
	private int accountId;
	
	@Column(name = "ACCOUNTNAME")
	private String accountName;
	
	@Column(name = "INTRUMENTID")
	private int intrumentId;
	
	@Column(name ="SYMBOL")
	private String symbol;
	
	@Column(name ="SECURUTYTYPEID")
	private int securityTypeId;
	
	@Column(name = "SECURUTYTYPECODE")
	private String securityTypeCode;
	
	@Column(name = "PRODUCTTYPEID")
	private int productTypeId;
	
	@Column(name = "PRODUCTTYPECODE")
	private String productTypeCode;
	
	@Column(name = "PRODUCTTYPEGROUPID")
	private int productTypeGroupId;
	
	@Column(name = "PRODUCTTYPEGROUPCODE")
	private String productTypeGroupCode;
	
	@Column(name = "PRODUCTCLASSID")
	private int productClassId;
	
	@Column(name = "PRODUCTTYPECLASSCODE")
	private String productTypeClassCode;
	
	@Column(name = "BALANCESHEETGROUPID")
	private int balanceSheetGroupId;
	
	@Column(name = "BALANCESHEETGROUPCODE")
	private String balanceSheetGroupCode;
	
	@Column(name = "BRANCHID")
	private int branchId;
	
	@Column(name = "BRANCHCODE")
	private String branchCode;
	
	@Column(name = "CURRENCYID")
	private int currencyId;
	
	@Column(name = "CURRENCYCODE")
	private String currencyCode;
	
	@Column(name = "CUSTOMERNAMEEN")
	private String customerNameEn;
	
	@Column(name = "CUSTOMERNAMEORTHER")
	private String customerNameOther;
	
	@Column(name = "UNREAIZEDGL")
	private BigDecimal unreaizadgl;
	
	@Column(name = "PORTFOLIOID")
	private int portFolioId;
	
	@Column(name = "PORTFOLIOCODE")
	private String portFolioCode;
	
	@Column(name = "AUMDATE")
	private String aumDate;
	
	@Column(name = "LOCALMARKETVALUE")
	private BigDecimal localMarketValue;
	
	@Column(name = "LOCALLACCRUEDINTEREST")
	private BigDecimal localLaccruedinterest;
	
	@Column(name = "MARKETVALUE")
	private double marketValue;
	
	@Column(name = "REMARK")
	private String remark;
	
	@Column(name ="CREATEDATE")
	private String createDate;
	
	@Column(name = "CREATETIME")
	private String createTime;
	
	@Column(name = "CREATEBY")
	private int createBy;
	
	@Column(name = "CREATEBYNAME")
	private String createByName;
	
	@Column(name = "LASTUPDATEDATE")
	private String lastUpdateDate;
	
	@Column(name = "LASTUPDATETIME")
	private String lastUpdateTime;
	
	@Column(name ="LASTUPDATEBY")
	private int lastUpdateBy;
	
	@Column(name = "LASTUPDATEBYNAME")
	private String lastUpdateByName;
	
	@Column(name ="ACTUALRATE")
	private BigDecimal actualrate;
	
	@Column(name = "BRANCHNAMEEN")
	private String branchNameEn;
	
	@Column(name = "BRANCHNAMEOTHER")
	private String branchNameOther;
	
	@Column(name = "PRODUCTTYPENAMEEN")
	private String productNameEn;
	
	@Column(name = "PRODUCTTYPENAMEOTHER")
	private String productTypeNameOther;
	
	@Column(name = "PRODUCTTYPERISKLEVEL")
	private int productTypeRiskLevel;
	
	@Column(name = "PRODUCTCLASSNAMEEN")
	private String productClassNameEn;
	
	@Column(name = "PRODUCTCLASSNAMEOTHER")
	private String productClassNameOther;
	
	@Column(name = "PRODUCTCLASSRISKLEVEL")
	private int productClassRiskLevel;
	
	@Column(name = "INS_ISSUEDATE")
	private String ins_issueDate;
	
	@Column(name = "INS_MATUREDATE")
	private String ins_matureDate;
	
	@Column(name = "SUBACC_ISSUEDATE")
	private String subAcc_issueDate;
	
	@Column(name = "SUBACC_MATUREDATE")
	private String subAcc_matureDate;
	
	@Column(name = "INTERNALTYPECODE")
	private String internalTypeCode;
	
	@Column(name = "UNIT")
	private BigDecimal unit;
	
	@Column(name = "COSTPERUNIT")
	private BigDecimal costPerUnit;
	
	@Column(name = "MARKETPERUNIT")
	private BigDecimal markePerUnit;
	
	@Column(name = "LOCALCOSTVALUE")
	private BigDecimal localCostValue;
	
	@Column(name = "MARKETYIELD")
	private BigDecimal marketYield;
	
	@Column(name = "INVESTMENT_PROPERTY")
	private BigDecimal investment_property;
	
	@Column(name = "MTMDATE")
	private  String mtmDate;
	
	@Column(name = "ACCRUEDINTEREST")
	private BigDecimal accruedInterest;
	
	@Column(name = "OUTSTADINGID")
	private int outstandingId;
	
	@Column(name = "PORTFOLIONAMEEN")
	private String portFolioNameEn;
	
	@Column(name = "PORTFOLIONAMEOTHER")
	private String portFolioNameOther;
	
	@Column(name = "ACCOUNTTYPE")
	private int accountType;
	
	@Column(name = "ISACTIVE")
	private String isActive;

	public int getPortHoldingId() {
		return portHoldingId;
	}

	public void setPortHoldingId(int portHoldingId) {
		this.portHoldingId = portHoldingId;
	}

	public int getSubAccountId() {
		return subAccountId;
	}

	public void setSubAccountId(int subAccountId) {
		this.subAccountId = subAccountId;
	}

	public String getSubAccountNO() {
		return subAccountNO;
	}

	public void setSubAccountNO(String subAccountNO) {
		this.subAccountNO = subAccountNO;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getIntrumentId() {
		return intrumentId;
	}

	public void setIntrumentId(int intrumentId) {
		this.intrumentId = intrumentId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getSecurityTypeId() {
		return securityTypeId;
	}

	public void setSecurityTypeId(int securityTypeId) {
		this.securityTypeId = securityTypeId;
	}

	public String getSecurityTypeCode() {
		return securityTypeCode;
	}

	public void setSecurityTypeCode(String securityTypeCode) {
		this.securityTypeCode = securityTypeCode;
	}

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeCode() {
		return productTypeCode;
	}

	public void setProductTypeCode(String productTypeCode) {
		this.productTypeCode = productTypeCode;
	}

	public int getProductTypeGroupId() {
		return productTypeGroupId;
	}

	public void setProductTypeGroupId(int productTypeGroupId) {
		this.productTypeGroupId = productTypeGroupId;
	}

	public String getProductTypeGroupCode() {
		return productTypeGroupCode;
	}

	public void setProductTypeGroupCode(String productTypeGroupCode) {
		this.productTypeGroupCode = productTypeGroupCode;
	}

	public int getProductClassId() {
		return productClassId;
	}

	public void setProductClassId(int productClassId) {
		this.productClassId = productClassId;
	}

	public String getProductTypeClassCode() {
		return productTypeClassCode;
	}

	public void setProductTypeClassCode(String productTypeClassCode) {
		this.productTypeClassCode = productTypeClassCode;
	}

	public int getBalanceSheetGroupId() {
		return balanceSheetGroupId;
	}

	public void setBalanceSheetGroupId(int balanceSheetGroupId) {
		this.balanceSheetGroupId = balanceSheetGroupId;
	}

	public String getBalanceSheetGroupCode() {
		return balanceSheetGroupCode;
	}

	public void setBalanceSheetGroupCode(String balanceSheetGroupCode) {
		this.balanceSheetGroupCode = balanceSheetGroupCode;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
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

	public BigDecimal getUnreaizadgl() {
		return unreaizadgl;
	}

	public void setUnreaizadgl(BigDecimal unreaizadgl) {
		this.unreaizadgl = unreaizadgl;
	}

	public int getPortFolioId() {
		return portFolioId;
	}

	public void setPortFolioId(int portFolioId) {
		this.portFolioId = portFolioId;
	}

	public String getPortFolioCode() {
		return portFolioCode;
	}

	public void setPortFolioCode(String portFolioCode) {
		this.portFolioCode = portFolioCode;
	}

	public String getAumDate() {
		return aumDate;
	}

	public void setAumDate(String aumDate) {
		this.aumDate = aumDate;
	}

	public BigDecimal getLocalMarketValue() {
		return localMarketValue;
	}

	public void setLocalMarketValue(BigDecimal localMarketValue) {
		this.localMarketValue = localMarketValue;
	}

	public BigDecimal getLocalLaccruedinterest() {
		return localLaccruedinterest;
	}

	public void setLocalLaccruedinterest(BigDecimal localLaccruedinterest) {
		this.localLaccruedinterest = localLaccruedinterest;
	}


	public double getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
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

	public String getLastUpdateByName() {
		return lastUpdateByName;
	}

	public void setLastUpdateByName(String lastUpdateByName) {
		this.lastUpdateByName = lastUpdateByName;
	}

	public BigDecimal getActualrate() {
		return actualrate;
	}

	public void setActualrate(BigDecimal actualrate) {
		this.actualrate = actualrate;
	}

	public String getBranchNameEn() {
		return branchNameEn;
	}

	public void setBranchNameEn(String branchNameEn) {
		this.branchNameEn = branchNameEn;
	}

	public String getBranchNameOther() {
		return branchNameOther;
	}

	public void setBranchNameOther(String branchNameOther) {
		this.branchNameOther = branchNameOther;
	}

	public String getProductNameEn() {
		return productNameEn;
	}

	public void setProductNameEn(String productNameEn) {
		this.productNameEn = productNameEn;
	}

	public String getProductTypeNameOther() {
		return productTypeNameOther;
	}

	public void setProductTypeNameOther(String productTypeNameOther) {
		this.productTypeNameOther = productTypeNameOther;
	}

	public int getProductTypeRiskLevel() {
		return productTypeRiskLevel;
	}

	public void setProductTypeRiskLevel(int productTypeRiskLevel) {
		this.productTypeRiskLevel = productTypeRiskLevel;
	}

	public String getProductClassNameEn() {
		return productClassNameEn;
	}

	public void setProductClassNameEn(String productClassNameEn) {
		this.productClassNameEn = productClassNameEn;
	}

	public String getProductClassNameOther() {
		return productClassNameOther;
	}

	public void setProductClassNameOther(String productClassNameOther) {
		this.productClassNameOther = productClassNameOther;
	}

	public int getProductClassRiskLevel() {
		return productClassRiskLevel;
	}

	public void setProductClassRiskLevel(int productClassRiskLevel) {
		this.productClassRiskLevel = productClassRiskLevel;
	}

	public String getIns_issueDate() {
		return ins_issueDate;
	}

	public void setIns_issueDate(String ins_issueDate) {
		this.ins_issueDate = ins_issueDate;
	}

	public String getIns_matureDate() {
		return ins_matureDate;
	}

	public void setIns_matureDate(String ins_matureDate) {
		this.ins_matureDate = ins_matureDate;
	}

	public String getSubAcc_issueDate() {
		return subAcc_issueDate;
	}

	public void setSubAcc_issueDate(String subAcc_issueDate) {
		this.subAcc_issueDate = subAcc_issueDate;
	}

	public String getSubAcc_matureDate() {
		return subAcc_matureDate;
	}

	public void setSubAcc_matureDate(String subAcc_matureDate) {
		this.subAcc_matureDate = subAcc_matureDate;
	}

	public String getInternalTypeCode() {
		return internalTypeCode;
	}

	public void setInternalTypeCode(String internalTypeCode) {
		this.internalTypeCode = internalTypeCode;
	}

	public BigDecimal getUnit() {
		return unit;
	}

	public void setUnit(BigDecimal unit) {
		this.unit = unit;
	}

	public BigDecimal getCostPerUnit() {
		return costPerUnit;
	}

	public void setCostPerUnit(BigDecimal costPerUnit) {
		this.costPerUnit = costPerUnit;
	}

	public BigDecimal getMarkePerUnit() {
		return markePerUnit;
	}

	public void setMarkePerUnit(BigDecimal markePerUnit) {
		this.markePerUnit = markePerUnit;
	}

	public BigDecimal getLocalCostValue() {
		return localCostValue;
	}

	public void setLocalCostValue(BigDecimal localCostValue) {
		this.localCostValue = localCostValue;
	}

	public BigDecimal getMarketYield() {
		return marketYield;
	}

	public void setMarketYield(BigDecimal marketYield) {
		this.marketYield = marketYield;
	}

	public BigDecimal getInvestment_property() {
		return investment_property;
	}

	public void setInvestment_property(BigDecimal investment_property) {
		this.investment_property = investment_property;
	}

	public String getMtmDate() {
		return mtmDate;
	}

	public void setMtmDate(String mtmDate) {
		this.mtmDate = mtmDate;
	}

	public BigDecimal getAccruedInterest() {
		return accruedInterest;
	}

	public void setAccruedInterest(BigDecimal accruedInterest) {
		this.accruedInterest = accruedInterest;
	}

	public int getOutstandingId() {
		return outstandingId;
	}

	public void setOutstandingId(int outstandingId) {
		this.outstandingId = outstandingId;
	}

	public String getPortFolioNameEn() {
		return portFolioNameEn;
	}

	public void setPortFolioNameEn(String portFolioNameEn) {
		this.portFolioNameEn = portFolioNameEn;
	}

	public String getPortFolioNameOther() {
		return portFolioNameOther;
	}

	public void setPortFolioNameOther(String portFolioNameOther) {
		this.portFolioNameOther = portFolioNameOther;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	
}
