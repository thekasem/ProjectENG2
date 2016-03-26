package com.contact.action;

import java.util.List;

import com.controller.interfaces.IBranchCustomerController;

public class ContactBranchCustomer implements IBranchCustomerController{
	
	IBranchCustomerController branchCustomerController;

	public IBranchCustomerController getBranchCustomerController() {
		return branchCustomerController;
	}

	public void setBranchCustomerController(
			IBranchCustomerController branchCustomerController) {
		this.branchCustomerController = branchCustomerController;
	}

	public List<Integer> getDataCustomer(String year) {
		
		return branchCustomerController.getDataCustomer(year);
	}

	public List<String> getListYear() {
		return branchCustomerController.getListYear();
	}
	
	

}
