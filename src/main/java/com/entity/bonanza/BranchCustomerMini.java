package com.entity.bonanza;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "BRANCHCUSTOMER")
public class BranchCustomerMini {
	
		@Id
		@GeneratedValue
		@Column(name = "CUSTOMERID")
		private int customerId;
		
		@Column(name ="FIRSTNAEMEEN")
		private String firstNameEn;
		
		@Column(name ="FIRSTNAMEOTHER")
		private String firstNameOther;
		
		@Column(name = "LASTNAMEEN")
		private String lastNameEn;
		
		@Column(name ="LASTNAMEOTHER")
		private String lastNameOther;
		
		@Column(name ="AUMBYCIFID")
		private int aumByCifId;
		
		@Column(name = "RMID")
		private int rmId;
		
		@Column(name ="CREATEDATE")
		private String createDate;
		
		@Column(name ="CREATETIME")
		private String createTime;
		
		@Column(name = "CREATEBY")
		private int createBy;
		
		@Column(name ="LASTUPDATEBY")
		private int lastUpdateBy;
		
		@Column(name = "LASTUPDATEBYDATE")
		private String lastUpdateByDate;
		
		@Column(name = "LASTUPDATEBYTIME")
		private String lastUpdateByTime;
		
		@Column(name = "LASTUPDATEBYNAME")
		private String lastUpdateByName;
		
		@Column(name ="ADDRESS")
		private String address;
		
		@Column(name ="TITLEID")
		private String titleId;
		
		@Column(name ="COUNTRYID")
		private int countryId;
		
		@Column(name ="NATIONALITYID")
		private int nationalityId;
		
		@Column(name ="RELIGIONID")
		private int religionId;
		
		@Column(name ="AMPHORID")
		private int amphorId;
		
		@Column(name ="MOBILEPHONE")
		private String mobilephone;

		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public String getFirstNameEn() {
			return firstNameEn;
		}

		public void setFirstNameEn(String firstNameEn) {
			this.firstNameEn = firstNameEn;
		}

		public String getFirstNameOther() {
			return firstNameOther;
		}

		public void setFirstNameOther(String firstNameOther) {
			this.firstNameOther = firstNameOther;
		}

		public String getLastNameEn() {
			return lastNameEn;
		}

		public void setLastNameEn(String lastNameEn) {
			this.lastNameEn = lastNameEn;
		}

		public String getLastNameOther() {
			return lastNameOther;
		}

		public void setLastNameOther(String lastNameOther) {
			this.lastNameOther = lastNameOther;
		}

		public int getAumByCifId() {
			return aumByCifId;
		}

		public void setAumByCifId(int aumByCifId) {
			this.aumByCifId = aumByCifId;
		}

		public int getRmId() {
			return rmId;
		}

		public void setRmId(int rmId) {
			this.rmId = rmId;
		}

		public int getLastUpdateBy() {
			return lastUpdateBy;
		}

		public void setLastUpdateBy(int lastUpdateBy) {
			this.lastUpdateBy = lastUpdateBy;
		}

		public String getLastUpdateByDate() {
			return lastUpdateByDate;
		}

		public void setLastUpdateByDate(String lastUpdateByDate) {
			this.lastUpdateByDate = lastUpdateByDate;
		}

		public String getLastUpdateByTime() {
			return lastUpdateByTime;
		}

		public void setLastUpdateByTime(String lastUpdateByTime) {
			this.lastUpdateByTime = lastUpdateByTime;
		}

		public String getLastUpdateByName() {
			return lastUpdateByName;
		}

		public void setLastUpdateByName(String lastUpdateByName) {
			this.lastUpdateByName = lastUpdateByName;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getTitleId() {
			return titleId;
		}

		public void setTitleId(String titleId) {
			this.titleId = titleId;
		}

		public int getCountryId() {
			return countryId;
		}

		public void setCountryId(int countryId) {
			this.countryId = countryId;
		}

		public int getNationalityId() {
			return nationalityId;
		}

		public void setNationalityId(int nationalityId) {
			this.nationalityId = nationalityId;
		}

		public int getReligionId() {
			return religionId;
		}

		public void setReligionId(int religionId) {
			this.religionId = religionId;
		}

		public int getAmphorId() {
			return amphorId;
		}

		public void setAmphorId(int amphorId) {
			this.amphorId = amphorId;
		}

		public String getMobilephone() {
			return mobilephone;
		}

		public void setMobilephone(String mobilephone) {
			this.mobilephone = mobilephone;
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
		
				

}
