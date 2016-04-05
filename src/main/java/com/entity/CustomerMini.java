package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class CustomerMini {

	@Id
	@Column(name = "CUSTOMERID")
	private int customerId;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "DATEOFBIRTH")
	private String dateOfBirth;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "CREATEDATE")
	private String createDate;

	@Column(name = "EMPLOYEEID")
	private String employeeId;

	@Column(name = "TYPECUSTOMERID")
	private int typeCustomerId;

}
