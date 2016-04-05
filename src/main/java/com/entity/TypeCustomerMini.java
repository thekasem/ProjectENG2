package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TYPECUSTOMER")
public class TypeCustomerMini {

	@Id
	@Column(name = "TYPECUSTOMERID")
	private int typeCustomerId;
	
	@Column(name = "TYPECUSTOMERNAME")
	private String typeCustomerName;
}
