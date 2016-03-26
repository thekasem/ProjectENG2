package com.json.actions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactAUMByBranch;
import com.contact.action.ContactAUMByCIF;
import com.contact.action.ContactPortHoldingBySubAccount;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ViewAUMJsonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2656397936123464544L;

	private String[] asset = { "AUM BY CIF", "AUM BY Branch", "Portholding" };

	private List<Double> dataAUMBYCIF = new ArrayList<Double>();
	private List<Double> dataAUMBYBranch = new ArrayList<Double>();
	private List<Double> dataPortholding = new ArrayList<Double>();

	private String year = "";
	private ContactAUMByCIF ControllerAUMByCIF;
	private ContactAUMByBranch ControllerAUMByBranch;
	private ContactPortHoldingBySubAccount ControllerPortHoldingBySubAccount;

	public void contactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		ControllerAUMByCIF = (ContactAUMByCIF) context.getBean("aumByCIF");
		ControllerAUMByBranch = (ContactAUMByBranch) context
				.getBean("aumByBranch");
		ControllerPortHoldingBySubAccount = (ContactPortHoldingBySubAccount) context
				.getBean("portHoldingBySubAccount");
	}

	public String execute() {
		contactController();
		dataAUMBYBranch = ControllerAUMByBranch.getSumAumBranchByYear(year);
		dataAUMBYCIF = ControllerAUMByCIF.getSumAumCIFByYear(year);
		dataPortholding = ControllerPortHoldingBySubAccount
				.getSumAumSubAccByYear(year);
		return Action.SUCCESS;
	}

	public String[] getAsset() {
		return asset;
	}

	public void setAsset(String[] asset) {
		this.asset = asset;
	}

	public List<Double> getDataAUMBYCIF() {
		return dataAUMBYCIF;
	}

	public List<Double> getDataAUMBYBranch() {
		return dataAUMBYBranch;
	}

	public List<Double> getDataPortholding() {
		return dataPortholding;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}