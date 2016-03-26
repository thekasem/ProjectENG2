package com.entity.bonanza;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RM_PROFILE")
public class RMProfileMini {
	
	@Id
	@GeneratedValue
	@Column(name = "RMID")
	private int rmId;
	
	@Column(name = "RMCODE")
	private String rmCode;
	
	@Column(name = "FIRSTNAMEEN")
	private String firstNameEn;
	
	@Column(name = "LASTNAMEEN")
	private String lastNameEn;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "NICKNAME")
	private String nickName;
	
	@Column(name = "GENDER")
	private char gender;
	
	@Column(name = "JOINSINCE")
	private char joinSince;
	
	@Column(name = "STATUS")
	private char status;
	
	@Column(name = "DATEOFBIRTH")
	private String dateOfBirth;
	
	@Column(name = "NATIONALITYID")
	private int nationalityId;
	
	@Column(name = "RELIGIONID")
	private int religionId;
	
	@Column(name = "EDUCATIONID")
	private int educationId;
	
	@Column(name = "PERSONALITYID")
	private int personalityId;
	
	@Column(name = "LANGUAGEID")
	private int languageId;
	
	@Column(name = "CONTACTNUMBER")
	private String contactNumber;
	
	@Column(name = "MOBILEPHONE")
	private String mobilephone;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "TOMBOLID")
	private int tombolId;
	
	@Column(name = "AMPORID")
	private int amporId;
	
	@Column(name = "PROVINCEID")
	private int provinceId;
	
	@Column(name = "COUNTRYID")
	private int countryId;
	
	@Column(name = "ZIPCODE")
	private String zipCode;
	
	@Column(name = "FAX")
	private String fax;
	
	@Column(name = "BRANCHID")
	private int branchId;
	
	@Column(name = "LISTENINGLEVEL")
	private int listeningLevel;
	
	@Column(name = "SPEAKINGLEVEL")
	private int speakingLevel;
	
	@Column(name = "READINGLEVEL")
	private int readingLevel;

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public String getRmCode() {
		return rmCode;
	}

	public void setRmCode(String rmCode) {
		this.rmCode = rmCode;
	}

	public String getFirstNameEn() {
		return firstNameEn;
	}

	public void setFirstNameEn(String firstNameEn) {
		this.firstNameEn = firstNameEn;
	}

	public String getLastNameEn() {
		return lastNameEn;
	}

	public void setLastNameEn(String lastNameEn) {
		this.lastNameEn = lastNameEn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public char getJoinSince() {
		return joinSince;
	}

	public void setJoinSince(char joinSince) {
		this.joinSince = joinSince;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public int getEducationId() {
		return educationId;
	}

	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}

	public int getPersonalityId() {
		return personalityId;
	}

	public void setPersonalityId(int personalityId) {
		this.personalityId = personalityId;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTombolId() {
		return tombolId;
	}

	public void setTombolId(int tombolId) {
		this.tombolId = tombolId;
	}

	public int getAmporId() {
		return amporId;
	}

	public void setAmporId(int amporId) {
		this.amporId = amporId;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getListeningLevel() {
		return listeningLevel;
	}

	public void setListeningLevel(int listeningLevel) {
		this.listeningLevel = listeningLevel;
	}

	public int getSpeakingLevel() {
		return speakingLevel;
	}

	public void setSpeakingLevel(int speakingLevel) {
		this.speakingLevel = speakingLevel;
	}

	public int getReadingLevel() {
		return readingLevel;
	}

	public void setReadingLevel(int readingLevel) {
		this.readingLevel = readingLevel;
	}
}