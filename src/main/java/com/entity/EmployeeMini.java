package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeMini {

	@Id
	@Column(name = "EMPLOYEEID")
	private int employeeID;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "DATEOFBIRTH")
	private String dateOfBirth;

	@Column(name = "CREATEDATE")
	private String createDate;

	@Column(name = "PHONE")
	private String phone;

}
