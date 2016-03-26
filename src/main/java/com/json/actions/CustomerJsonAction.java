package com.json.actions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactActivityLog;
import com.contact.action.ContactBranchCustomer;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerJsonAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1702822897109065382L;

	private String customer = "Customer";

	private List<Integer> datacustomerCurrent = new ArrayList<Integer>();
	private List<Integer> datacustomerLast = new ArrayList<Integer>();
    private ContactBranchCustomer Controller;
    private String year = "";
	
	public void ContactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		Controller = (ContactBranchCustomer) context.getBean("branchcustomers");
	}
	public String execute() {
		ContactController();
		datacustomerCurrent = Controller.getDataCustomer(year);
		datacustomerLast = Controller.getDataCustomer((Integer.parseInt(year))-1+"");
		return Action.SUCCESS;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public List<Integer> getDatacustomerCurrent() {
		return datacustomerCurrent;
	}

	public List<Integer> getDatacustomerLast() {
		return datacustomerLast;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}


}