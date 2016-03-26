package com.entity.bonanza;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CM_MEMBER")
public class MemberMini {
	
	@Id
	@Column(name = "MEMBERID")
	private int memberId;
	
	@Column(name = "LOGINNAME")
	private String loginName;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name ="MEMBERSINCE")
	private String memberSince;
	
	@Column(name = "STATUS")
	private char status;
	
	@Column(name = "ADDRESSID")
	private int addressId;
	
	@Column(name = "LOGINGFAULT")
	private int loginFault;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name = "LASTNAME")
	private String lastName;
	
	@Column(name ="CREATEDATE")
	private String createDate;
	
	@Column(name ="CREATETIME")
	private String createTime;
	
	@Column(name = "CREATEBY")
	private int createBy;
	
	@Column(name = "CREATEBYNAME")
	private String createByName;
	
	@Column(name = "LASTUPDATEDATE")
	private String lastUpdateDate;
	
	@Column(name = "LASTUPDATETIME")
	private String lastUPdateTime;
	
	@Column(name = "LASTUPDATEBY")
	private int lastUpdateBy;
	
	@Column(name = "LASTUPDATEBYNAME")
	private String lastUpdateByName;
	
	@Column(name = "EMPLOYEECODE")
	private String employeeCode;
	
	@Column(name = "FIRSTNAMEEN")
	private String firstNameEn;
	
	@Column(name = "LASTNAMEEN")
	private String lastNameEn;

	@Column(name = "MOBILE")
	private String mobile;
	
	@Column(name = "EMAIL")
	private String email;
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(String memberSince) {
		this.memberSince = memberSince;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getLoginFault() {
		return loginFault;
	}

	public void setLoginFault(int loginFault) {
		this.loginFault = loginFault;
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

	public String getLastUPdateTime() {
		return lastUPdateTime;
	}

	public void setLastUPdateTime(String lastUPdateTime) {
		this.lastUPdateTime = lastUPdateTime;
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

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}